package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUniversidad {
	
	@Test
	public void queSePuedaRegistrarUnaMateriaAUnaUniversidad() {
		String nombreUniversidad = "Unlam", nombreMateria = "Programacion";
		Integer idMateria = 1;

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia1 = new Materia(idMateria, nombreMateria);

		// ejecucion
		Boolean registroExitoso = unlam.registrarMateria(materia1);

		// validacion
		assertTrue(registroExitoso);

	}
	
	@Test
	public void queNoSePuedaRegistrarUnaMateriaConElMismoIdAUnaUniversidad() {
		String nombreUniversidad = "Unlam", nombreMateria1 = "Programacion", nombreMateria2 = "Matematica";
		Integer idMateria1 = 1, idMateria2 = 1;

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia1 = new Materia(idMateria1, nombreMateria1);
		Materia materia2 = new Materia(idMateria2, nombreMateria2);

		// ejecucion
		unlam.registrarMateria(materia1);
		Boolean registroFallido = unlam.registrarMateria(materia2);

		// validacion
		assertFalse(registroFallido);

	}

	@Test
	public void queSePuedaRegistrarUnAlumnoAUnaUniversidad() {
		String nombreUniversidad = "Unlam", nombreAlumno = "Bruno", apellidoAlumno = "Merlo";
		Integer dniAlumno = 33180793;

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);

		// ejecucion
		Boolean registroExitoso = unlam.registrar(alumno);

		// validacion
		assertTrue(registroExitoso);

	}
	@Test
	public void queNoSePuedaRegistrarUnAlumnoCuandoYaEstaRegistradoAUnaUniversidad() {
		
		String nombreUniversidad = "Unlam", nombreAlumno1 = "Bruno", apellidoAlumno1 = "Merlo", nombreAlumno2 = "Carlos", apellidoAlumno2 = "Torres";
		Integer dniAlumno1 = 33180793,dniAlumno2 = 33180793;

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno1 = new Alumno(nombreAlumno1, apellidoAlumno1, dniAlumno1);
		Alumno alumno2 = new Alumno(nombreAlumno2, apellidoAlumno2, dniAlumno2);

		// ejecucion
		unlam.registrar(alumno1);
		Boolean registroFallido = unlam.registrar(alumno2);

		// validacion
		assertFalse(registroFallido);

	}
	
}
