package banco;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Banco banco = new Banco();
		Turno turno = new Turno(TipoTurno.DEPOSITO);
		Turno turno1 = new Turno(TipoTurno.COMPRA);
		Turno turno2 = new Turno(TipoTurno.CONSULTA);
		Turno turno3 = new Turno(TipoTurno.RETIRO);
		banco.agregarTurno(new Turno(TipoTurno.DEPOSITO));
		banco.agregarTurno(new Turno(TipoTurno.COMPRA));
		banco.agregarTurno(new Turno(TipoTurno.CONSULTA));
		banco.agregarTurno(new Turno(TipoTurno.RETIRO));
		banco.agregarTurno(new Turno(TipoTurno.DEPOSITO));
		banco.agregarTurno(new Turno(TipoTurno.COMPRA));
		banco.agregarTurno(new Turno(TipoTurno.CONSULTA));
		banco.agregarTurno(new Turno(TipoTurno.RETIRO));
		banco.agregarTurno(new Turno(TipoTurno.DEPOSITO));
		banco.agregarTurno(new Turno(TipoTurno.COMPRA));
	

		banco.mostrarCola();
		System.out.println("-----------------------------------------------------------------");
		// Pedir turnos (eliminar y devolver el primero de la cola)
		banco.pedirTurno();
		banco.pedirTurno();
		banco.pedirTurno();
		banco.pedirTurno();
		banco.pedirTurno();
		banco.pedirTurno();
		banco.pedirTurno();

		System.out.println("-----------------------------------------------------------------");

		// Mostrar la cola de turnos después de atender algunos
		banco.mostrarCola();
	}

}
