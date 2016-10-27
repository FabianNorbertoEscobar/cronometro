package edu.unlam.progra.crono;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.progra.crono.Cronometro;
import edu.unlam.progra.crono.Mediciones;
import edu.unlam.progra.crono.Precision;

public class CronometroTests {

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
		simularProcesoDeXMilisegundos(1000);
		crono.clic();

		Mediciones mediciones = crono.getMediciones();
		assertMedicionesMayoresQue(new double[] { 1.0 }, mediciones);
		assertMedicionTotalMayorQue(1.0, mediciones);
	}

	@Test
	public void funcionamientoConclicks() throws InterruptedException {

		crono.clic();
		simularProcesoDeXMilisegundos(1000);
		crono.clic();
		simularProcesoDeXMilisegundos(500);
		crono.clic();

		Mediciones mediciones = crono.getMediciones();
		assertMedicionesMayoresQue(new double[] { 1.0, 0.5 }, mediciones);
	}

	@Test
	public void dosCronometrosEnUno() throws InterruptedException {

		crono.clic(PROCESO_UNO);
		simularProcesoDeXMilisegundos(1000);
		crono.clic(PROCESO_UNO);
		simularProcesoDeXMilisegundos(500);
		crono.clic(PROCESO_DOS);
		simularProcesoDeXMilisegundos(500);
		crono.clic(PROCESO_DOS);
		simularProcesoDeXMilisegundos(1000);
		crono.clic(PROCESO_DOS);
		crono.clic(PROCESO_UNO);

		Mediciones mediciones = crono.getMediciones(PROCESO_UNO);
		assertMedicionesMayoresQue(new double[] { 1.0, 1.0 }, mediciones);

		mediciones = crono.getMediciones(PROCESO_DOS);
		assertMedicionesMayoresQue(new double[] { 0.5, 1.0 }, mediciones);
	}

	@Test
	public void queMideTiempoTotal() throws InterruptedException {

		crono.clic(PROCESO_UNO);
		simularProcesoDeXMilisegundos(1000);
		crono.clic(PROCESO_UNO);
		simularProcesoDeXMilisegundos(500);
		crono.clic(PROCESO_UNO);

		Mediciones mediciones = crono.getMediciones(PROCESO_UNO);
		assertMedicionTotalMayorQue(1.5, mediciones);
	}

	private void simularProcesoDeXMilisegundos(long milisegundos) throws InterruptedException {
		Thread.sleep(milisegundos);
	}

	private void assertMedicionesMayoresQue(double[] minimos, Mediciones mediciones) {
		for (int indice = 0; indice < minimos.length; indice++) {
			double actual = minimos[indice];
			Assert.assertTrue(mediciones.get(indice) >= actual);
		}
	}

	private void assertMedicionTotalMayorQue(double minimo, Mediciones mediciones) {
		Assert.assertTrue(mediciones.getTotal() >= minimo);
	}
}
