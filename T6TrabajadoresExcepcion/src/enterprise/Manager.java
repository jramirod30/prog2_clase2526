/**
 * 
 */
package enterprise;

import enterprise.exception.ErrorBonusIncorrecto;
import enterprise.exception.ErrorSalarioIncorrecto;
import person.exception.ErrorEdadInvalida;

/**
 * 
 */
public class Manager extends Employee {

	private double bonus; // Bonus mensual
	public static double MIN_BONUS = 100; // Bonus mínimo mensual
	/**
	 * PRE: salary >= SMI && bonus >= MIN_BONUS
	 * @param name
	 * @param age
	 * @param nSegSocial
	 * @param salary
	 * @param bonus: Bonus mensual
	 * @throws ErrorSalarioIncorrecto 
	 * @throws ErrorEdadInvalida 
	 */
	public Manager(String name, int age, String nSegSocial, double salary, double bonus) throws ErrorBonusIncorrecto, ErrorEdadInvalida, ErrorSalarioIncorrecto{
		super(name, age, nSegSocial, salary);
		if(bonus < MIN_BONUS)
		{
			throw new ErrorBonusIncorrecto("El bonus que has seleccionado es menor que " + MIN_BONUS);
		}
		
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
	
	//Métodoos de clase
	public static double getMinBonus() {
		return Manager.MIN_BONUS;
	}
	

}
