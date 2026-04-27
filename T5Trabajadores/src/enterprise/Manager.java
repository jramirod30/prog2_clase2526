/**
 * 
 */
package enterprise;

/**
 * 
 */
public class Manager extends Employee {

	private double bonus; // Bonus mensual
	public static final double MIN_BONUS = 100; // Bonus mínimo mensual
	/**
	 * PRE: salary >= SMI && bonus >= MIN_BONUS
	 * @param name
	 * @param age
	 * @param nSegSocial
	 * @param salary
	 * @param bonus: Bonus mensual
	 */
	public Manager(String name, int age, String nSegSocial, double salary, double bonus) {
		super(name, age, nSegSocial, salary);
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + " bonus " + this.bonus;
	}
	
	@Override
	public double monthlyPayment() {
		return super.monthlyPayment()+bonus;
	}

}
