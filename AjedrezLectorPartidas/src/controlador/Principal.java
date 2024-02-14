package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controlador.gestorDocumentos.GestorXML;
import modelo.ajedrez.motor.tablero.Tablero;
import modelo.ajedrez.registros.Partidas;
import vista.terminal.GUI.PreguntasUsuario;

public class Principal {
	public static void main(String[] args) {
		/**
		 * Restos de la primera versión del planteamiento del dibujado del tablero, se
		 * quedan por necesidades de la documentación
		 */
		// RegistroTableros registrotablero= new RegistroTableros();
		// registrotablero.tablero();

		PreguntasUsuario pregunton = new PreguntasUsuario();
		Partidas nuevaPartida = new Partidas();
		int opcion = -1;
		int opcionMaxima = 1;
		HashMap<String, ArrayList<String>> totalPartidas = new HashMap<>();

		do {
			// TODO Arreglar opcion máxima, para que apunte a la misma posicion de memoria
			opcionMaxima = presentacionMenu(totalPartidas, opcionMaxima);
			opcion = pregunton.preguntaNumerosConPregunta("Por favor, introduzca una opción", 0, opcionMaxima);
			switch (opcion) {
			case 1:
				nuevaPartida = cargaPartidaNueva(nuevaPartida, totalPartidas);
				System.out.println("Se acabó final partida " + nuevaPartida.getNombreArchivo());
				System.out.println(nuevaPartida.getTodasLasJugadas().get("Reti - Tartakower").get(0));
				break;
			case 2:
				System.out.println("Mostrando el contenido del archivo:\t" + nuevaPartida.getNombreArchivo() + "\n\n"
						+ nuevaPartida.toString());
				break;
			case 3:
				muestraTableros(nuevaPartida);
				break;
			case 4:
				GestorXML.guardaPartida(totalPartidas);
				break;

			case 0:
				System.out.println("Hasta Luego!!");
				break;

			default:
				break;
			}

		} while (opcion != 0);
	}

	private static int presentacionMenu(HashMap<String, ArrayList<String>> totalPartidas, int opcionMaxima) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n*******************************************\n");
		sb.append("\nBienvenido al Menú princiapl");
		sb.append("\n1. Escoger una partida");
		if (!totalPartidas.isEmpty()) {
			sb.append("\n2. Mostrar las jugadas de la partida seleccionada");
			sb.append("\n3. Mostrar la partida seleccionada");
			sb.append("\n4. Registrar la partida seleccionada en XML");
			opcionMaxima = 4;
		}
		sb.append("\n0. Salir");
		System.out.println(sb);
		return opcionMaxima;
	}

	private static Partidas cargaPartidaNueva(Partidas nuevaPartida, HashMap<String, ArrayList<String>> totalPartidas) {
		nuevaPartida = nuevaPartida.seleccionaFichero();
		for (Map.Entry<String, ArrayList<String>> entry : nuevaPartida.getTodasLasJugadas().entrySet()) {
			if (!totalPartidas.containsKey(entry.getKey())) {
				System.out.println(entry.getKey());
				totalPartidas.put(entry.getKey(), entry.getValue());
			}
		}
		System.out.println("Final Cargar Partida" + nuevaPartida.getTodasLasJugadas().get("Reti - Tartakower").get(0));
		return nuevaPartida;
	}

	public static void muestraTableros(Partidas partidaEnsenyar) {
		PreguntasUsuario pregunton = new PreguntasUsuario();
		int posicion = 0;
		Tablero tablero = Tablero.creaTableroInicial();
		System.out.println(tablero);

		if (partidaEnsenyar.getListadoTablero() != null && !(partidaEnsenyar.getListadoTablero().isEmpty())) {
			do {

				posicion = pregunton.preguntaAvanzarRetroceder(posicion, partidaEnsenyar.getListadoTablero().size());
				System.out.println(String.valueOf(posicion));
				if (posicion != -1) {
					partidaEnsenyar.getListadoTablero().get(posicion).toString();
					// TODO
					// - Implementación de lectura de movimientos del array de movimientos del
					// tablero
				}

			} while (posicion != -1);
		} else {
			System.err.println("La partida introducida no contiene valores que puedan ser representados");
		}

	}
}