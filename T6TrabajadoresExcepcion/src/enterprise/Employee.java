/**
 * 
 */
package enterprise;

import enterprise.exception.ErrorSalarioIncorrecto;
import person.exception.ErrorEdadInvalida;

/**
 * 
 */
public class Employee extends Worker {

	private double salary; //Sueldo bruto anual
	private static double SMI = 12600; // Salario Mínimo Interprofesional anual
	public static final int MINIMUN_AGE = 16; // Edad mínima para ser empleado
	/**
	 * PRE: salary >= SMI
	 * @param name
	 * @param age
	 * @param nSegSocial
	 * @param salary: sueldo bruto anual
	 * @throws ErrorEdadInvalida 
	 */
	public Employee(String name, int age, String nSegSocial, double salary)
			throws ErrorEdadInvalida, ErrorSalarioIncorrecto {
		super(name, age, nSegSocial);
		this.setSalary(salary);
		
	}
	
	public double getSalary() {
		return salary;
	}

	
	public void setSalary(double salary) throws ErrorSalarioIncorrecto {
		if(salary<Employee.SMI) {
			throw new ErrorSalarioIncorrecto(
					"Tu salario no alcanza al minimo requerido de: "+ Employee.SMI);
		}
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + " salary " + this.salary;
	}
	
	@Override
    public double monthlyPayment() {
	   return salary/14;
    }
	
	//Métodos de clase
	public static double getSMI() {
		return Employee.SMI;
	}
}
