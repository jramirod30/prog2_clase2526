package pruebas;

public class Test {
	   public static void main(String[] args) {
		      /* Test Estudiante */
		      Estudiante s1 = new Estudiante("Tan Ah Teck", "1 Happy Ave");
		      s1.addNotaYCurso("IM101", 9);
		      s1.addNotaYCurso("IM102", 6);
		      s1.printNotas();
		      System.out.println("El promedio es  " + s1.getAverageNota());
		      
		      /* Test Profesor  */
		      Profesor t1 = new Profesor("Paul Tan", "8 sunset way");
		      System.out.println(t1);
		      String[] cursos = {"IM101", "IM102", "IM101"};
		      for (String curso: cursos) {
		         if (t1.addCurso(curso)) {
		            System.out.println(curso + " anhadido.");
		         } else {
		            System.out.println(curso + " no se puede anhadir.");
		         }
		      }
		      for (String curso: cursos) {
		         if (t1.borraCurso(curso)) {
		            System.out.println(curso + " eliminado.");
		         } else {
		            System.out.println(curso + " no se puede eliminar.");
		         }
		      }
		      
		      Persona[] personas = new Persona[4];
		      Persona e1 = new Estudiante ("Braulio", "3 Ugly Road");
//		      PRUEBA A INVOCAR SOBRE e1 CUALQUIER METODO ESPECIFICO DE LA CLASE ESTUDIANTE, QUE NO ESTE EN LA CLASE PERSONA:
//		      e1.addNotaYCurso("C607A", 7);
//		      PRUEBA A DESCOMENTAR LA SIGUIENTE LINEA:
//		      Estudiante e1 = new Persona("Braulia", "7 Nice Road");
		      Estudiante e2 = new Estudiante("Braulia", "7 Nice Road");
		      Persona p1 = new Persona("Simon", "2 Nowhere");
		      Persona prof1 = new Profesor ("Pia","89 Housing");
		      personas[0] = e1;
		      personas[1] = e2;
		      personas[2] = p1;
		      personas[3] = prof1;
		      for (Persona p : personas)
		    	  //OBSERVA A QUE VERSION DE toString() SE INVOCA EN CADA CASO
		    	  System.out.println(p.toString());
		 }
}

