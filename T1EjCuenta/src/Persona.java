
public class Persona {
	private String dni;
	private String nombre;
	private int edad;
	
	public Persona(String dni, String nombre, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String toString() {
		return "[" + dni + " " + nombre + " " + edad + "]";
	}
	
	public boolean esIgual(Persona obj) {
		return (this.dni.equals(obj.dni) 
				&& this.nombre.equals(obj.nombre) 
				&& this.edad==obj.edad);
	}
	
	public Persona(Persona obj) {
		this.edad = obj.edad;
		this.nombre = obj.nombre;
		this.dni = obj.dni;
	}
	
	
	
}
