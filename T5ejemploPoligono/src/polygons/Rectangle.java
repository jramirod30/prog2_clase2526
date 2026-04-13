/**
 * 
 */
package polygons;

import list.ArrayList;
import point.Point;

/**
 * @author angel
 *
 */
public class Rectangle extends Polygon {

	/**
	 * El constructor no verifica que los puntos conformnen un rectángulo.
	 * ESto es un ejemplo.
	 * PRE: tiene que haber 4 puntos
	 * @param points
	 */
	public Rectangle(ArrayList<Point> points) {
		super(points);
		//Verificar PRE si no se cumple -> excepción
	}

	@Override
	public String getType() {
        if (this.getSide(1) == this.getSide(2))
            return "square";
        else
            return "rectangle";
	}

}
