package banco;

import java.awt.font.LineMetrics;
import java.time.InstantSource;

public class Turno {

	private TipoTurno tipoTurno;

	private int numeroFinal;
	private static int numero;

	public Turno(TipoTurno tipoTurno) {
		this.tipoTurno = tipoTurno;
		setNumero(numeroFinal);
	}

	public TipoTurno getTipoTurno() {
		return tipoTurno;
	}

	public void setTipoTurno(TipoTurno tipoTurno) {
		this.tipoTurno = tipoTurno;
	}

	public void incrementar(int numero) {
		setNumero(numero);
	}

	private void setNumero(int nuemroFinal) {
		this.numeroFinal = nuemroFinal;

	}

	@Override
	public String toString() {
		return "Turno [" + tipoTurno.getLetra() + numeroFinal + "]";
	}

}
