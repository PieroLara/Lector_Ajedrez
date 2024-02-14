package vista.terminal.GUI;

import java.util.Scanner;

public class PreguntasUsuario {

	Scanner teclado = new Scanner(System.in);
	
	
	//Expresion Regular
	
	/*
	 * String consola= RL();
	 * Regex.Match(consola, '');
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	

	public String preguntaCadena(String pregunta) {
		String cadena = "";
		boolean correcto = false;
		do {
			System.out.println("Por favor introduzca " + pregunta);
			try {
				correcto = false;
				cadena = teclado.nextLine();
			} catch (Exception e) {
				System.err.println("No ha introducido un valor aceptable :c");
				correcto = true;
			}
		} while ((correcto));
		return cadena;
	}

	public int preguntaAvanzarRetroceder(int posicionArray, int tamanyoArray) {
		StringBuilder pregunta = new StringBuilder();
		char respuesta = 'c';
		boolean correcto = false;
		do {
			pregunta.append("Movimiento: " + (1 + posicionArray));
			if (posicionArray > 0) {
				pregunta.append("\n\tA. Atrás");
			}
			if (posicionArray < tamanyoArray) {
				pregunta.append("\n\tD. Adelante");
			}
			pregunta.append("\n\tT. Terminar\nPor favor introduzca una opción");
			System.out.println(pregunta.toString());

			try {
				correcto = false;
				respuesta = teclado.nextLine().toUpperCase().charAt(0);
				switch (respuesta) {
				case 'A':
					if (posicionArray > 0) {
						posicionArray--;
					} else {
						System.err.println("No ha introducido un valor aceptable :c");
						correcto = true;
					}
					break;
				case 'D':
					if (posicionArray < tamanyoArray) {
						posicionArray++;
					} else {
						System.err.println("No ha introducido un valor aceptable :c");
						correcto = true;
					}
					break;
				case 'T':
					posicionArray = -1;
					System.out.println("\n\t\tVolviendo al menú principal\n");
					break;
				default:
					System.err.println("No ha introducido un valor aceptable :c");
					correcto = true;
					break;
				}
			} catch (Exception e) {
				System.err.println("No ha introducido un valor aceptable :c");
				correcto = true;
			}
		} while ((correcto));
		return posicionArray;
	}

	public int preguntaNumeros(int minimo, int maximo) {
		int numero = -1;
		boolean correcto = false;
		do {
			System.out.println("Por favor introduzca un valor numérico");
			try {
				correcto = false;
				numero = teclado.nextInt();
				// Esta función se puede hacer como una excepción interna catch.
				if (numero < 0) {
					correcto = true;
					System.err.println(" Valores negativos no aceptables");
				}
			} catch (Exception e) {
				System.err.println("No ha introducido un valor aceptable :c");
				correcto = true;
				teclado.nextLine();
			}
		} while ((correcto) || ((numero < minimo) || (numero > maximo)));
		teclado.nextLine();
		return numero;
	}

	public int preguntaNumerosConPregunta(String pregunta, int minimo, int maximo) {
		int numero = -1;
		boolean correcto = false;
		System.out.println(pregunta);
		do {
			try {
				correcto = false;
				numero = teclado.nextInt();
				// Esta función se puede hacer como una excepción interna catch.
				if (numero < 0) {
					correcto = true;
					System.err.println(" Valores negativos no aceptables");
				}
			} catch (Exception e) {
				System.err.println("No ha introducido un valor aceptable :c");
				correcto = true;
				teclado.nextLine();
			}
		} while ((correcto) || ((numero < minimo) || (numero > maximo)));
		teclado.nextLine();
		return numero;
	}

	public double preguntaNumerosDouble(double minimo, double maximo) {
		double numero = -1;
		boolean correcto = false;
		do {
			System.out.println("Por favor introduzca un valor numérico");
			try {
				correcto = false;
				numero = teclado.nextDouble();
				// Esta función se puede hacer como una excepción interna catch.
				if (numero < 0) {
					correcto = true;
					System.err.println(" Valores negativos no aceptables");
				}
			} catch (Exception e) {
				System.err.println("No ha introducido un valor aceptable :c");
				correcto = true;
				teclado.nextLine();
			}
		} while ((correcto) || ((numero < minimo) || (numero > maximo)));
		teclado.nextLine();
		return numero;
	}

	public double preguntaNumerosDoubleconPregunta(String pregunta, double minimo, double maximo) {
		double numero = -1;
		boolean correcto = false;
		System.out.println(pregunta);
		do {
			System.out.println("Por favor introduzca un valor numérico");
			try {
				correcto = false;
				numero = teclado.nextDouble();
				// Esta función se puede hacer como una excepción interna catch.
				if (numero < 0) {
					correcto = true;
					System.err.println(" Valores negativos no aceptables");
				}
			} catch (Exception e) {
				System.err.println("No ha introducido un valor aceptable :c");
				correcto = true;
				teclado.nextLine();
			}
		} while ((correcto) || ((numero < minimo) || (numero > maximo)));
		teclado.nextLine();
		return numero;
	}

}
