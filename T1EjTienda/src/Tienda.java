
public class Tienda {
	private Almacen almacen1, almacen2;
	private double saldoCaja;
	// en pos i esta el precio del producto con codigo i
	private double[] precios;
	
	//PRE: almacen1.size() = almacen2.size() y
	// saldoInicial >= 0
	public Tienda(double saldoInicial, Almacen almacen1,
			Almacen almacen2) {
		//TO-DO
	}
	
	//PRE: 0 <= codProducto < precios.length y precio > 0
	public void setPrecio(int codProducto, double precio) {
		//TO-DO
	}
	
	//PRE: 0 <= codProducto < precios.length y 
	// hay existencias del producto codProducto
	// preferimos utilizar el almacen mas cercano
	public void comprar(int codProducto) {
		//TO-DO
	}
	
	//PRE: 0 <= codProducto < precios.length
	public void devolver(int codProducto) {
		//TO-DO
	}
	
	//PRE: 0 <= codProducto < precios.length
	public boolean quedaProducto(int codProducto){
		//TO-DO
		return false;
	}
	
	public int numProdAgotados() {
		//TO-DO
		return 0;
	}
	
	public String toString() {
		//TO-DO		
		return "";		
	}
}
