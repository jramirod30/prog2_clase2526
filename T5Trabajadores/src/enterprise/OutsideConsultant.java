/**
 * 
 */
package enterprise;

/**
 * 
 */
public class OutsideConsultant extends Worker {

	private String company; // Empresa para la que trabaja el consultor
	private double rate; // Tarifa por hora
	private double hours; // Horas trabajadas al mes
	/**
	 * PRE: rate >= 0 && hours >= 0
	 * @param name
	 * @param age
	 * @param nSegSocial
	 * @param company: Empresa para la que trabaja el consultor
	 * @param rate: Tarifa por hora
	 * @param hours: Horas trabajadas al mes
	 */
	public OutsideConsultant(String name, int age, String nSegSocial,
			String company, double rate, double hours) {
		super(name, age, nSegSocial);
		this.company = company;
		this.rate = rate;
		this.hours = hours;
	}
	
	@Override
	public String toString() {
		return super.toString() + " company " + this.company + " rate " + this.rate + " hours " + this.hours;
	}

}
