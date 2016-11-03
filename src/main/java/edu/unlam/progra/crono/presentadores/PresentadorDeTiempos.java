package edu.unlam.progra.crono.presentadores;

import edu.unlam.progra.crono.Mediciones;

public abstract class PresentadorDeTiempos {

	protected Mediciones mediciones;

	public PresentadorDeTiempos(Mediciones mediciones) {
		this.mediciones = mediciones;
	}
	
	public abstract String toString();
	
}
