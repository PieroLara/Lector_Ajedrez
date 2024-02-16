package controlador.gestor.motor.movimientos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import modelo.ajedrez.motor.fichas.Color;
import modelo.ajedrez.motor.fichas.Fichas;
import modelo.ajedrez.motor.tablero.Tablero;

public class Movimientos {
	public Movimientos() {
		this.fichaMovida = null;
		this.posicionInicial = 0;
		this.posicionFinal = 0;

	}

	public Fichas getFichaMovida() {
		return fichaMovida;
	}

	public int getPosicionInicial() {
		return posicionInicial;
	}

	public int getPosicionFinal() {
		return posicionFinal;
	}

	final Fichas fichaMovida;
	final int posicionInicial;
	final int posicionFinal;

	public Movimientos(int posicionInicial, int posicionFinal, Fichas fichaMovida) {
		this.fichaMovida = fichaMovida;
		this.posicionInicial = posicionInicial;
		this.posicionFinal = posicionFinal;
	}

	public HashMap<Integer, Movimientos> creaMapaMovimientos(String tituloPartida,
			HashMap<String, ArrayList<String>> mapaFichero) {
		int numeroMovimiento = 0;
		Color colorMovimiento;
		HashMap<Integer, Movimientos> mapaMovimientos = new HashMap<>();
		for (String registroMovimeinto : mapaFichero.get(tituloPartida)) {

			identificaMovimiento(registroMovimeinto,
					colorMovimiento = (numeroMovimiento % 2 == 0) ? Color.BLANCAS : Color.NEGRAS);
			// mapaMovimientos.put(numeroMovimiento,
			// identificaMovimiento(registroMovimeinto));
			numeroMovimiento++;
		}

		return mapaMovimientos;
	}

	private Movimientos identificaMovimiento(String movimientoFichero, Color color) {

		ArrayList<String> movimientoSeparado = new ArrayList<>(Arrays.asList(movimientoFichero.split("")));

//TODO Mapa Tablero		
		if (movimientoSeparado.contains("x")) {
			for (String string : movimientoSeparado) {

				System.out.print(string);
			}
			System.out.println();
		} else {

		}

		return new Movimientos(posicionInicial, posicionFinal, fichaMovida);
	}

//TODO tiene que contar cual es la ficha que se ha movido, y si se ha capturado a otra.
	// replantearse bien el funcionamiento de las fichas para que almacenen bien si
	// están disponibles o no.
	public HashMap<Integer, Tablero> cargaMovimientosEnTablero(ArrayList<Movimientos> ListadoMovimientos,
			Tablero tableroActual) {
		HashMap<Integer, Fichas> fichasBlancas;
		HashMap<Integer, Fichas> fichasNegras;
		HashMap<Integer, Tablero> mapaTableroPartida = new HashMap<>();
		int posicionPartida = 0;
		for (Movimientos movimientos : ListadoMovimientos) {

			mapaTableroPartida.put(posicionPartida, tableroActual);
			posicionPartida++;
		}

		return mapaTableroPartida;
	}
}
