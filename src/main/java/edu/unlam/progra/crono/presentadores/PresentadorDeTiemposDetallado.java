package edu.unlam.progra.crono.presentadores;

import java.util.Iterator;

import edu.unlam.progra.crono.Mediciones;

public class PresentadorDeTiemposDetallado extends PresentadorDeTiempos {

	public PresentadorDeTiemposDetallado(Mediciones mediciones) {
		super(mediciones);
	}

	public double[] getResultados() {
		double[] arrayTemporal = new double[this.mediciones.getCantidad()];
		int i = 0;
		for (Iterator<Double> iterator = this.mediciones.iterator(); iterator.hasNext(); i++) {
			arrayTemporal[i] = iterator.next();
		}
		return arrayTemporal;
	}

	@Override
	public String toString() {
		String resultado = "";
		for (int i = 0; i < getResultados().length; i++) {
			resultado += this.mediciones.getPrecision().formatear(getResultados()[i]);
			if (i != getResultados().length - 1) {
				resultado += "\n";
			}
		}
		return resultado;
	}
}
