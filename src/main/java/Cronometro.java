import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cronometro {

	private static final String ANONIMO = "anonimo";

	private Precision precision;
	private Map<String, List<Long>> mediciones = new HashMap<String, List<Long>>();

	public Cronometro(Precision precision) {
		this.precision = precision;
	}

	public Cronometro() {
		this(Precision.SEGUNDOS);
	}

	public void clic() {
		clic(ANONIMO);
	}

	public void clic(String clave) {
		List<Long> medicionesPorClave = mediciones.get(clave);

		if (medicionesPorClave == null) {
			medicionesPorClave = new LinkedList<Long>();
		}
		medicionesPorClave.add(System.nanoTime());
		mediciones.put(clave, medicionesPorClave);
	}

	public Mediciones getMediciones(String clave) {
		return procesar(clave);
	}

	public Mediciones getMediciones() {
		return getMediciones(ANONIMO);
	}

	private Mediciones procesar(String key) {
		return new Mediciones(mediciones.get(key), this.precision);
	}
}
