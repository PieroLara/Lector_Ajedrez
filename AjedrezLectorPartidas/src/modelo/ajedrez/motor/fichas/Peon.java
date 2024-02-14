package modelo.ajedrez.motor.fichas;

import java.util.ArrayList;
import java.util.Collection;

import controlador.gestor.motor.movimientos.Movimientos;
import modelo.ajedrez.motor.tablero.Tablero;

public class Peon extends Fichas {

	private static final int[] MOVIMIENTOS_POSIBLES={ 8, 16, 7, 9 };
	
	
	Peon(TipoFicha tipoFicha, int posicionFicha, Color colorFicha, boolean esCapturada, int posicionInicial) {
		super(tipoFicha, posicionFicha, colorFicha, esCapturada, posicionInicial);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Movimientos> calculaMovimientosLegales(Tablero tablero) {
		
		
		
		
		
		return null;
	}

	@Override
	public Fichas moverPieza(Movimientos movimiento) {
		// TODO Auto-generated method stub
		return null;
	}

}
