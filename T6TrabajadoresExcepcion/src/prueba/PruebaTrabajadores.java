/**
 * 
 */
package prueba;

import person.Person;
import person.exception.ErrorEdadInvalida;
import list.ArrayList;

import java.util.NoSuchElementException;
import java.util.Scanner;

import enterprise.*;
import enterprise.exception.ErrorBonusIncorrecto;
import enterprise.exception.ErrorSalarioIncorrecto;


/**
 * 
 */
public class PruebaTrabajadores {
	
	public static void listarDatosPersons(Person [] personas) {
		for(int i=0;i<personas.length;i++){
			System.out.println("Datos persona["+i+"]: "+personas[i]);
		}
		
	}
	
	public static double costeMensualPlantilla(Worker [] trabajadores) {
		double total = 0.0;
		for (Worker trabajador : trabajadores) {
			total += trabajador.monthlyPayment();
		}
		
		return total;
	}
	
	public static void leerDatos(Scanner lector, String [] preguntas,
			ArrayList<String> respuestas) {
		int pos = respuestas.size(); //Tenemos el tamaño y añadimos al final
		int pregunta = 0;
		while (pregunta < preguntas.length) {//W
			try {
				System.out.print("\n" + preguntas[pregunta]);
				String respuesta = lector.next();
				respuestas.add(pos, respuesta);
				pregunta++;
				pos ++;
			}
			catch (NoSuchElementException|IllegalStateException  e){
				System.out.println("\n Error al leer inténtelo de nuevo");
			}
				
		}//W
	}

	private static void pedirDatosTrabajador(Scanner lector, ArrayList<String> datos){
		String[] preguntar = {"nombre: ", "edad (debe tener al menos "+Employee.MINIMUN_AGE+"): ",
				"noSS: "};
		PruebaTrabajadores.leerDatos(lector, preguntar, datos);
	}
	
	private static void pedirDatosEmployee(Scanner lector, ArrayList<String> datos){
      //TODO
	}

	
	public static Employee leerEmpelado(Scanner lector) {
		Employee empleado = null;
		while (empleado == null) {//W
			try {//try
				ArrayList<String> datosEmployee = new ArrayList<>();
				System.out.println("Dame los datos del empleado");
				PruebaTrabajadores.pedirDatosEmployee(lector, datosEmployee);
				empleado = new Employee(datosEmployee.get(0), //Nombre
												 Integer.parseInt(datosEmployee.get(1)), //Edad
												 datosEmployee.get(2), //noSS
												 Double.parseDouble(datosEmployee.get(3)) //Salario bruto anual
												 );
			}//try
			catch (NumberFormatException e) {
				System.out.println ("La edad o el salario introducidos tienen un formato incorrecto: " + e.getMessage());
				System.out.println("Vuelva a intentarlo");
			} catch (IndexOutOfBoundsException e) {
				// Este error no debería pasar
				e.printStackTrace();
			} catch (ErrorEdadInvalida e) {
				System.out.println("La edad introducida no es válida: "+ e.getMessage());
				System.out.println("Vuelva a intentarlo");
			} catch (ErrorSalarioIncorrecto e) {
				System.out.println("El salario introducido no es válido: "+ e.getMessage());
				System.out.println("Vuelva a intentarlo");
			}	
		}//W
		
		return empleado;
	}

	public static Manager leerManager(Scanner lector) {//leerManager
		Manager manager = null;
		while(manager == null) {//W
			//TODO
			
		}//W
		return manager;
	}//leerManager
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		Worker [] listadoTrabajadores = new Worker[2];
		/*listadoTrabajadores[0] = new Manager("Person2", 30, "23KQ12233", 60000, 320);
		listadoTrabajadores[1] = new Employee("Person3", 30, "34KQ12233", 20000);
		listadoTrabajadores[2] = new OutsideConsultant("Person4", 30, "55KQ12233",
				20, 10.33, "Trabajos");
		listadoTrabajadores[3] = new Manager("Manager", 30, "75KQ12233", 40000, 250);
		*/
		listadoTrabajadores[0] = PruebaTrabajadores.leerEmpelado(lector);
		listadoTrabajadores[1] = PruebaTrabajadores.leerManager(lector);
		listarDatosPersons(listadoTrabajadores);
		double costeTotal = costeMensualPlantilla(listadoTrabajadores);
		System.out.println("El coste total es de: " + costeTotal + "€");
	}
	
/*	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		Employee empleado =  PruebaTrabajadores.leerEmpelado(lector);
		System.out.println("Employee leido: " + empleado);
		
	}*/
}
