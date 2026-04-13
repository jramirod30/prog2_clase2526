/**
 * 
 */
package polygons;
import point.Point;
import list.ArrayList;
/**
 * @author angel
 *
 */
public abstract class Polygon {
	private ArrayList<Point> points;
	/**
	 * Este constructor recibe la lista de puntos y se queda con la referencia
	 * No se verifica que los puntos conformen un polígono
	 * @param points
	 */
	public Polygon(ArrayList<Point> points) {
		this.points = points;
	}
	
    public float perimeter() {
    	float perimeter = 0;
    	for (int i = 1; i <= points.size(); i++){
    	    perimeter += this.getSide(i);
    	}    
    	return perimeter;
    }
        

    /**
     * Return side for this polygon
     * PRE: 0 < side <= n where n is the sides number
     * @param side side number from 1 to n
     * @return side length
     */
    public float getSide(int side) {
    	return (float)this.points.get(side-1).distance(this.points.get(side % this.points.size()));
    }
        
	
	/**
	 * Este métdo indica el tipo de poligono. El padre no sabe como se hace pero si que debe existir
	 * @return
	 */
	public abstract String getType();
}
