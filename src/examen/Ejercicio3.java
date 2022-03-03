package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		informacionVideojuegos();
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo recorre un fichero y recoge en un ArrayList los nombres
	 * diferentes de plataformas que hay en él. 
	 */
	public static ArrayList<String> informacionVideojuegos() {	
		String ruta = "C:\\Users\\Nerea\\Desktop\\ventasVideojuegos.csv";
		File fichero = new File (ruta);
		ArrayList<String> plataformas = new ArrayList<String>();
		try {
			Scanner f = new Scanner(fichero);
			int contador = 0;
			while(f.hasNextLine()) {
				String uso = f.nextLine();
				// Así evitamos la cabecera del archivo
				if (contador != 0) {
					String[] datos = uso.split(",");
					String nombre = datos[2];
					// La primera vez siempre se añade porque es imposible que este
					if (plataformas.size() == 0) {
						plataformas.add(nombre);
					} else { 
						// El restp de veces comprobamos si esta y si no, lo añadimos
						if(comprobarPlataforma(nombre, plataformas) == false) {
							plataformas.add(nombre);
						}
					}
				}
				contador++;
			}
			f.close();
			for (int i = 0; i < plataformas.size(); i++) {
				System.out.println(plataformas.get(i));
			}
			return plataformas;

		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido acceder al fichero.");
			e.printStackTrace();
		}	
		return plataformas;
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo comprueba si un nombre de una plataforma se encuentra ya 
	 * dentro del ArrayList que se le pasa como parametro o no. 
	 */
	
	public static boolean comprobarPlataforma(String nombre, ArrayList<String> plataformas) {
		boolean aparece = false;
		for (int i = 0; i < plataformas.size(); i++) {
			if(plataformas.get(i).equals(nombre)) {
				aparece = true;
				return aparece;
			}
		}
		return aparece;
	}
}
