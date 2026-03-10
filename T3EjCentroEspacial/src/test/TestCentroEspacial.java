package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import vigilanciaespacial.CentroEspacial;
import vigilanciaespacial.SateliteArtificial;
import vigilanciaespacial.estrellas.Estrella;

/**
 * Pruebas JUnit para CentroEspacial.
 *
 * @author Raúl García Castro (código original)
 * @author Manuel Collado Machuca (actualizaciones)
 */
public class TestCentroEspacial {

	private CentroEspacial centroEspacial1 = null; // común para todos los tests

	/**
	 * Inicialización en cada test.
	 */
	@Before
	public void setUp() {
		// Se crean los 5 satélites que va a supervisar el centro espacial.
		// Todos son distintos (monitorizan distintas estrellas)
		SateliteArtificial[] satelites = new SateliteArtificial[5];
		satelites[0] = new SateliteArtificial(new Estrella("Sol", 23.3, 19));
		satelites[1] = new SateliteArtificial(new Estrella("Rigel", 3.3, 319));
		satelites[2] = new SateliteArtificial(new Estrella("Epsilon Indi",
				213.3, 22));
		satelites[3] = new SateliteArtificial(new Estrella("Alpha Centauri",
				111111.1, 35));
		satelites[4] = new SateliteArtificial(
				new Estrella("Altair", 222.3, 249));
		centroEspacial1 = new CentroEspacial("Cabo canaveral", satelites);
	}

	// -------------------------------------------------------------------
	/** Prueba constructor (identificador) */
	@Test
	public void testGetIdentificador() {
		assertEquals("Problemas al inicializar el centro espacial:",
				"Cabo canaveral", centroEspacial1.getIdentificador());
	}

	// -------------------------------------------------------------------
	/** Prueba obtener la información de las estrellas */
	@Test
	public void testInformacionEstrellas() {
		String esperado = "Sol (39.9)\nRigel (669.9)\nEpsilon Indi (46.2)\nAlpha Centauri (73.5) ALERTA!\nAltair (522.9)\n";
		assertEquals("\nInformación de estrellas incorrecta:\n", esperado,
				centroEspacial1.informacionEstrellas());
	}

	// -------------------------------------------------------------------
	/** Prueba comprobar satélites (configuración correcta) */
	@Test
	public void testComprobarSatelites1() {
		assertEquals("\nFallo al comprobar satelites:\n", true,
				centroEspacial1.comprobarSatelites());
	}
	
	/** Prueba comprobar satélites (vector de satélites vacío) */
	@Test
	public void testComprobarSatelites3() {
		CentroEspacial centroEspacial2 = new CentroEspacial(
				"Observatorio Montana Cabreja", new SateliteArtificial[0]);
		assertEquals("\nFallo al comprobar satelites:\n",
				false, centroEspacial2.comprobarSatelites());
	}
	/** Prueba comprobar satélites (satélites repetidos) */
	@Test
	public void testComprobarSatelites4() {
		SateliteArtificial[] satelites2 = new SateliteArtificial[5];
		satelites2[0] = new SateliteArtificial(new Estrella("Sol", 23.3, 19));
		satelites2[1] = new SateliteArtificial(new Estrella("Rigel", 3.3, 319));
		satelites2[2] = new SateliteArtificial(new Estrella("Epsilon Indi",
				213.3, 222));
		satelites2[3] = new SateliteArtificial(new Estrella("Alpha Centauri",
				111111.1, 35));
		satelites2[4] = new SateliteArtificial(new Estrella("Sol", 23.3, 19));
		CentroEspacial centroEspacial2 = new CentroEspacial(
				"Observatorio Montana Cabreja", satelites2);
		assertEquals("\nFallo al comprobar satelites:\n",
				false, centroEspacial2.comprobarSatelites());
	}
	/** Prueba comprobar satélites (satélites repetidos) */
	@Test
	public void testComprobarSatelites5() {
		SateliteArtificial[] satelites2 = new SateliteArtificial[5];
		satelites2[0] = new SateliteArtificial(new Estrella("Rigel", 3.3, 319));
		satelites2[1] = new SateliteArtificial(new Estrella("Epsilon Indi",
				213.3, 222));
		satelites2[2] = new SateliteArtificial(new Estrella("Alpha Centauri",
				111111.1, 35));
		satelites2[3] = new SateliteArtificial(new Estrella("Sol", 23.4, 19));
		satelites2[4] = new SateliteArtificial(new Estrella("Sol", 23.3, 19));
		CentroEspacial centroEspacial2 = new CentroEspacial(
				"Observatorio Montana Cabreja", satelites2);
		assertEquals("\nFallo al comprobar satelites:\n",
				false, centroEspacial2.comprobarSatelites());
	}

}
