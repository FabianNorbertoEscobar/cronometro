public enum Precision {

	SEGUNDOS((long) 1_000_000_000),
	MILISEGUNDOS((long) 1_000_000),
	MICROSEGUNDOS((long) 1_000),
	NANOSEGUNDOS((long) 1);

	Long factor;

	Precision(Long factor) {
		this.factor = factor;
	}

	public Double desdeNano(long nano) {
		return (((double) (nano))/this.factor);
	}
}
