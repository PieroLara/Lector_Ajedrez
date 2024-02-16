package modelo.ajedrez.registros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import controlador.gestorDocumentos.GestorFicherosLecturaPartidas;
import controlador.gestorDocumentos.UtilesEscrituraArchivos;
import vista.terminal.GUI.PreguntasUsuario;


//TODO Crear un OBJETO TABLERO 
public class Partidas {
	private HashMap<String, ArrayList<String>> todasLasJugadas=new HashMap<String, ArrayList<String>>();
	private String nombreArchivo;
	private File fichero = null;
	//private ArrayList<Tablero> listadoTablero;

	/*public ArrayList<Tablero> getListadoTablero() {
		return listadoTablero;
	}

	public void setListadoTablero(ArrayList<Tablero> listadoTablero) {
		this.listadoTablero = listadoTablero;
	}
*/
	public Partidas() {
	}

	public Partidas seleccionaFichero() {
		Partidas partidaCargada = new Partidas();
		File fichero = null;
		try {
			String[] listaArchivos = new GestorFicherosLecturaPartidas().cargaArchivos();
			int repuestaUsuarioArchivo = new PreguntasUsuario().preguntaNumerosConPregunta("Qué archivo quiere elegir",
					0, (listaArchivos.length - 1));
			partidaCargada.setNombreArchivo(nombreArchivo = listaArchivos[repuestaUsuarioArchivo].toString());
			try {
				fichero = new File(UtilesEscrituraArchivos.DIRECTORIO, nombreArchivo);
				partidaCargada.setFichero(fichero);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Fichero no encontrado");
			}
			if (partidaCargada.getFichero() != null) {
				System.out.println("asdasdasd");
				partidaCargada.setTodasLasJugadas( new GestorFicherosLecturaPartidas().funcionLectoraFichero(partidaCargada));
				
				System.out.println(partidaCargada.getTodasLasJugadas().get("Reti - Tartakower"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return partidaCargada;
	}

	public File getFichero() {
		return fichero;
	}

	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	public void setTodasLasJugadas(HashMap<String, ArrayList<String>> todasLasJugadas) {
		this.todasLasJugadas = todasLasJugadas;

	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public HashMap<String, ArrayList<String>> getTodasLasJugadas() {
		return todasLasJugadas;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean jugadorBlancas = true;
		for (Entry<String, ArrayList<String>> entry : this.getTodasLasJugadas().entrySet()) {

			sb.append("entrada: " + entry.getKey() + "\n");
			ArrayList<String> val = ((Entry<String, ArrayList<String>>) entry).getValue();

			for (String string : val) {
				sb.append("jugador ");
				if (jugadorBlancas) {
					sb.append("Blancas: ");
					jugadorBlancas = false;
				} else {
					sb.append("Negras: ");
					jugadorBlancas = true;
				}

				sb.append(string + "\n");
			}
		}
		return sb.toString();
	}
}
