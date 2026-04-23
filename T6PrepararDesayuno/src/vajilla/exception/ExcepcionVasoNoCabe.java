package vajilla.exception;


public class ExcepcionVasoNoCabe extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8444319082658638275L;

	public ExcepcionVasoNoCabe() { }
	// si se quiere mostrar un cierto mensaje
	// se debe definir este segundo constructor
	
	public ExcepcionVasoNoCabe(String msg)  {
		super(msg);
	}

}
