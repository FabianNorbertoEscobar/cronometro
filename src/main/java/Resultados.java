import java.util.LinkedList;
import java.util.List;

public class Resultados {

	private List<Double> valores;
	private Double total;

	public Resultados(List<Long> capturas, Precision precision) {
		Long previo = null;
		this.valores = new LinkedList<Double>();

		for (Long val : capturas) {
			if (previo != null) {
				valores.add(precision.desdeNano(val - previo));
			}
			previo = val;
		}
		
		this.total = (double) previo - capturas.get(0);
	}

	public double get(int i) {
		return this.valores.get(i);
	}

	public Double getTotal() {
		return this.total;
	}
	
}
