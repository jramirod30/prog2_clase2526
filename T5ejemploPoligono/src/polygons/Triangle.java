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
public class Triangle extends Polygon {

	/**
	 * No se verifica que los tres puntos conformen un triángulo
	 * PRE: número de puntos 3
	 * @param points
	 */
	public Triangle(ArrayList<Point> points) {
		super(points);
	
	}

	@Override
	public String getType() {//getType
        if (this.getSide(1) == this.getSide(2)) {//IF1
        	if (this.getSide(2) == this.getSide(3)) {//IF2
        		return "equilateral";
        	}//IF2
            else {//else2
            	return "isosceles";
            }// else2
            	
        } //IF1
        else {//else1
        	if (this.getSide(2) == this.getSide(3)) {//IF3
        		return "isosceles";	
        	}//IF3
        }//else1
        return "scalene";  
	}//getType

}
