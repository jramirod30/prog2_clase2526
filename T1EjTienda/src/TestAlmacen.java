
public class TestAlmacen {

	public static void main(String[] args) {
		Almacen almacen1 = new Almacen(3);
		
		System.out.println(almacen1.toString());
		
		almacen1.recibirProductos(1, 30);
		almacen1.recibirProductos(2, 10);
		
		almacen1.gastarProductos(1, 3);
		
		System.out.println(almacen1.toString());
		
		System.out.println(almacen1.existeProductoAgotado());
		
		almacen1.recibirProductos(0, 10);
		
		System.out.println(almacen1.existeProductoAgotado());
		

	}

}
