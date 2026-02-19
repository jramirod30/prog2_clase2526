// Colección de contactos, asumiendo que no
// se repiten nombres ni números de teléfono
public class GuiaTelefonos {
	private Contacto[] guia;
	private int numContactos;

	// Constructor
	public GuiaTelefonos(int capacidad) {
		guia = new Contacto[capacidad];
		numContactos = 0;
	}

	// Añadir contacto
	public void poner(Contacto contacto) {
		if (numContactos < guia.length) {     // hay sitio
			guia[numContactos] = contacto;    // ponerlo al final
			numContactos++;
		}
	}

	// Eliminar contacto
	public void quitar(Contacto contacto) {
		int pos = -1;
		for (int k = 0; k < numContactos && pos < 0; k++) {  // buscarlo
			if (guia[k].esIgual(contacto)) pos = k;   // está ahí
		}
		if (pos >= 0) {                // se ha encontrado
			numContactos--;
			if (pos < numContactos) {  // no era el último
				guia[pos] = guia[numContactos];  // rellenar el hueco
			}
		}
	}

	// Presentar con formato
	public String toString() {
		String texto = "";
		for (int k = 0; k < numContactos; k++) {  // procesar todos
			texto = texto + guia[k] + "\n";       // un contacto por línea
		}
		return texto;
	}

	// Búsquedas
	public Contacto buscarNombre(String nombre) {
		Contacto con = null;
		for (int k = 0; k < numContactos && con == null; k++) {
			if (guia[k].igualNombre(nombre)) con = guia[k];
		}
		return con;
	}
	
	public Contacto buscarNumero(long numero) {
		Contacto con = null;
		for (int k = 0; k < numContactos && con == null; k++) {
			if (guia[k].igualNumero(numero)) con = guia[k];
		}
		return con;
	}
	
	public int contarTelefonosMadrid() {
		
	}

}



