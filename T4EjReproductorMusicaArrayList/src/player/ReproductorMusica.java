package player;
import list.ArrayList;
import player.cancion.Cancion;

public class ReproductorMusica {
	// contiene las canciones que se pueden reproducir
	private ArrayList<Cancion> listaReproduccion;
	//private int noCanciones;
	// indica la pos de la siguiente canci�n a reproducir
	// si la listaReproduccion est� vac�a, punteroReproduccion es -1
	private int punteroReproduccion; 

	public ReproductorMusica(){
		listaReproduccion = new ArrayList<Cancion>();
		punteroReproduccion = -1;
	}

	public String toString(){
		return listaReproduccion + "punteroApuntaA=" + 
				(punteroReproduccion !=-1? 
						listaReproduccion.get(punteroReproduccion) :
						"nada");
	}

	/**
	 * POST: Si hay una canci�n 
	 * con el t�tulo y la duraci�n dadas,
	 * devuelve la posici�n de la primera ocurrencia
	 * e.o.c. devuelve -1 
	 *
	 */
	private int buscarCancion(String titulo, double duracion){	
		Cancion cancion = new Cancion(titulo, duracion);
		return listaReproduccion.indexOf(cancion);
	}

	/**
	 * POST: 
	 * Si la canci�n dada est� en la lista, 
	 *   borra la primera ocurrencia de la canci�n.
	 *   Si quedan canciones, deja el puntero apuntando a la primera canci�n.
	 *   Si no quedan canciones, se deja el puntero con valor -1.
	 * e.o.c. no hace nada
	 */
	public void borrarCancion(String titulo, double duracion){
		int posCancion = buscarCancion(titulo, duracion);
		if(posCancion>=0){
			listaReproduccion.removeElementAt(posCancion);

			if(listaReproduccion.size()>0) punteroReproduccion = 0;
			else punteroReproduccion = -1;
		}
	}

	/**
	 * PRE: Hay suficiente espacio libre para las nuevas canciones
	 * POST: Inserta las canciones en la lista (al final)	
	 * Deja el puntero apuntando a la primera canci�n insertada
	 * Utiliza las canciones del vector dado y no crea copias
	 * Si canciones.length = 0, no hace nada.
	 */
	public void insertarCanciones(Cancion[] canciones){
		if (canciones.length > 0) {
			this.punteroReproduccion=listaReproduccion.size();
			for (int i=0; i<canciones.length; i++) {
				this.listaReproduccion.add(listaReproduccion.size(), 
						canciones[i]);
			}
		}
	}

	/**	
	 * POST: Si la canci�n existe, pone el puntero en la primera ocurrencia 
	 * de la canci�n con el t�tulo y la duraci�n dados
	 * e.o.c. deja el puntero igual
	 */
	public void seleccionarCancion(String titulo, double duracion){
		int i=buscarCancion(titulo,duracion);
		if(i!=-1)
			punteroReproduccion=i;
	}

	/**
	 * PRE: la lista no est� vac�a
	 * POST: reproduce la canci�n a la que apunta el puntero
	 */
	public void reproducirCancionSeleccionada(){
		listaReproduccion.get(punteroReproduccion).reproducirCancion();


	}

	/**
	 * PRE: la lista no est� vac�a y 
	 * el puntero no est� en la �ltima canci�n
	 * POST: avanza el puntero a la siguiente canci�n de la lista
	 */
	public void avanzarPuntero(){
		punteroReproduccion++;
	}

	/**
	 * POST: Indica si el puntero est� en la �ltima canci�n de la lista 
	 */
	public boolean haySiguiente(){
		return punteroReproduccion < listaReproduccion.size()-1;
	}

	/** 
	 * POST: Devuelve un vector con copias de las canciones que
	 * se han escuchado igual o m�s de un n�mero dado de veces.	
	 * Si no hay ninguna, se devuelve un vector de tama�o cero. 
	 */
	public Cancion[] seleccionarCancionesMasEscuchadas(int veces){
		ArrayList<Cancion> listaMasEscuchadas = new ArrayList<>();

		for(int i=0; i<listaReproduccion.size(); i++) {
			if(listaReproduccion.get(i).getNoReproducciones()>=veces) {
				listaMasEscuchadas.add(listaMasEscuchadas.size(), 
						listaReproduccion.get(i));
			}			
		}

		Cancion[] resultado = new Cancion[listaMasEscuchadas.size()];

		for(int i=0;i<listaMasEscuchadas.size();i++) {
			resultado[i]=new Cancion(listaMasEscuchadas.get(i));
		}


		return resultado;
	}

	public ArrayList<Cancion> seleccionarCancionesMasEscuchadas1(int veces){
		ArrayList<Cancion> listaMasEscuchadas = new ArrayList<>();

		for(int i=0; i<listaReproduccion.size(); i++) {
			if(listaReproduccion.get(i).getNoReproducciones()>=veces) {
				listaMasEscuchadas.add(listaMasEscuchadas.size(), 
						new Cancion(listaReproduccion.get(i)));
			}			
		}

		return listaMasEscuchadas;	

	}



}
