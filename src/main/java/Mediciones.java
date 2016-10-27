import java.util.LinkedList;
import java.util.List;

public class Mediciones {

	private List<Double> valores;
	private Double total;
	private Precision precision;

	public Mediciones(final List<Long> capturas, final Precision precision) {
		this.precision = precision;
		this.valores = new LinkedList<Double>();

		Long previo = null;
		for (Long medicion : capturas) {
			if (previo != null) {
				valores.add(precision.desdeNano(medicion - previo));
			}
			previo = medicion;
		}

		this.total = (double) previo - capturas.get(0);
	}

	public double get(final int indice) {
		return this.valores.get(indice);
	}

	public Double getTotal() {
		return this.total;
	}
}
