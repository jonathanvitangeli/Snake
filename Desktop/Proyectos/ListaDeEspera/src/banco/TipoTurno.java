package banco;

public enum TipoTurno {
	DEPOSITO("D"), RETIRO("R"), CONSULTA("CN"), COMPRA("C") ;

	TipoTurno(String letra) {
		this.letra = letra;
	}

	private String letra;

	public String getLetra() {
		return letra;
	}

}
