package controlador.gestorDocumentos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.ajedrez.registros.Partidas;

public class GestorFicherosLecturaPartidas {
	public String[] cargaArchivos() throws IOException {
		String contenido[] = UtilesEscrituraArchivos.DIRECTORIO.list();
		System.out.println("Listado de ficheros disponibles:");
		for (int i = 0; i < contenido.length; i++) {
			System.out.println(i + ". " + contenido[i]);
		}
		return contenido;
	}

	public HashMap<String, ArrayList<String>> funcionLectoraFichero(Partidas partidaCargada) {
		ArrayList<String> registro = new ArrayList<>();
		System.out.println("Estoyleyendo el fichero"); 
		HashMap<String, ArrayList<String>> mapa = new HashMap<String, ArrayList<String>>();
		try {
			FileReader lector = new FileReader(partidaCargada.getFichero());
			BufferedReader br = new BufferedReader(lector);
			String linea = "";
			String titulo = "";
			titulo = br.readLine();

			while ((linea = br.readLine()) != null) {
				String[] lineaSeparaPuntos = linea.split(" ");
				for (int i = 1; i < lineaSeparaPuntos.length; i++) {
					registro.add(lineaSeparaPuntos[i]);
				}
			}
			mapa.put(titulo, registro);
			br.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapa;

	}

}
