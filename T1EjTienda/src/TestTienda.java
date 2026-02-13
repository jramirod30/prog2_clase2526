
public class TestTienda {
	
	private static Tienda tienda;
	private static Almacen almacen1, almacen2;
	
	private static void inicializar() {
		almacen1 = new Almacen(3);
		almacen2 = new Almacen(3);
		
		tienda = new Tienda(0, almacen1, almacen2);
		almacen1.recibirProductos(0, 2);
		almacen2.recibirProductos(1, 2);
		
		tienda.setPrecio(0, 100);
		tienda.setPrecio(1, 200);
		tienda.setPrecio(2, 300);
	}
	
	
	public static void main(String[] args) {
		inicializar();
		System.out.println(tienda.toString());
		
		tienda.comprar(0);
		tienda.comprar(1);
		
		System.out.println(tienda.toString());
		
		tienda.devolver(1);
		
		System.out.println(tienda.toString());
		
		System.out.println(tienda.numProdAgotados());
		
		almacen2.recibirProductos(2, 3);
		System.out.println(tienda.numProdAgotados());

	}

}
