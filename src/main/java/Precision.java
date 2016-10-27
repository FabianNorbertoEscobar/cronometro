public enum Precision {

	SEGUNDOS((long) 1_000_000_000, "s"),
	MILISEGUNDOS((long) 1_000_000, "ms"),
	MICROSEGUNDOS((long) 1_000, "µs"),
	NANOSEGUNDOS((long) 1, "ns");

	private Long factor;
	private String simbolo;

	Precision(final Long factor, final String simbolo) {
		this.factor = factor;
		this.simbolo = simbolo;
	}

	public Double desdeNano(final long nano) {
		return (((double) (nano)) / this.factor);
	}

	public String formatear(final long cantidad) {
		return cantidad + " " + this.simbolo;
	}
}
