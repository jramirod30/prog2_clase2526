
public class TestPlayer {

	public static void main(String[] args) {
		ReproductorMusica player;
		player = new ReproductorMusica(10);
		
		Cancion[] canciones = {
				new Cancion("A", 1),
				new Cancion("B", 1),
				new Cancion("C", 2)
		};
		player.insertarCanciones(canciones);
		
		System.out.println(player.toString());
		
		Cancion[] canciones1 = {
				new Cancion("D", 1),
				new Cancion("E", 1),
				new Cancion("F", 2)
		};
		
		player.insertarCanciones(canciones1);
		
		System.out.println(player.toString());
		
		while(player.haySiguiente()) {
			player.reproducirCancionSeleccionada();
			player.avanzarPuntero();
		}
		player.reproducirCancionSeleccionada();
		
		System.out.println(player.toString());

	}

}
