package controlador.gestorDocumentos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import modelo.ajedrez.registros.Partidas;
import vista.terminal.GUI.PreguntasUsuario;

public class GestorXML {
	private Document doc;
	private static final String FICHERO_SALIDA = UtilesEscrituraArchivos.DIRECTORIO_SALIDA + "\\Registra_Partidas.xml";
	private static final String FICHERO_f = UtilesEscrituraArchivos.DIRECTORIO_SALIDA + "\\f.xslt";

	public GestorXML() {
		try {

			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();

			if (doc == null) {
				doc = dbuilder.newDocument();
			} else {
				doc = dbuilder.parse(creaFichero());
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void escribeXML() {
		try {
			TransformerFactory factoria = TransformerFactory.newInstance();
			Transformer transformer = factoria.newTransformer(new StreamSource(new File(FICHERO_f)));
			DOMSource source = new DOMSource(doc);
			StreamResult resultado = new StreamResult(new File(FICHERO_SALIDA));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, resultado);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	private void escribePartida(HashMap<String, ArrayList<String>> paraGuardar) {

		Element partidas = doc.createElement("Partidas");
		doc.appendChild(partidas);

		int numeroPartidas = 1;
		int numeroJugada = 1;
		for (Map.Entry<String, ArrayList<String>> entry : paraGuardar.entrySet()) {
			Element partida = doc.createElement("Partida");
			partida.setAttribute("numero", String.valueOf(numeroPartidas));
			partidas.appendChild(partida);
			Element jugadores = doc.createElement("Jugadores");
			partida.appendChild(jugadores);
			jugadores.appendChild(doc.createTextNode(entry.getKey()));
			ArrayList<String> listado = entry.getValue();
			numeroJugada = 1;
			for (String movimiento : listado) {
				Element jugada = doc.createElement("movimiento");
				partida.appendChild(jugada);
				jugada.setAttribute("n", String.valueOf(numeroJugada));
				jugada.appendChild(doc.createTextNode(movimiento));
				numeroJugada++;
			}
			numeroPartidas++;
		}
		escribeXML();
	}

	public static void guardaPartida(HashMap<String, ArrayList<String>> paraGuardar) {
		System.out.println("Registrando todas las partidas consultadas en el documento XML");
		creaFichero();
		new GestorXML().escribePartida(paraGuardar);
	}

	// TODO Escribir y llamar para comprobar existencia del fichero
	public static File creaFichero() {
		File documento = new File(UtilesEscrituraArchivos.DIRECTORIO_SALIDA + "/Registra_Partidas.xml");
		try {
			documento.createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return documento;
	}

}