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

	public GuiaTelefonos(GuiaTelefonos guiatf)
	{
		this.guia = new Contacto[guiatf.guia.length];
		this.numContactos = guiatf.numContactos;

		for(int i = 0; i < this.numContactos; i++)
		{
			this.guia[i] = new Contacto(guiatf.guia[i]);
		}
	}

	public boolean esIgual( GuiaTelefonos otra) {
		boolean resultado= this.numContactos==otra.numContactos;
		
		for(int i=0; i<this.numContactos && resultado;i++) {
			boolean encontrado=false;
			for(int j =0; j< otra.guia.length&& !encontrado;j++) {
				if(this.guia[i].esIgual(otra.guia[j])) {
					encontrado=true;
				}
			}
			if(!encontrado) resultado=false;
		}
		return resultado;
	}
	
	public boolean esIgual1( GuiaTelefonos otra) {
		boolean resultado= this.numContactos==otra.numContactos;
		
		for(int i=0; i<this.numContactos && resultado;i++) {
			Contacto contacto = otra.buscarNombre(this.guia[i].getNombre());
			resultado = (contacto != null) && 
					contacto.getNumero() == this.guia[i].getNumero();
		}
		return resultado;
	}
}


