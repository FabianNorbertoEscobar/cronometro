import java.util.LinkedList;
import java.util.List;

public class Mediciones {

	private List<Double> valores;
	private Double total;

	public Mediciones(List<Long> capturas, Precision precision) {
		Long previo = null;
		this.valores = new LinkedList<Double>();

		for (Long medicion : capturas) {
			if (previo != null) {
				valores.add(precision.desdeNano(medicion - previo));
			}
			previo = medicion;
		}
		
		this.total = (double) previo - capturas.get(0);
	}

	public double get(int indice) {
		return this.valores.get(indice);
	}

	public Double getTotal() {
		return this.total;
	}
	
}
