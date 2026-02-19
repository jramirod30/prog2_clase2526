
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
		existenciasProductos[codProducto] += cantidad;
	}
	
	//PRE: 0 <= codProducto < size() y cantidad > 0 y 
	// existenciasProductos[codProducto] >= cantidad
	public void gastarProductos(int codProducto, int cantidad) {
		existenciasProductos[codProducto] -= cantidad;
	}
	
	public String toString() {
		String respuesta = "";
		for (int i = 0; i < existenciasProductos.length - 1; i++) {
			respuesta = respuesta + existenciasProductos[i] + ",";
		}
		return respuesta + existenciasProductos[existenciasProductos.length - 1];
	}
	
	public boolean existeProductoAgotado() {
		boolean agotado = false;
		for(int i=0; i<existenciasProductos.length && !agotado; i++) {
				agotado = existenciasProductos[i]==0;
		}
		return agotado;
	}
	
	public boolean existeProductoAgotado1() {
		int i;
		for(i=0; i<existenciasProductos.length 
				&& existenciasProductos[i]>0; i++) ;
		
		return i < existenciasProductos.length;
	}
	
	
	
	
}



