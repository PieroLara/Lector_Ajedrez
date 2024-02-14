package modelo.ajedrez.motor.fichas;

import java.util.ArrayList;
import java.util.HashMap;

import controlador.gestor.motor.movimientos.Movimientos;
import modelo.ajedrez.motor.tablero.Tablero;

public abstract class Fichas {

	protected final TipoFicha tipoFicha;
	int posicionFicha;
	protected final Color colorFicha;
	final boolean esCapturada;
	protected final int posicionInicial;

	Fichas(final TipoFicha tipoFicha, final int posicionFicha, final Color colorFicha, final boolean esCapturada, int posicionInicial) {
		this.tipoFicha = tipoFicha;
		this.posicionFicha = posicionFicha;
		this.colorFicha = colorFicha;
		this.esCapturada = esCapturada;
		this.posicionInicial = posicionInicial;
	}

	public int getPosicionFicha() {
		return posicionFicha;
	}

	public void setPosicionFicha(int posicionFicha) {
		this.posicionFicha = posicionFicha;
	}

	public TipoFicha getTipoFicha() {
		return tipoFicha;
	}

	public boolean isEsCapturada() {
		return esCapturada;
	}

	public abstract HashMap<Integer,ArrayList<Movimientos>> calculaMovimientosLegales(final Tablero tablero);

	public abstract Fichas moverPieza(Movimientos movimiento);
	public abstract Fichas capturarPieza(Movimientos movimiento, Fichas fichaCapturada);

	public Color getColorFicha() {

		return this.colorFicha;
	}

}
