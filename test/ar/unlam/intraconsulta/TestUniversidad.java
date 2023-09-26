package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

import ar.edu.unlam.pb2.universidad.Materia;
import ar.edu.unlam.pb2.universidad.Universidad;

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
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 1);

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno, fechaDeIngreso);

		// ejecucion
		Boolean registroExitoso = unlam.registrar(alumno);

		// validacion
		assertTrue(registroExitoso);

	}

	@Test
	public void queNoSePuedaRegistrarUnAlumnoConElMismoDniAUnaUniversidad() {

		String nombreUniversidad = "Unlam", nombreAlumno1 = "Bruno", apellidoAlumno1 = "Merlo",
				nombreAlumno2 = "Carlos", apellidoAlumno2 = "Torres";
		Integer dniAlumno1 = 33180793, dniAlumno2 = 33180793;
		LocalDate fechaDeIngreso1 = LocalDate.of(2022, 3, 1), fechaDeIngreso2 = LocalDate.of(2021, 3, 1);

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno1 = new Alumno(nombreAlumno1, apellidoAlumno1, dniAlumno1, fechaDeIngreso1);
		Alumno alumno2 = new Alumno(nombreAlumno2, apellidoAlumno2, dniAlumno2, fechaDeIngreso2);

		// ejecucion
		unlam.registrar(alumno1);
		Boolean registroFallido = unlam.registrar(alumno2);

		// validacion
		assertFalse(registroFallido);

	}

	@Test
	public void queSePuedaAgregarUnCicloLectivoAUnaUniversidad() {

		String nombreUniversidad = "Unlam";
		Integer IdClicloLectivo = 1;
		LocalDate fechaDeInicio = LocalDate.of(2023, 3, 27);
		LocalDate fechaDeFin = LocalDate.of(2023, 7, 15);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 13);

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		CicloLectivo cicloLectivo = new CicloLectivo(IdClicloLectivo, fechaDeInscripcion, fechaDeInicio, fechaDeFin);

		// ejecucion
		Boolean registroExitoso = unlam.agregarCicloLectivo(cicloLectivo);

		// validacion
		assertTrue(registroExitoso);

	}

	@Test
	public void queNoSePuedaAgregarDosCiclosLectivosConElMismoIdAUnaUniversidad() {

		String nombreUniversidad = "Unlam";
		Integer IdClicloLectivo1 = 1, IdClicloLectivo2 = 1;
		LocalDate fechaDeInicio1 = LocalDate.of(2023, 3, 27);
		LocalDate fechaDeFin1 = LocalDate.of(2023, 7, 15);
		LocalDate fechaDeInscripcion1 = LocalDate.of(2023, 3, 13);
		LocalDate fechaDeInicio2 = LocalDate.of(2023, 8, 14);
		LocalDate fechaDeFin2 = LocalDate.of(2023, 12, 2);
		LocalDate fechaDeInscripcion2 = LocalDate.of(2023, 8, 3);
		// fechaDeInicio2 = 20230814,fechaDeFin2 = 20231202, fechaDeInscripcion2 =
		// 20230803;

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		CicloLectivo cicloLectivo1 = new CicloLectivo(IdClicloLectivo1, fechaDeInscripcion1, fechaDeInicio1,
				fechaDeFin1);
		CicloLectivo cicloLectivo2 = new CicloLectivo(IdClicloLectivo2, fechaDeInscripcion2, fechaDeInicio2,
				fechaDeFin2);

		// ejecucion
		unlam.agregarCicloLectivo(cicloLectivo1);
		Boolean registroFallido = unlam.agregarCicloLectivo(cicloLectivo2);

		// validacion
		assertFalse(registroFallido);

	}

	@Test
	public void queNoSePuedaAgregarDosCiclosLectivosConFechasSuperpuestasAUnaUniversidad() {

		String nombreUniversidad = "Unlam";

		Integer idPrimerCicloLectivo = 1;
		Integer idSegundoCicloLectivo = 2;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 14);
		LocalDate fechaInicioCicloLectivoSegundo = LocalDate.of(2023, 3, 16);
		LocalDate fechaFinalizacionCicloLectivoSegundo = LocalDate.of(2023, 7, 12);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 1);

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		CicloLectivo primerCicloLectivo = new CicloLectivo(idPrimerCicloLectivo, fechaInscripcion,
				fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo);
		CicloLectivo segundoCicloLectivo = new CicloLectivo(idSegundoCicloLectivo, fechaInscripcion,
				fechaInicioCicloLectivoSegundo, fechaFinalizacionCicloLectivoSegundo);

		// ejecucion
		unlam.agregarCicloLectivo(primerCicloLectivo);
		Boolean registroFallido = unlam.agregarCicloLectivo(segundoCicloLectivo);

		// validacion
		assertFalse(registroFallido);

	}

	@Test
	public void queSePuedaAgregarComisionAUnCicloLectivo() {

		Integer IdClicloLectivo = 1, idComision = 1;
		LocalDate fechaDeInicio = LocalDate.of(2023, 3, 27);
		LocalDate fechaDeFin = LocalDate.of(2023, 7, 15);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 13);
		Materia materia = new Materia(1, "Matematica");
		Turno turno = Turno.Mañana;

		// preparacion

		CicloLectivo cicloLectivo = new CicloLectivo(IdClicloLectivo, fechaDeInicio, fechaDeFin, fechaDeInscripcion);
		Comision comision = new Comision(idComision, materia, turno);

		// ejecucion
		Boolean registroExitoso = cicloLectivo.agregarComision(comision);

		// validacion
		assertTrue(registroExitoso);

	}

	@Test
	public void queNoSePuedaAgregarComisionesConLosMismoDatosAlMismoCicloLectivo() {

		Integer IdClicloLectivo = 1, idComision = 1;
		LocalDate fechaDeInicio = LocalDate.of(2023, 3, 27);
		LocalDate fechaDeFin = LocalDate.of(2023, 7, 15);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 13);
		Materia materia = new Materia(1, "Matematica");
		Turno turno = Turno.Mañana;

		// preparacion

		CicloLectivo cicloLectivo = new CicloLectivo(IdClicloLectivo, fechaDeInicio, fechaDeFin, fechaDeInscripcion);
		Comision comision1 = new Comision(idComision, materia, turno);
		Comision comision2 = new Comision(idComision, materia, turno);

		// ejecucion
		cicloLectivo.agregarComision(comision1);
		Boolean registroFallido = cicloLectivo.agregarComision(comision2);

		// validacion
		assertFalse(registroFallido);

	}

	@Test
	public void queSePuedaRegistrarUnDocenteAUnaUniversidad() {

		String nombreUniversidad = "Unlam", nombreDocente = "Juan", apellidoDocente = "Alegre";
		Integer dniDocente = 14141414;
		LocalDate fechaDeIngreso = LocalDate.of(2005, 3, 1);

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Docente docente = new Docente(nombreDocente, apellidoDocente, dniDocente, fechaDeIngreso);

		// ejecucion
		Boolean registroExitoso = unlam.registrarDocente(docente);

		// validacion
		assertTrue(registroExitoso);

	}

	@Test
	public void queNoSePuedaRegistrarDosDocentesConElMismoDniAUnaUniversidad() {
		String nombreUniversidad = "Unlam", nombreDocente1 = "Juan", apellidoDocente1 = "Alegre",
				nombreDocente2 = "Marcos", apellidoDocente2 = "Rojo";
		Integer dniDocente1 = 14141414, dniDocente2 = 14141414;
		LocalDate fechaDeIngreso1 = LocalDate.of(2005, 3, 1);
		LocalDate fechaDeIngreso2 = LocalDate.of(2008, 3, 1);

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Docente docente1 = new Docente(nombreDocente1, apellidoDocente1, dniDocente1, fechaDeIngreso1);
		Docente docente2 = new Docente(nombreDocente2, apellidoDocente2, dniDocente2, fechaDeIngreso2);

		// ejecucion
		unlam.registrarDocente(docente1);
		Boolean registroFallido = unlam.registrarDocente(docente2);

		// validacion
		assertFalse(registroFallido);

	}

	@Test
	public void asignarDocenteAComision() {
		String nombreUniversidad = "Unlam", nombreDocente1 = "Juan", apellidoDocente1 = "Alegre";
		Integer dniDocente1 = 14141414, IdClicloLectivo = 1, idComision = 1;
		LocalDate fechaDeIngreso1 = LocalDate.of(2005, 3, 1);
		LocalDate fechaDeInicio = LocalDate.of(2023, 3, 27);
		LocalDate fechaDeFin = LocalDate.of(2023, 7, 15);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 13);
		Materia materia1 = new Materia(1, "Matematica");
		CicloLectivo cicloLectivo1 = new CicloLectivo(IdClicloLectivo, fechaDeInicio, fechaDeFin, fechaDeInscripcion);
		Turno turno = Turno.Mañana;

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Docente docente1 = new Docente(nombreDocente1, apellidoDocente1, dniDocente1, fechaDeIngreso1);
		Comision comision = new Comision(idComision, materia1, turno);
		unlam.registrarDocente(docente1);
		unlam.agregarCicloLectivo(cicloLectivo1);
		cicloLectivo1.agregarComision(comision);

		// ejecucion
		Boolean resultadoExitoso = cicloLectivo1.asignarDocenteAComision(idComision, docente1);

		// validacion
		assertTrue(resultadoExitoso);

	}

	@Test
	public void queNoSePuedaasignarElmismoDocenteALaMismaComision() {
		String nombreUniversidad = "Unlam", nombreDocente1 = "Juan", apellidoDocente1 = "Alegre";
		Integer dniDocente1 = 14141414, IdClicloLectivo = 1, idComision = 1;
		LocalDate fechaDeIngreso1 = LocalDate.of(2005, 3, 1);
		LocalDate fechaDeInicio = LocalDate.of(2023, 3, 27);
		LocalDate fechaDeFin = LocalDate.of(2023, 7, 15);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 13);
		Materia materia1 = new Materia(1, "Matematica");
		Turno turno = Turno.Mañana;
		
		Universidad unlam = new Universidad(nombreUniversidad);
		Docente docente1 = new Docente(nombreDocente1, apellidoDocente1, dniDocente1, fechaDeIngreso1);
		CicloLectivo cicloLectivo1 = new CicloLectivo(IdClicloLectivo, fechaDeInicio, fechaDeFin, fechaDeInscripcion);
		Comision comision = new Comision(idComision, materia1, turno);
		
		// preparacion

		unlam.registrarDocente(docente1);
		unlam.agregarCicloLectivo(cicloLectivo1);
		cicloLectivo1.agregarComision(comision);
		

		// ejecucion
		cicloLectivo1.asignarDocenteAComision(idComision, docente1);
		Boolean resultadoFallido = cicloLectivo1.asignarDocenteAComision(idComision, docente1);

		// validacion
		assertFalse(resultadoFallido);

	}

	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		Integer idMateriaPrimera = 1;
		String nombreMateriaPrimera = "PB1";
		Integer idMateriaSegunda = 2;
		String nombreMateriaSegunda = "PB2";
		Boolean resultadoEsperado = false;

		Universidad unlam = new Universidad("Unlam");
		Materia materiaPrimera = new Materia(idMateriaPrimera, nombreMateriaPrimera);
		Materia materiaSegunda = new Materia(idMateriaSegunda, nombreMateriaSegunda);

		unlam.registrarMateria(materiaPrimera);
		unlam.registrarMateria(materiaSegunda);
		resultadoEsperado = unlam.agregarMateriaCorrelativa(materiaSegunda.getIdMateria(),
				materiaPrimera.getIdMateria());

		assertTrue(resultadoEsperado);

	}

	@Test
	public void queSePuedaEliminarUnaMateriaCorrelativa() {

		String nombreUniversidad = "Unlam", nombreMateria1 = "Programacion I", nombreMateria2 = "Programacion II";
		Integer idMateria1 = 1, idMateria2 = 2;

		// preparacion

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia1 = new Materia(idMateria1, nombreMateria1);
		Materia materia2 = new Materia(idMateria2, nombreMateria2);

		// ejecucion
		unlam.registrarMateria(materia1);
		unlam.registrarMateria(materia2);
		Boolean sePudoEliminar = unlam.eliminarCorrelativa(idMateria1, idMateria2);

		// validacion
		assertTrue(sePudoEliminar);

	}

	@Test
	public void queSePuedaInscribirUnAlumnoAUnaComision() {
		Boolean inscripcionExitosa = false;

		String nombreUniversidad = "Unlam", nombreAlumno = "Bruno", apellidoAlumno = "Merlo";
		Integer dniAlumno = 1;
		LocalDate fechaDeIngreso = LocalDate.of(2023, 2, 23);
		
		Integer idCicloLectivo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 14);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 1);
	
		Integer idComision = 1;
		Materia materia1 = new Materia(1, "Matematica");

		Turno turno = Turno.Mañana;

		// preparacion


		// ejecucion
		CicloLectivo cicloLectivo = new CicloLectivo(idCicloLectivo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,fechaInscripcion);
		Universidad unlam = new Universidad(nombreUniversidad);
		Comision comision = new Comision(idComision, materia1, turno);
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno, fechaDeIngreso);
		
		unlam.registrar(alumno);
		unlam.agregarCicloLectivo(cicloLectivo);
		cicloLectivo.agregarComision(comision);
		inscripcionExitosa= unlam.inscribirAlumnoAComision(alumno.getDniAlumno(), comision.getIdComision(),cicloLectivo);
		

		// validacion
		assertTrue(inscripcionExitosa);

	}
	
