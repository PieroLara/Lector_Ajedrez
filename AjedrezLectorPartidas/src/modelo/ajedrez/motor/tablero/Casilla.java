package modelo.ajedrez.motor.tablero;

import java.util.HashMap;
import java.util.Map;

import modelo.ajedrez.motor.fichas.Fichas;

public abstract class Casilla {

	final int coordenadaCasilla;
	Fichas fichaEnCasilla;

	public Casilla(final int coordenadaCasilla) {
		this.coordenadaCasilla = coordenadaCasilla;
	}

	public abstract boolean isCasillaOcupada();

	public abstract Fichas getFichas();

	public int getCoordenadaCasilla() {
		return this.coordenadaCasilla;
	}

	//private static final HashMap<Integer, Casilla> MAPA_CASILLAS_VACIAS_CACHE = creaTableroLimpio();

	public  static HashMap<Integer, Casilla> creaTablero(HashMap<Integer, Fichas> todasFichas) {
		final HashMap<Integer, Casilla> mapaVacio = new HashMap<>();
		for (int i = 0; i < UtilTablero.NUM_CASILLAS; i++) {
			
			mapaVacio.put(i, creaCasilla(i, null));
		}
		return mapaVacio;
	}

	public static Casilla creaCasilla(final int coordenadaCasilla, final Fichas ficha) {
		return ficha != null ? new CasillaOcupada(coordenadaCasilla, ficha)
				: MAPA_CASILLAS_VACIAS_CACHE.get(coordenadaCasilla);
	}

	public static final class CasillaVacia extends Casilla {
		private CasillaVacia(final int coordenadaCasilla) {
			super(coordenadaCasilla);
		}

		@Override
		public String toString() {
			return UtilTablero.isCasillaOscura(coordenadaCasilla) + " " + " " + " " + UtilTablero.RESET;

		}

		@Override
		public boolean isCasillaOcupada() {
			return false;
		}

		@Override
		public Fichas getFichas() {
			return null;
		}

	}

	public static final class CasillaOcupada extends Casilla {
		private final Fichas fichaEnCasilla;

		private CasillaOcupada(int coordenadaCasilla, final Fichas fichaEnCasilla) {
			super(coordenadaCasilla);
			this.fichaEnCasilla = fichaEnCasilla;
		}

		@Override
		public String toString() {

			return UtilTablero.isCasillaOscura(coordenadaCasilla) + " "
					+ (getFichas().getColorFicha().isNegra() ? getFichas().toString().toLowerCase()
							: getFichas().toString())
					+ " " + UtilTablero.RESET;
		}

		@Override
		public boolean isCasillaOcupada() {
			return true;
		}

		@Override
		public Fichas getFichas() {
			return this.fichaEnCasilla;
		}
	}
}
