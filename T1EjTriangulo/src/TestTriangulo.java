
public class TestTriangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangulo triangulo1,triangulo2;
		triangulo1=new Triangulo(2,2);
		triangulo2=new Triangulo(2,3);
		
		System.out.println(triangulo1.toString());
		System.out.println(triangulo2.toString());
		
		triangulo1.setAltura(10);
		
		System.out.println(triangulo1.toString());
		System.out.println(triangulo2.toString());

		//triangulo1.altura = 90;
		
		

	}

}
