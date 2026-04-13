package point;


public class Point {
	private float x;
	private float y;
	
	/**
	 * Constructor de un punto en el plano
	 * @param x coordenada x
	 * @param y coordenada y
	 */
	public Point(float x, float y) {// constructor
		this.x = x;
		this.y = y;
	}// constructor
	
	
	/**
	 * Este método indica la distancia entre esta instancia de punto y la dada como parámtros
	 * @param p2 Point del que se quiere obtener la distancia
	 * @return distancia entre la instancia y el punto p2
	 */
	public double distance(Point p2) {
		return Math.sqrt((this.x - p2.getX()) * (this.x - p2.getX())
				+ (this.y - p2.getY()) * (this.y - p2.getY()));
	}


	/**
	 * 
	 * @return proprociona la componente x del punto
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * 
	 * @return proporciona la componente y del punto
	 */
	public float getY() {
		return this.y;
	}

	


}
