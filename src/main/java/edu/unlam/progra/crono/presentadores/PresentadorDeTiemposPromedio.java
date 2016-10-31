package edu.unlam.progra.crono.presentadores;

import java.util.List;

import edu.unlam.progra.crono.Mediciones;

public class PresentadorDeTiemposPromedio {

	private Mediciones mediciones;

	public PresentadorDeTiemposPromedio(final Mediciones mediciones) {
		this.mediciones = mediciones;
	}

	public double getResultado() {
		List<Double> crudos = this.mediciones.getCrudos();
		return this.mediciones.getTotal() / crudos.size();
	}

	public String toString() {
		return this.mediciones.getPrecision().formatear(getResultado());
	}
}
