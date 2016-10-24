import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cronometro {

	private static final String ANNONYMOUS = "annonymous";
	
	private Precision precision;
	private Map<String, List<Long>> valores = new HashMap<String, List<Long>>();

	public Cronometro(Precision precision) {
		this.precision = precision;
	}
	
	public Cronometro() {
		this(Precision.SEGUNDOS);
	}

	public void comenzar() {
		click();
	}

	public void finalizar() {
		click();
	}
	
	public void vuelta() {
		click();
	}
	
	public void comenzar(String key) {
		click(key);
	}

	public void finalizar(String key) {
		click(key);
	}
	
	public void vuelta(String key) {
		click(key);
	}
	
	private void click() {
		click(ANNONYMOUS);
	}

	private void click(String key) {
		List<Long> a = valores.get(key);
		
		if (a == null) {
			a = new LinkedList<Long>();
		}
		a.add(System.nanoTime());
		valores.put(key, a);
	}

	public List<Double> getParciales(String key) {
		return procesar(key);
	}
	
	public List<Double> getParciales() {
		return getParciales(ANNONYMOUS);
	}
	
	public Double getTotal(String key) {
		return total(key);
	}
	
	public Double getTotal() {
		return total(ANNONYMOUS);
	}
	
	private Double total(String key) {
		List<Long> valoresTmp = valores.get(key);
		Long ultimo = valoresTmp.get(valoresTmp.size() - 1);
		Long primero = valoresTmp.get(0);
		return (double) ultimo - primero;
	}
	
	private List<Double> procesar(String key) {
		Long previo = null;
		List<Double> resultado = new LinkedList<Double>();
		
		for (Long val : valores.get(key)) {
			if (previo != null) {
				resultado.add(this.precision.desdeNano(val - previo));
			}
			previo = val;
		}
		
		return resultado;
	}
}
