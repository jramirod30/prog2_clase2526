/**
 * 
 */
package enterprise;

/**
 * 
 */
public class Employee extends Worker {

	private double salary; //Sueldo bruto anual
	public static final double SMI = 12600; // Salario Mínimo Interprofesional anual
	/**
	 * PRE: salary >= SMI
	 * @param name
	 * @param age
	 * @param nSegSocial
	 * @param salary: sueldo bruto anual
	 */
	public Employee(String name, int age, String nSegSocial, double salary) {
		super(name, age, nSegSocial);
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + " salary " + this.salary;
	}
	
	@Override
    public double monthlyPayment() {
	   return salary/14;
    }
}
