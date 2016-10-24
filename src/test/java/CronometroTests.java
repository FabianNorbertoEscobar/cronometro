import org.junit.Assert;
import org.junit.Test;

public class CronometroTests {

	@Test
	public void funcionamientoStandard() throws InterruptedException {
		Cronometro crono = new Cronometro(Precision.SEGUNDOS);
		crono.clic();
		Thread.sleep(1000);
		crono.clic();
		Assert.assertTrue(crono.getMediciones().get(0) >= 1.0);
		Assert.assertTrue(crono.getMediciones().getTotal() >= 1.0);
	}
	
	@Test
	public void funcionamientoConclicks() throws InterruptedException {
		Cronometro crono = new Cronometro(Precision.SEGUNDOS);
		crono.clic();
		Thread.sleep(1000);
		crono.clic();
		Thread.sleep(500);
		crono.clic();
		Assert.assertTrue(crono.getMediciones().get(0) >= 1.0);
		Assert.assertTrue(crono.getMediciones().get(1) >= 0.5);
	}
	
	@Test
	public void dosCronometrosEnUno() throws InterruptedException {
		Cronometro crono = new Cronometro(Precision.SEGUNDOS);
		crono.clic("uno");
		Thread.sleep(1000);
		crono.clic("uno");
		Thread.sleep(500);
		crono.clic("dos");
		Thread.sleep(500);
		crono.clic("dos");
		Thread.sleep(1000);
		crono.clic("dos");
		crono.clic("uno");
		Assert.assertTrue(crono.getMediciones("uno").get(0) >= 1.0);
		Assert.assertTrue(crono.getMediciones("uno").get(1) >= 1.0);
		Assert.assertTrue(crono.getMediciones("dos").get(0) >= 0.5);
		Assert.assertTrue(crono.getMediciones("dos").get(1) >= 1.0);
	}
	
	@Test
	public void queMideTiempoTotal() throws InterruptedException {
		Cronometro crono = new Cronometro(Precision.SEGUNDOS);
		crono.clic("uno");
		Thread.sleep(1000);
		crono.clic("uno");
		Thread.sleep(500);
		crono.clic("uno");
		Assert.assertTrue(crono.getMediciones("uno").getTotal() >= 1.5);
	}

}
