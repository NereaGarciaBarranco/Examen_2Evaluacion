package examen;

import java.util.ArrayList;
import java.util.Collections;

// Usar arraylist aunque luego metamos solo 10
// Habilidad disparo y habilidad portero no hay que currarselo, por ej multiplicar por un numero random

//“El rápido” es un clásico juego de fútbol en el que participan un total de N
//jugadores (para este ejercicio van a ser 10). Su reglas son las siguientes: se organizan los
//turnos de disparo de cada uno de los jugadores (de forma aleatorio). Uno de ellos se sitúa
//en la portería y el siguiente dispara intentando meter gol. Si el jugador que ha disparado
//consigue meter gol, se le resta 1 vida al portero. Sea cual sea el resultado del disparo, el
//jugador que ha chutado a portería pasa a ser el portero en el siguiente turno. El juego
//acaba cuando sólo queda un jugador vivo.
//Desarrolla la clase Jugador, formada por un nombre, dorsal, potencia de disparo, calidad
//en la portería, y vidas (se inicializa siempre con valor 2). Además, implementa los
//métodos habilidadDisparo() y habilidadPorteria(). Programa los métodos como creas
//conveniente, usando los atributos potencia de disparo y calidad en la portería (ambos
//deben devolver un número entero). Ten en cuenta que, para saber si el jugador que ha
//disparado ha metido gol, deberás usar los métodos habilidadDisparo() del lanzador y el
//método habilidadPorteria() del portero.
//Una vez hayas completado el paso anterior, programa la clase Main que permita jugar al
//juego.

public class Ejercicio1 {
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

		
		// Los desordenamos para que jueguen en un orden aleatorio
		Collections.shuffle(jugadores);
		for (int i = 0; i < jugadores.size(); i++) {
			System.out.println(jugadores.get(i).toString());
		}
		// Mientras siga quedando mas de un jugador el juego sigue
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

				int disparo = habilidadDisparo();
				int parada = habilidadPorteria();
				portero.setCalidadPorteria(parada);
				tirador.setPotenciaDisparo(disparo);
				if (tirador.getPotenciaDisparo() >= portero.getCalidadPorteria()) {
					System.out.println("¡El jugador " + tirador.getNombre() + " ha marcado gol!");
					jugadores.get(i).setVidas(jugadores.get(i).getVidas()-1);
				} else {
					System.out.println("El jugador " + portero.getNombre() + " ha realizado una parada "
							+ "contra el tiro de " + tirador.getNombre() + "!");
				}
				if (jugadores.get(i).getVidas() < 1) {
					jugadores.remove(i);
				}
			}

		}
		System.out.println("Ha ganado el jugador "+ jugadores.get(0).getNombre());
	}
	
	public static int habilidadDisparo() {
		int habilidad = (int) Math.round(Math.random() * 100);
		return habilidad;
	}
	
	public static int habilidadPorteria() {
		int habilidad = (int) Math.round(Math.random() * 10);
		return habilidad;
	}
}
