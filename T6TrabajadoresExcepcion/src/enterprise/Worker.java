/**
 * 
 */
package enterprise;

import person.Person;
import person.exception.ErrorEdadInvalida;

/**
 * 
 */
public abstract class Worker extends Person {
	private String nSegSocial;
	public final static int MINIMUM_AGE = 14;
	/**
	 * @param name
	 * @param age
	 * @throws ErrorEdadInvalida 
	 */
	
	public Worker(String name, int age, String nSegSocial) throws ErrorEdadInvalida {
		super(name, age);
		if(age<Worker.MINIMUM_AGE) {
			throw new ErrorEdadInvalida(
					"Tu trabajador no cumple la edad minima permitida de:" + Worker.MINIMUM_AGE);
		}
		// TODO Auto-generated constructor stub
		this.nSegSocial = nSegSocial;
	}
	
	public String getnSegSocial() {
		return nSegSocial;
	}
	
	@Override
	public void setAge(int age) throws ErrorEdadInvalida{
		if (age < Worker.MINIMUM_AGE) {
			throw new ErrorEdadInvalida (
					"Tu trabajador no cumple la edad minima permitida de:" + Worker.MINIMUM_AGE);
		}
		super.setAge(age);
	}
	
	@Override
	public String toString() {
		return super.toString() + " nSegSocial " + this.nSegSocial;
	}
	
	public abstract double monthlyPayment();

}
