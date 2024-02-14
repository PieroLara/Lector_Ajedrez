package modelo.ajedrez.motor.tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import modelo.ajedrez.motor.fichas.Color;
import modelo.ajedrez.motor.fichas.Fichas;

public class Tablero {

	public HashMap<Integer, Casilla> getTableroJuego() {
		return tableroJuego;
	}

	public void setTableroJuego(HashMap<Integer, Casilla> tableroJuego) {
		this.tableroJuego = tableroJuego;
	}

	public HashMap<Integer, Fichas> getTodasFichas() {
		return todasFichas;
	}

	public void setTodasFichas(HashMap<Integer, Fichas> todasFichas) {
		this.todasFichas = todasFichas;
	}

	private HashMap<Integer, Casilla> tableroJuego;
	private HashMap<Integer, Fichas> todasFichas;

	public Tablero(HashMap<Integer, Fichas> fichasBlancas, HashMap<Integer, Fichas> fichasNegras) {
		// TODO Tiene que primero ejecutar el movimiento, y luego se hace llamada con el
		// array de fichas actualizado.

		this.todasFichas.putAll(fichasNegras);
		this.todasFichas.putAll(fichasBlancas);
		for (Map.Entry<Integer, Fichas> entry : todasFichas.entrySet()) {
			int key = entry.getKey();
			Fichas val = entry.getValue();
			System.out.println(key + " " + val.getTipoFicha() + " " + val.getColorFicha());
		}
		this.tableroJuego = Casilla.creaTablero(todasFichas);
	}

	public static Tablero creaTableroInicial() {
		HashMap<Integer, Fichas> fichasBlancas = creaFichasTablero(Color.BLANCAS);
		HashMap<Integer, Fichas> fichasNegras = creaFichasTablero(Color.NEGRAS);

		return new Tablero(fichasBlancas, fichasNegras);

	}

	private static HashMap<Integer, Fichas> creaFichasTablero(Color color) {
		HashMap<Integer, Fichas> mapaFichas = new HashMap<>();

		for (int i = 0; i < UtilTablero.NUM_FICHAS_COLOR; i++) {
			
		}
		
		
		return mapaFichas;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append(UtilTablero.letraCasilla());
		for (int i = 0; i < UtilTablero.NUM_CASILLAS; i++) {
			if ((i + 1) % UtilTablero.NUM_CASILLAS_POR_FILA == 1) {
				builder.append(UtilTablero.valorReverso(i / 8) + " ");
			}
			final String representaCasilla = this.tableroJuego.get(i).toString();
			builder.append(String.format("%3s", representaCasilla));
			if ((i + 1) % UtilTablero.NUM_CASILLAS_POR_FILA == 0) {
				builder.append(" " + UtilTablero.valorReverso(i / 8) + "\n");
			}
		}
		builder.append(UtilTablero.letraCasilla());
		return builder.toString();
	}
}