//	@Test
//	public void queNoSePuedaInscribirUnAlumnoAUnaComisionSiNoTieneLasCorrelativasAprobadas() {
//		Boolean inscripcionExitosa = false;
//
//		String nombreUniversidad = "Unlam", nombreAlumno = "Bruno", apellidoAlumno = "Merlo";
//		Integer dniAlumno = 1;
//		LocalDate fechaDeIngreso = LocalDate.of(2023, 2, 23);
//		
//		Integer idCicloLectivo = 1;
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 14);
//		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 1);
//	
//		Integer idComision = 1;
//		Materia materia1 = new Materia(1, "Matematica");
//
//		Turno turno = Turno.Mañana;
//
//		// preparacion
//
//
//		// ejecucion
//		CicloLectivo cicloElectivo = new CicloLectivo(idCicloLectivo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,fechaInscripcion);
//		Universidad unlam = new Universidad(nombreUniversidad);
//		Comision comision = new Comision(idComision, materia1, cicloElectivo, turno);
//		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno, fechaDeIngreso);
//		
//		unlam.registrar(alumno);
//		unlam.agregarCicloElectivo(cicloElectivo);
//		unlam.agregarComision(comision);
//		inscripcionExitosa= unlam.inscribirAlumnoAComision(alumno.getDniAlumno(), comision.getIdComision());
//		
//
//		// validacion
//		assertTrue(inscripcionExitosa);
//
//	}

}
