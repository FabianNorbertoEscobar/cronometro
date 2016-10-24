public enum Precision {

	SEGUNDOS((long) 1_000_000_000, "s"),
	MILISEGUNDOS((long) 1_000_000, "ms"),
	MICROSEGUNDOS((long) 1_000, "µs"),
	NANOSEGUNDOS((long) 1, "ns");

	Long factor;
	String simbolo;

	Precision(Long factor, String simbolo) {
		this.factor = factor;
		this.simbolo = simbolo;
	}

	public Double desdeNano(long nano) {
		return (((double) (nano))/this.factor);
	}

	public String formatear(long cantidad) {
		// TODO Auto-generated method stub
		return cantidad + " " + this.simbolo;
	}
}
