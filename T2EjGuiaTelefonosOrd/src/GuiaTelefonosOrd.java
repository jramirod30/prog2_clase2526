// Colección de contactos, asumiendo que no
// se repiten nombres ni números de teléfono
public class GuiaTelefonosOrd {
	private Contacto[] guia;
	private int numContactos;

	// Constructor
	public GuiaTelefonosOrd(int capacidad) {
		guia = new Contacto[capacidad];
		numContactos = 0;
	}

	// Añadir contacto
	public void poner(Contacto contacto) {
		if (numContactos < guia.length) {     // hay sitio
			int i;
			for(i = numContactos-1; i >= 0 && 
					guia[i].getNombre().compareTo(contacto.getNombre()) > 0
					; i--)
				guia[i+1] = guia[i];
			
			guia[i+1] = contacto;
		
				
			numContactos++;
		}
	}

	private int buscarPos(String nombre) {		
		int primero = 0;
		int ultimo = numContactos - 1;
		while (primero < ultimo) { // hay más de un elemento posible
			int centro = (primero + ultimo) / 2;
			String nombreCentro = guia[centro].getNombre();

			if (nombreCentro.compareTo(nombre) > 0) {
				ultimo = centro - 1;
			} else if (nombreCentro.compareTo(nombre) < 0) {
				primero = centro + 1;
			} else { // nombreCentro == nombre
				primero = centro;
				ultimo = centro;
			}
		}
		return ((primero==ultimo) && 
				(guia[primero].getNombre().equals(nombre)) ? primero : -1);
	}


	// Eliminar contacto
	public void quitar(Contacto contacto) {
		int pos = buscarPos(contacto.getNombre());

		if (pos >= 0) {
			for(int i=pos; i<this.numContactos-1; i++)
				guia[i] = guia[i+1];
			numContactos--;			
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
		int pos = buscarPos(nombre);
		return (pos == -1? null : guia[pos]);
	}

	public Contacto buscarNumero(long numero) {
		Contacto con = null;
		for (int k = 0; k < numContactos && con == null; k++) {
			if (guia[k].igualNumero(numero)) con = guia[k];
		}
		return con;
	}

	public int contarTelefonosMadrid() {
		int contador=0;
		for(int k=0; k<numContactos; k++) {
			if(guia[k].tieneTtlfoMadrid()) {
				contador++;
			}
		}
		return contador;
	}

	public void reemplazar(long numero, String  nombre) {
		Contacto reemplazo=buscarNombre(nombre);
		if(reemplazo!=null)
			reemplazo.setNumero(numero);
	}

	public Contacto[] getTelefonosMadrid() {
		Contacto[] telefonosMadrid = new Contacto[this.contarTelefonosMadrid()];
		int j=0;
		for(int i=0;j<telefonosMadrid.length;i++) {
			if(this.guia[i].tieneTtlfoMadrid()) {
				telefonosMadrid[j]=this.guia[i];
				j++;
			}
		}
		return telefonosMadrid;
	}

	public GuiaTelefonosOrd(GuiaTelefonosOrd guiatf)
	{
		this.guia = new Contacto[guiatf.guia.length];
		this.numContactos = guiatf.numContactos;

		for(int i = 0; i < this.numContactos; i++)
		{
			this.guia[i] = new Contacto(guiatf.guia[i]);
		}
	}

	public boolean esIgual( GuiaTelefonosOrd otra) {
		if (this.numContactos==otra.numContactos) {
			int i;
			for(i=0; i<this.numContactos && this.guia[i].esIgual(otra.guia[i]);i++);
			
			return i==this.numContactos;
		} else
			return false;
	}

}


