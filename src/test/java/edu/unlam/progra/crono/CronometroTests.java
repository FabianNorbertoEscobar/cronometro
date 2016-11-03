package edu.unlam.progra.crono;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.progra.crono.Cronometro;
import edu.unlam.progra.crono.Mediciones;
import edu.unlam.progra.crono.Precision;

public class CronometroTests extends AuxiliaresDeTesting {

	private static final String PROCESO_UNO = "proceso uno";
	private static final String PROCESO_DOS = "proceso dos";
	private Cronometro crono;

	@Before
	public void setUp() {
		crono = new Cronometro(Precision.SEGUNDOS);
	}

	@Test
	public void funcionamientoStandard() throws InterruptedException {

		crono.clic();
		simularProcesoDeXMilisegundos(100);
		crono.clic();

		Mediciones mediciones = crono.getMediciones();
		assertMedicionesConDesviosMenoresAUnoPorciento(new double[] { 0.1 }, mediciones);
		assertMedicionConDesvioMenorAUnoPorciento(0.1, mediciones);
	}

	@Test
	public void funcionamientoConclicks() throws InterruptedException {

		crono.clic();
		simularProcesoDeXMilisegundos(100);
		crono.clic();
		simularProcesoDeXMilisegundos(50);
		crono.clic();

		Mediciones mediciones = crono.getMediciones();
		assertMedicionesConDesviosMenoresAUnoPorciento(new double[] { 0.1, 0.05 }, mediciones);
	}

	@Test
	public void dosCronometrosEnUno() throws InterruptedException {

		crono.clic(PROCESO_UNO);
		simularProcesoDeXMilisegundos(100);
		crono.clic(PROCESO_UNO);
		simularProcesoDeXMilisegundos(50);
		crono.clic(PROCESO_DOS);
		simularProcesoDeXMilisegundos(50);
		crono.clic(PROCESO_DOS);
		simularProcesoDeXMilisegundos(100);
		crono.clic(PROCESO_DOS);
		crono.clic(PROCESO_UNO);

		Mediciones mediciones = crono.getMediciones(PROCESO_UNO);
		assertMedicionesConDesviosMenoresAUnoPorciento(new double[] { 0.1, 0.2 }, mediciones);

		mediciones = crono.getMediciones(PROCESO_DOS);
		assertMedicionesConDesviosMenoresAUnoPorciento(new double[] { 0.05, 0.1 }, mediciones);
	}

	@Test
	public void queMideTiempoTotal() throws InterruptedException {

		crono.clic(PROCESO_UNO);
		simularProcesoDeXMilisegundos(100);
		crono.clic(PROCESO_UNO);
		simularProcesoDeXMilisegundos(50);
		crono.clic(PROCESO_UNO);

		Mediciones mediciones = crono.getMediciones(PROCESO_UNO);
		assertMedicionConDesvioMenorAUnoPorciento(0.15, mediciones);
	}
}
