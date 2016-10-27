package edu.unlam.progra.crono;
import org.junit.Assert;
import org.junit.Test;

import edu.unlam.progra.crono.Precision;

public class PrecisionTests {

	@Test
	public void conversiones() {
		final long UN_MILLON = 1_000_000;

		// UN_MILLON nanosegundos son UN_MILLON nanosegundos
		Assert.assertEquals(UN_MILLON, Precision.NANOSEGUNDOS.desdeNano(UN_MILLON), 0);

		// UN_MILLON nanosegundos son 1_000 microsegundos
		Assert.assertEquals(1_000, Precision.MICROSEGUNDOS.desdeNano(UN_MILLON), 0);

		// UN_MILLON nanosegundos son 1 milisegundo
		Assert.assertEquals(1, Precision.MILISEGUNDOS.desdeNano(UN_MILLON), 0);

		// UN_MILLON nanosegundos son 0.001 segundos
		Assert.assertEquals(0.001, Precision.SEGUNDOS.desdeNano(UN_MILLON), 0);
	}

	@Test
	public void formato() {
		Assert.assertEquals("1 s", Precision.SEGUNDOS.formatear(1));
		Assert.assertEquals("1 µs", Precision.MICROSEGUNDOS.formatear(1));
		Assert.assertEquals("1 ms", Precision.MILISEGUNDOS.formatear(1));
		Assert.assertEquals("1 ns", Precision.NANOSEGUNDOS.formatear(1));
	}
}
