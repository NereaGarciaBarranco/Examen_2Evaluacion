package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//C:\Users\Nerea\Desktop\textoExamen.txt

public class Ejercicio2 {
	/**
	 * Pre: ---
	 * Post: Este metodo main recibe por parte del usuario una ruta 
	 * de un fichero y la longitud de palabras que desea buscar 
	 * y llama al metodo necesario para que lo calcule. Imprime el
	 * resultado por pantalla. 
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba la ruta y el nombre de un fichero:");
		String ruta = entrada.next();
		System.out.println("Escribe la longitud que seas buscar:");
		int longitud = entrada.nextInt();
		int resultado = 0;
		resultado = palabrasMasLargasQue(longitud, ruta);	
		System.out.println(resultado);
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo recibe una ruta de un fichero y lo recorre para devolver
	 * el número de palabras que son de la misma longitud o mayor que la cifra que
	 * se le pasa por parámetro.
	 */
	public static int palabrasMasLargasQue (int longitud, String ruta) {
		File fichero = new File (ruta);
		try {
			// Asociamos el Scanner al fichero para poder leerlo
			Scanner f = new Scanner(fichero);
			int contador = 0;
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				// Limpiamos toda la linea de caracteres especiales
				linea = linea.replaceAll(",","").replaceAll("\\.", "").replaceAll(";", "")
						.replaceAll("\"", "").replaceAll("\\(", "").replaceAll("\\)", "");
				// Separamos la linea por los espacios
				String[] palabras = linea.split(" ");
				for (int i = 0; i < palabras.length; i++) {
					if (palabras[i].length() >= longitud) {
						contador++;
					}
				}
			}
			f.close();	
			return(contador);
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido acceder al fichero.");
			e.printStackTrace();
		}		
		return -1;
		
	}
}
