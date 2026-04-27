/**
 * 
 */

import enterprise.Employee;
import enterprise.Manager;
import enterprise.OutsideConsultant;
import enterprise.Worker;
/**
 * 
 */
public class PruebaEnterprise {

	/**
	 * 
	 */
	public PruebaEnterprise() {
		// TODO Auto-generated constructor stub

;

}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 Worker[] workers = new Worker[4];
	 workers[0] = new Employee("Juan", 30, "12345678A", 19000);
	 workers[1] = new Manager("Ana", 40, "87654321B", 30000, 5000);
	 workers[2] = new OutsideConsultant("Pedro", 35, "11223344C", "Consulting S.L.", 50, 160);
	 workers[3] = new Employee("Maria", 25, "44332211D", 15000);
	 printWorker(workers);
	 System.out.println("Coste total personal: "+costeTotal(workers));

	}
	
	public static void printWorker(Worker []workers) {
		for (Worker worker: workers)
		 System.out.println("data worker: " + worker.toString());
	}
	
	public static double costeTotal (Worker [] workers) {
		double total=0;
		for (int i=0; i<workers.length;i++) {
			total=total+workers[i].monthlyPayment();	
		}
		return total;
	}

}
