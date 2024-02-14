package modelo.ajedrez.motor.fichas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import controlador.gestor.motor.movimientos.Movimientos;
import modelo.ajedrez.motor.tablero.Tablero;

public class Peon extends Fichas {

	private static final int[] MOVIMIENTOS_POSIBLES = { 8, 16, 7, 9 };

	Peon(TipoFicha tipoFicha, int posicionFicha, Color colorFicha, boolean esCapturada, int posicionInicial) {
		super(tipoFicha, posicionFicha, colorFicha, esCapturada, posicionInicial);
	}

	@Override
	public HashMap<Integer, ArrayList<Movimientos>> calculaMovimientosLegales(Tablero tablero) {
		HashMap<Integer, ArrayList<Movimientos>> mapaMovimientosPeon = new HashMap<Integer, ArrayList<Movimientos>>();
		ArrayList<Movimientos> listaMovimientosPeon = new ArrayList<Movimientos>();
		if (this.esCapturada) {

			for (int i = 0; i < MOVIMIENTOS_POSIBLES.length; i++) {

				if (i == 1) {
					if (this.posicionFicha == this.posicionInicial) {
						if (!tablero.getTableroJuego().get(this.posicionFicha + MOVIMIENTOS_POSIBLES[i])
								.isCasillaOcupada()) {
							listaMovimientosPeon.add(new Movimientos(posicionFicha, MOVIMIENTOS_POSIBLES[i], this));
						}
					}
				} else if (i != 0) {
					if (tablero.getTableroJuego().get(this.posicionFicha + MOVIMIENTOS_POSIBLES[i]).isCasillaOcupada()
							&& tablero.getTableroJuego().get(this.posicionFicha + MOVIMIENTOS_POSIBLES[i]).getFichas()
									.getColorFicha() != this.colorFicha) {
						listaMovimientosPeon.add(new Movimientos(posicionFicha, MOVIMIENTOS_POSIBLES[i], this));
					}
				} else {
					if (!tablero.getTableroJuego().get(this.posicionFicha + MOVIMIENTOS_POSIBLES[i])
							.isCasillaOcupada()) {
						listaMovimientosPeon.add(new Movimientos(posicionFicha, MOVIMIENTOS_POSIBLES[i], this));
					}
				}
			}
		}
		mapaMovimientosPeon.put(this.posicionFicha, listaMovimientosPeon);
		
		return mapaMovimientosPeon;
	}

	@Override
	public Fichas moverPieza(Movimientos movimiento) {
//this.posicionFicha= movimiento;
		
		return null;
	}

	@Override
	public Fichas capturarPieza(Movimientos movimiento, Fichas fichaCapturada) {
		// TODO Auto-generated method stub
		return null;
	}

}
