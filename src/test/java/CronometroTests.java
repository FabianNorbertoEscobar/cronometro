import org.junit.Assert;
import org.junit.Test;

public class CronometroTests {

	@Test
	public void funcionamientoStandard() throws InterruptedException {
		Cronometro crono = new Cronometro(Precision.SEGUNDOS);
		crono.comenzar();
		Thread.sleep(1000);
		crono.finalizar();
		Assert.assertTrue(crono.getParciales().get(0) >= 1.0);
	}
	
	@Test
	public void funcionamientoConVueltas() throws InterruptedException {
		Cronometro crono = new Cronometro(Precision.SEGUNDOS);
		crono.comenzar();
		Thread.sleep(1000);
		crono.vuelta();
		Thread.sleep(500);
		crono.finalizar();
		Assert.assertTrue(crono.getParciales().get(0) >= 1.0);
		Assert.assertTrue(crono.getParciales().get(1) >= 0.5);
	}
	
	@Test
	public void dosCronometrosEnUno() throws InterruptedException {
		Cronometro crono = new Cronometro(Precision.SEGUNDOS);
		crono.comenzar("uno");
		Thread.sleep(1000);
		crono.vuelta("uno");
		Thread.sleep(500);
		crono.comenzar("dos");
		Thread.sleep(500);
		crono.vuelta("dos");
		Thread.sleep(1000);
		crono.finalizar("dos");
		crono.finalizar("uno");
		Assert.assertTrue(crono.getParciales("uno").get(0) >= 1.0);
		Assert.assertTrue(crono.getParciales("uno").get(1) >= 1.0);
		Assert.assertTrue(crono.getParciales("dos").get(0) >= 0.5);
		Assert.assertTrue(crono.getParciales("dos").get(1) >= 1.0);
	}
	
	@Test
	public void queMideTiempoTotal() throws InterruptedException {
		Cronometro crono = new Cronometro(Precision.SEGUNDOS);
		crono.comenzar("uno");
		Thread.sleep(1000);
		crono.vuelta("uno");
		Thread.sleep(500);
		crono.finalizar("uno");
		Assert.assertTrue(crono.getTotal("uno") >= 1.5);
	}

}
