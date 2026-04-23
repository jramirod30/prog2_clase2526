package herenciaPersonaAlumnoProfesor;

public class Profesor extends Persona{

	   private int numCursos;   
	   private String[] cursos; // codigos cursos
	   private static final int MAX_CURSOS = 5; 
	   
	   // Constructor
	   public Profesor(String nombre, String direccion) {
	      super(nombre, direccion);
	      //COMPLETAR
	   }
	   
	   // NO TOCAR ESTE CODIGO
	   @Override
	   public String toString() {
	      return "Profesor: " + super.toString();
	   }
	   
	   // Devuelve false si el curso ya existe y no inserta
	   public boolean addCurso(String curso) {
		//COMPLETAR
	   }
	   
	   // Devuelve false si el curso no esta en la lista. En otro caso, lo elimina y recoloca los cursos en el array
	   public boolean borraCurso(String course) {
		//COMPLETAR
	   }

}
