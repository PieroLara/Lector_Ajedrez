package modelo.ajedrez.motor.tablero;

import java.awt.Color;
import java.util.List;

import javax.management.RuntimeErrorException;

public class UtilTablero {
	
	
	
	
	public static final boolean[] PRIMERA_COLUMNA = iniciaColumn(0);
	public static final boolean[] SEGUNDA_COLUMNA = iniciaColumn(1);
	public static final boolean[] SEPTIMA_COLUMNA = iniciaColumn(6);
	public static final boolean[] OCTAVA_COLUMNA = iniciaColumn(7);

	
	
	public static final boolean[] PRIMERA_FILA = iniciaFila(0);
	public static final boolean[] SEGUNDA_FILA = iniciaFila(8);
	public static final boolean[] TERCERA_FILA = iniciaFila(16);
	public static final boolean[] CUARTA_FILA = iniciaFila(24);
	public static final boolean[] QUINTA_FILA = iniciaFila(32);
	public static final boolean[] SEXTA_FILA = iniciaFila(40);
	public static final boolean[] SEPTIMA_FILA = iniciaFila(48);
	public static final boolean[] OCTAVA_FILA = iniciaFila(56);

	public static final int NUM_CASILLAS = 64;
	public static final int NUM_CASILLAS_POR_FILA = 8;
	public static final String SUBRAYADO = "\u0332";
	public static final String OSCURO = "\u001B[40m";
	public static final String CLARO= "\u001B[44m";
	public static final String RESET= "\u001B[0m";
	public static final Color PANEL_CLARO =  Color.decode("#FFFACD");
	public static final Color PANEL_OSCURO =  Color.decode("#593E1A");
	
	public static final int NUM_FICHAS_COLOR= 16;
	
	
	private static String[] NUMERO_FILA = { "8", "7", "6", "5", "4", "3", "2", "1" };

	private UtilTablero() {
		throw new RuntimeErrorException(null, "No se puede iniciacializar");
	}

	private static boolean[] iniciaColumn(int numeroColumna) {
		final boolean[] columna = new boolean[NUM_CASILLAS];
		do {
			columna[numeroColumna] = true;
			numeroColumna += NUM_CASILLAS_POR_FILA;
		} while (numeroColumna < NUM_CASILLAS);
		return columna;
	}

	private static boolean[] iniciaFila(int numeroFila) {
		final boolean[] fila = new boolean[NUM_CASILLAS];
		do {
			fila[numeroFila] = true;
			numeroFila++;
		} while (numeroFila % NUM_CASILLAS_POR_FILA != 0);
		return fila;
	}

	public static boolean isCoordenadaValida(final int coordenada) {
		return coordenada >= 0 && coordenada < 64;
	}

	public static String isCasillaOscura(final int coordenada) {
		return (((coordenada / 8) % 2 + coordenada) % 2 == 0) ? CLARO : OSCURO;
	}
	public static Color isPanelCasillaOscura(final int idCasilla) {
		return (((idCasilla / 8) % 2 + idCasilla) % 2 == 0) ? PANEL_CLARO : PANEL_OSCURO;
	}

	public static String valorReverso(final int coordenada) {
		return NUMERO_FILA[coordenada];
	}
	
	public static String  letraCasilla() {
		String letras=" ";
		for (int i = 65; i < 73; i++) {
			letras+= ("  " + (char) i);
		}
		letras+="\n";
		return letras;
	}
	
	
	 public static <T> List<T> volteaLista(List<T> lista)
	    {
	        if (lista.size() <= 1 || lista == null)
	            return null;
	        T value = lista.remove(0);
	        volteaLista(lista);
	        lista.add(value);
	        return lista;
	    }

	// formula de calcular letras por fila: (char) (97+i/8)
}
