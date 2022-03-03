package examen;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio1 {
	/**
	 * Pre: ---
	 * Post: En este metodo main se juegan los 10 jugadores necesarios
	 * para jugar al Rapido y se llama al metodo necesario para que se 
	 * realice.
	 */
	public static void main(String[] args) {
		// Creamos los 10 jugadores de nuestro juego
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Jugador jugador1 = new Jugador("Pepe", 1);
		jugadores.add(jugador1);
		Jugador jugador2 = new Jugador("Juan", 2);
		jugadores.add(jugador2);
		Jugador jugador3 = new Jugador("Luis", 3);
		jugadores.add(jugador3);
		Jugador jugador4 = new Jugador("Rut", 4);
		jugadores.add(jugador4);
		Jugador jugador5 = new Jugador("Nerea", 5);
		jugadores.add(jugador5);
		Jugador jugador6 = new Jugador("Maria", 6);
		jugadores.add(jugador6);
		Jugador jugador7 = new Jugador("Juana", 7);
		jugadores.add(jugador7);
		Jugador jugador8 = new Jugador("Clara", 8);
		jugadores.add(jugador8);
		Jugador jugador9 = new Jugador("Raul", 9);
		jugadores.add(jugador9);
		Jugador jugador10 = new Jugador("Blas", 10);
		jugadores.add(jugador10);
		jugarRapido(jugadores);
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo recibe una tabla de jugadores y los emplea para 
	 * jugar al juego de futbol "el Rapido".
	 */
	public static void jugarRapido(ArrayList<Jugador> jugadores) {
		// Los desordenamos para que jueguen en un orden aleatorio
		Collections.shuffle(jugadores);
		System.out.println("Juegan en el siguiente orden:");
		// Estos bucles muestran por pantalla el orden
		for (int i = 0; i < jugadores.size(); i++) {
			System.out.println(jugadores.get(i).toString());
		}
		// Mientras siga quedando mas de un jugador vivo el juego sigue
		while (jugadores.size() > 1) {
			// El primer jugador se pone de portero y el segundo tira y van cambiando
			for (int i = 0; i < jugadores.size(); i++) {
				Jugador portero = jugadores.get(i);
				Jugador tirador = new Jugador();
				/*
				 * Si el portero es el ultimo de la lista hacemos que tire el primero para que
				 * no se salga de la lista
				 */
				if (i == jugadores.size() - 1) {
					tirador = jugadores.get(0);
				}
				// Si no es el ultimo ponemos a tirar al siguiente en la lista
				else {
					tirador = jugadores.get(i + 1);
				}
				// Calculamos las probabilidades de disparo y parada
				int disparo = habilidadDisparo() * tirador.getPotenciaDisparo();
				int parada = habilidadPorteria() * portero.getCalidadPorteria();
				// Si el disparo tiene mas probabilades que la parada
				if (disparo >= parada) {
					System.out.println("¡El jugador " + tirador.getNombre() + " ha marcado gol!");
					// Quitamos una vida al portero
					jugadores.get(i).setVidas(jugadores.get(i).getVidas() - 1);
				} else {
					// Si se produce una parada lo mostramos por consola
					System.out.println("El jugador " + portero.getNombre() + " ha realizado una parada "
							+ "contra el tiro de " + tirador.getNombre() + "!");
				}
				// Si alguno de los jugadores se ha quedado sin vida se quita del vector
				if (jugadores.get(i).getVidas() < 1) {
					jugadores.remove(i);
				}
				// Este bucle muestra como evoluciona el juego iteracion a iteracion
				for (int j = 0; j < jugadores.size(); j++) {
					System.out.println(jugadores.get(j).toString());
				}
			}

		}
		// Al final se muestra quien ha ganado
		System.out.println("Ha ganado el jugador "+ jugadores.get(0).getNombre());
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo genera un numero aleatorio que sirve para calcular
	 * las probabilidades de que el jugador marque un gol.
	 */
	public static int habilidadDisparo() {
		int habilidad = (int) Math.round(Math.random() * 50);
		return habilidad;
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo genera un numero aleatorio que sirve para calcular
	 * las probabilidades de que el portero pare un disparo.
	 */
	public static int habilidadPorteria() {
		int habilidad = (int) Math.round(Math.random() * 10);
		return habilidad;
	}
}
