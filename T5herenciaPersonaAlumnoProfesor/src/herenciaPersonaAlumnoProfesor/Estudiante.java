package herenciaPersonaAlumnoProfesor;

public class Estudiante extends Persona{
	   private int numCursos;   // numero de cursos a los que atiende
	   private String[] cursos; // codigos de los cursos
	   private int[] notas;     // nota del curso de codigo correspondiente
	   private static final int MAX_CURSOS = 30; // maximo numero de cursos
	   
	   // Constructor
	   public Estudiante(String nombre, String direccion) {
	      super(nombre, direccion);
	      // COMPLETAR EL CODIGO
	   }
	   
	   @Override
	   public String toString() {
	      return "Estudiante: " + super.toString();
	   }
	   
	   //Se anhade un curso y una nota. 
	   //Asumid que hay espacio para almacenar curso y nota
	   public void addNotaYCurso(String curso, int nota) {
		//COMPLETAR ESTE CODIGO
	   }
	   
	   public void printNotas() {
	      System.out.print(this);
	      for (int i = 0; i < numCursos; ++i) {
	         System.out.print(" " + cursos[i] + ":" + notas[i]);
	      }
	      System.out.println();
	   }
	   
	   public double getAverageNota() {
		//COMPLETAR ESTE CODIGO
	   }
}
