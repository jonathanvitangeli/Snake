package banco;

import java.util.LinkedList;
import java.util.Queue;

public class Banco {

	Queue<Turno> cola = new LinkedList<>();
	private int contadorDeposito = 1;
	private int contadorCompra = 1;
	private int contadorConsulta = 1;
	private int contadorRetiro = 1;

	public Banco() {
		super();

	}

	public void agregarTurno(Turno turno) {
		// Asignar número según el tipo de turno
		switch (turno.getTipoTurno()) {
		case DEPOSITO:
			turno.incrementar(contadorDeposito++);
			break;
		case COMPRA:
			turno.incrementar(contadorCompra++);
			break;
		case CONSULTA:
			turno.incrementar(contadorConsulta++);
			break;
		case RETIRO:
			turno.incrementar(contadorRetiro++);
			break;
		default:
			System.out.println("Tipo de turno no válido.");
			return;
		}

		// Agregar el turno a la cola
		cola.add(turno);
		System.out.println("Turno agregado: " + turno);
	}

	// Método para devolver 
	public Turno pedirTurno() {
		if (cola.isEmpty()) {
			System.out.println("No hay turnos disponibles.");
			return null;
		} else {
			Turno turno = cola.poll();
			System.out.println("Atendiendo turno: " + turno);
			return turno;
		}
	}

	public void mostrarCola() {
		System.out.println("Cola de turnos: " + cola.toString());
	}

}
