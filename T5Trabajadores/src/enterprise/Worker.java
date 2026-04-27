/**
 * 
 */
package enterprise;

import person.Person;

/**
 * 
 */
public abstract class Worker extends Person {
	private String nSegSocial;
	/**
	 * @param name
	 * @param age
	 */
	public Worker(String name, int age, String nSegSocial) {
		super(name, age);
		// TODO Auto-generated constructor stub
		this.nSegSocial = nSegSocial;
	}
	
	public String getnSegSocial() {
		return nSegSocial;
	}
	
	@Override
	public String toString() {
		return super.toString() + " nSegSocial " + this.nSegSocial;
	}
	
	public abstract double monthlyPayment();

}
