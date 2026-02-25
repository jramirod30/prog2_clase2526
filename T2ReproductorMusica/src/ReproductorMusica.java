


public class ReproductorMusica {
	// contiene las canciones que se pueden reproducir
	private Cancion[] listaReproduccion;
	private int noCanciones;
	// indica la pos de la siguiente canción a reproducir
	// si la listaReproduccion está vacía, punteroReproduccion es -1
	private int punteroReproduccion; 

	public ReproductorMusica(int capacidad){
		
	}

	public String toString(){	
		String salida = "";
		for(int i=0; i < noCanciones; i++)
			salida += listaReproduccion[i].toString() + ", ";
		
		salida += "punteroApuntaA=" + 
				(noCanciones==0 ? "nada": 
					listaReproduccion[punteroReproduccion].toString());
		
		return salida;
	}

	/**
	 * POST: Si hay una canción 
	 * con el título y la duración dadas,
	 * devuelve la posición de la primera ocurrencia
	 * e.o.c. devuelve -1 
	 *
	 */
	private int buscarCancion(String titulo, double duracion){	
		return 0;
	}

	/**
	 * POST: 
	 * Si la canción dada está en la lista, 
	 *   borra la primera ocurrencia de la canción.
	 *   Si quedan canciones, deja el puntero apuntando a la primera canción.
	 *   Si no quedan canciones, se deja el puntero con valor -1.
	 * e.o.c. no hace nada
	 */
	public void borrarCancion(String titulo, double duracion){
		
	}

	/**
	 * PRE: Hay suficiente espacio libre para las nuevas canciones
	 * POST: Inserta las canciones en la lista (al final)	
	 * Deja el puntero apuntando a la primera canción insertada
	 * Utiliza las canciones del vector dado y no crea copias
	 * Si canciones.length = 0, no hace nada.
	 */
	public void insertarCanciones(Cancion[] canciones){
		
		
	}

	/**	
	 * POST: Si la canción existe, pone el puntero en la primera ocurrencia 
	 * de la canción con el título y la duración dados
	 * e.o.c. deja el puntero igual
	 */
	public void seleccionarCancion(String titulo, double duracion){
		
	}

	/**
	 * PRE: la lista no está vacía
	 * POST: reproduce la canción a la que apunta el puntero
	 */
	public void reproducirCancionSeleccionada(){
		
	}

	/**
	 * PRE: la lista no está vacía y 
	 * el puntero no está en la última canción
	 * POST: avanza el puntero a la siguiente canción de la lista
	 */
	public void avanzarPuntero(){
		
	}

	/**
	 * POST: Indica si el puntero está en la última canción de la lista 
	 */
	public boolean haySiguiente(){
		return false;
	}

	/** 
	 * POST: Devuelve un vector con copias de las canciones que
	 * se han escuchado igual o más de un número dado de veces.	
	 * Si no hay ninguna, se devuelve un vector de tamaño cero. 
	 */
	public Cancion[] seleccionarCancionesMasEscuchadas(int veces){
		
		return null;
	}

	

}
