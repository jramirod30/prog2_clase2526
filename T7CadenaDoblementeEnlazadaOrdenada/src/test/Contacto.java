package test;

import java.time.LocalDate;
import java.time.Period;

/**
 * Esta clase represneta a una persona.
 * En este caso la persona tiene un nombre, unos apellidos, una edad y un email
 * @author agonzalez
 *
 */
public class Contacto implements Comparable<Contacto>{
	/**
	 * Este atributo contiene el nombre de la peronsa
	 */
	private String nombre; //Nombre del contacto
	/**
	 * Este atrobito contiene los apellidos del contacto
	 */
	private String apellidos; //Apellidos del contacto
	/**
	 * Este atributo contiene el email del contacto
	 */
	private String email; //Email del contacto
	/**
	 * Contien el teléfono del conctacto
	 */
	private String telef; //Teléfono del contacto
//	/**
//	 * Este atibuto contiene la edad de la perosna. Sería mejor usar java.util.Calendar o java.util.GregorianCalendar
//	 *  y calcular la edad
//	 */
//	private int edad; //Edad del contacto -> Lo ideal sería tener la fecha de nacimiento para poder calcular la edad (java.util.Calendar o java.util.GregorianCalendar)
	private LocalDate fechaNacimiento;
	/**
	 * Constructor 
	 * @param nombre nombre del contacto
	 * @param apellidos apellido o apellidos de la persoma
	 * @param email dirección de correo electrónico
	 * @param telef teléfono del contacto
	 * @param dia entero que representa el día en el que nace la persona
	 * @param mes entero que represnta el mes en el que nace la persona
	 * @param anio entero que represnta el año en el que nace la persona
	 */
	public Contacto(String nombre, String apellidos, String email, String telef, 
			int dia, int mes, int anio) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.setTelef(telef);
		this.fechaNacimiento = LocalDate.of(anio, mes, dia);
	}

	/**
	 * Constructor 
	 * @param nombre nombre del contacto
	 * @param apellidos apellido o apellidos de la persoma
	 * @param email dirección de correo electrónico
	 * @param dia entero que representa el día en el que nace la persona
	 * @param mes entero que represnta el mes en el que nace la persona
	 * @param anio entero que represnta el año en el que nace la persona
	 */
	public Contacto(String nombre, String apellidos, String email, 
			int dia, int mes, int anio) {
		this(nombre, apellidos, email, "", dia, mes, anio);
	}
	
	/**
	 * Construcotr que solo requiere nombre y apellidos. (sobrecarga de constructores)
	 * @param nombre nombre que tiene el contacto
	 * @param apellidos apellidos que tiene el contacto
	 */
	public Contacto(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * Constructor copia. Se en carga de sacar una copia exácta del código
	 * @param contacto contaco a copiar
	 */
	public Contacto (Contacto contacto) {
		this (contacto.nombre,contacto.apellidos);
		this.setTelef(telef);
		this.email = contacto.email;
		if (contacto.fechaNacimiento !=null)
		{
			this.fechaNacimiento =  LocalDate.of(contacto.fechaNacimiento.getYear(),
									contacto.fechaNacimiento.getMonth(),
									contacto.fechaNacimiento.getDayOfMonth());
		}
			
	}
	
	/**
	 * Retorna el nombre del contacto
	 * @return retorna el nombre del conctacto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retorna los apellidos del contacto
	 * @return retorna los apellidos del contacto
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Retorna la edad de la persona. Si no se especificó la fecha de nacimiento se retorna -1;
	 * @return Retorna la edad de la persona. Si no se especificó la fecha de nacimiento se retorna -1;
	 */
	public int getEdad() {
		int edad = -1;
		if (this.fechaNacimiento != null) {	//No se ha especifacido fecha de nacimiento
			Period age = Period.between(this.fechaNacimiento, LocalDate.now());
			edad = age.getYears();
		}
		return edad;
		
	}
	/**
	 * Retorna el email del contacto
	 * @return retorna el email
	 */
	public String getEmail() {
		return email;
	}

	public String getTelef() {
		return telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}

	/**
	 * Este método se encarga de comprar dos Contactos.
	 * Compara un contacto ignorando mayúscualas y minúsculas.
	 * Primero compara los apellidos, en el caso de que sean iguales procede con la comparación del nombre y
	 * si son iguales procede c on la edad.
	 * @param con Contacto con el que se compara
	 * @return un número negativo si con es mayor que el contacto, 0 si son igaules y un número positivo si con es menor que el contacto
	 * 
	 */
	@Override
	public int compareTo(Contacto con) {
		
		int comparacion = this.apellidos.compareToIgnoreCase(con.getApellidos());
		if (comparacion == 0) {
			comparacion = this.nombre.compareToIgnoreCase(con.getNombre());
		}
		
		return (comparacion !=0)? comparacion : this.getEdad() - con.getEdad();
	}
	
	public String toString() {
		return String.format("Nombre: %s; Apellidos: %s, edad: %d", this.nombre, this.apellidos, this.getEdad());
	}
	
}
