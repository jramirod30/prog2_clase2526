
public class Almacen {
	// en la pos i se guarda el no. de existencias
	// del producto con codigo i
	private int[] existenciasProductos;
	
	public Almacen(int[] existenciasProductos) {
		this.existenciasProductos = existenciasProductos;
	}
	
	//PRE: noProductos > 0
	public Almacen(int noProductos) {
		this.existenciasProductos = new int[noProductos];
	}
	
	public int size() {
		return existenciasProductos.length;
	}
	
	//PRE: 0 <= codProducto < size()
	public int get(int codProducto) {
		return existenciasProductos[codProducto];
	}
	
	//PRE: 0 <= codProducto < size() y cantidad > 0
	public void recibirProductos(int codProducto, int cantidad) {
		//TO-DO
	}
	
	//PRE: 0 <= codProducto < size() y cantidad > 0 y 
	// existenciasProductos[codProducto] >= cantidad
	public void gastarProductos(int codProducto, int cantidad) {
		//TO-DO
	}
	
	public String toString() {
		//TO-DO
		return "";
	}
	
	public boolean existeProductoAgotado() {
		//TO-DO
		return false;
	}
	
	
}



