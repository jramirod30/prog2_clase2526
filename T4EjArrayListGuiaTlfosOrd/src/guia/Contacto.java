// Contacto simple (nombre, tel�fono)
package guia;

public class Contacto {
    private String nombre;
    private long numero;

    // Constructor
    public Contacto(String nombre, long numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public long getNumero() {
        return numero;
    }

    // Comparaci�n
    public boolean esIgual(Contacto otro) {
        return this.nombre.equals(otro.nombre) &&
               this.numero == otro.numero;
    }
    public boolean igualNombre(String nombre) {
        return this.nombre.equals(nombre);
    }
    public boolean igualNumero(long numero) {
        return this.numero == numero;
    }

    // Presentar con formato
    public String toString() {
        return nombre + ": " + numero;
    }
    
    public boolean contieneTtlfoMadrid() {
    	String telefono = Long.toString(numero);
    	return telefono.startsWith("91") || telefono.startsWith("3491");    	
    }
    
    public void setNumero(long numero) {
    	this.numero = numero;
    }
    
}
