
public class TestSegmento {

	public static void main(String[] args) {
		Punto aMain = new Punto(2, 3);
		Punto bMain = new Punto(4, 5);
		Segmento segmento1 = new Segmento(aMain, bMain);
		System.out.println(segmento1.toString());
		segmento1.desplazar(1, 3);
		System.out.println(segmento1.toString());
		Punto medio = segmento1.puntoMedio();
		System.out.println(medio.toString());
		System.out.println(segmento1.longitud());
		Segmento segmento2=new Segmento(segmento1);
		System.out.println(segmento2.toString());
		
		System.out.println(segmento1.esIgual(segmento2));//true
		segmento1.desplazar(0, 1);
		System.out.println(segmento1.esIgual(segmento2));//false
	}

}
