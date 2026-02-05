
public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo rectangulo1, rectangulo2;
		rectangulo1 = new Rectangulo(1, 2);
		rectangulo2 = new Rectangulo(4, 5);
		
		System.out.println(rectangulo1.area());
		System.out.println(rectangulo2.area());
		
		rectangulo1.setLado1(3); // 1 -> 3
		System.out.println(rectangulo1.area());
		
		System.out.println(rectangulo1.toString());
		System.out.println(rectangulo2.toString());
		
		rectangulo2.setLado2(100);
		System.out.println(rectangulo1.toString());
		System.out.println(rectangulo2.toString());
		
		

		
		

	}

}
