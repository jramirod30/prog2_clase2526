
public class TestTriangulo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangulo triangulo1 = new Triangulo(2, 3);
		Triangulo triangulo2 = new Triangulo(2, 3);
		
		System.out.println(triangulo1 == triangulo2);
		System.out.println(triangulo1.esIgual(triangulo2));
		
		triangulo1.setAltura(7);
		
		System.out.println(triangulo1 == triangulo2);
		System.out.println(triangulo1.esIgual(triangulo2));
		
		Triangulo triangulo3 = new Triangulo(triangulo1);
		
		System.out.println(triangulo1 == triangulo3);
		System.out.println(triangulo1.esIgual(triangulo3));
		
		

	}

}
