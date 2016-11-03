package edu.unlam.progra.crono.presentadores;

import edu.unlam.progra.crono.Mediciones;

public class PresentadorDeTiemposPromedio extends PresentadorDeTiempos {

	public PresentadorDeTiemposPromedio(Mediciones mediciones) {
		super(mediciones);
	}

	public double getResultado() {
		return this.mediciones.getTotal() / this.mediciones.getCantidad();
	}

	@Override
	public String toString() {
		return this.mediciones.getPrecision().formatear(getResultado());
	}
}
