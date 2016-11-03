package edu.unlam.progra.crono;

import org.junit.Assert;

public abstract class AuxiliaresDeTesting {

	public void simularProcesoDeXMilisegundos(long milisegundos) throws InterruptedException {
		Thread.sleep(milisegundos);
	}

	public void assertMedicionesConDesviosMenoresAUnoPorciento(double[] minimos, Mediciones mediciones) {
		for (int indice = 0; indice < minimos.length; indice++) {
			double actual = minimos[indice];
			Assert.assertEquals(mediciones.get(indice), actual, 0.01);
		}
	}

	public void assertMedicionConDesvioMenorAUnoPorciento(double minimo, Mediciones mediciones) {
		Assert.assertEquals(minimo, mediciones.getTotal(), 0.01);
	}

	public void assertResultadosConDesviosMenoresAUnoPorciento(double[] minimos, double[] resultados) {
		for (int indice = 0; indice < minimos.length; indice++) {
			double actual = minimos[indice];
			Assert.assertEquals(resultados[indice], actual, 0.01);
		}
	}
}
