package edu.unlam.progra.crono.presentadores;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.progra.crono.AuxiliaresDeTesting;
import edu.unlam.progra.crono.Cronometro;
import edu.unlam.progra.crono.Mediciones;
import edu.unlam.progra.crono.Precision;


public class PresentadorDeTiemposDetalladoTests extends AuxiliaresDeTesting {

	private Cronometro crono;

	@Before
	public void setUp() {
		crono = new Cronometro(Precision.SEGUNDOS);
	}
	
	@Test
	public void funcionamientoConclicks() throws InterruptedException {

		crono.clic();
		simularProcesoDeXMilisegundos(100);
		crono.clic();
		simularProcesoDeXMilisegundos(50);
		crono.clic();

		PresentadorDeTiemposDetallado presentador = new PresentadorDeTiemposDetallado(crono.getMediciones());
		assertResultadosConDesviosMenoresAUnoPorciento(new double[] { 0.1, 0.05 }, presentador.getResultados());
		Assert.assertTrue(presentador.toString().matches("\\d\\.\\d{3} s\n\\d\\.\\d{3} s"));

	}
}
