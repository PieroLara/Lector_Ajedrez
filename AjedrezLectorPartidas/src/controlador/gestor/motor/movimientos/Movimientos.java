package controlador.gestor.motor.movimientos;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.ajedrez.motor.fichas.Fichas;
import modelo.ajedrez.motor.tablero.Tablero;

public class Movimientos {
	final Fichas fichaMovida;
	final int posicionInicial;
	final int posicionFinal;

	public Movimientos(int posicionInicial, int posicionFinal, Fichas fichaMovida) {
		this.fichaMovida = fichaMovida;
		this.posicionInicial = posicionInicial;
		this.posicionFinal = posicionFinal;
	}

//TODO tiene que contar cual es la ficha que se ha movido, y si se ha capturado a otra.
	// replantearse bien el funcionamiento de las fichas para que almacenen bien si
	// están disponibles o no.
	public HashMap<Integer, Tablero> ejecutaMovimiento(ArrayList<Movimientos> ListadoMovimientos) {
		HashMap<Integer, Fichas> fichasBlancas;
		HashMap<Integer, Fichas> fichasNegras;

		HashMap<Integer, Tablero> tableroActual = null;// new Tablero(null, null);

		return tableroActual;
	}
}
