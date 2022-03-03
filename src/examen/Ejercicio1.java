package examen;

import java.util.ArrayList;

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
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Jugador jugador1 = new Jugador ("Pepe", 1);
		jugadores.add(jugador1);
		Jugador jugador2 = new Jugador ("Juan", 2);
		jugadores.add(jugador2);
		Jugador jugador3 = new Jugador ("Luis", 3);
		jugadores.add(jugador3);
		Jugador jugador4 = new Jugador ("Rut", 4);
		jugadores.add(jugador4);
		Jugador jugador5 = new Jugador ("Nerea", 5);
		jugadores.add(jugador5);
		Jugador jugador6 = new Jugador ("Maria", 6);
		jugadores.add(jugador6);
		Jugador jugador7 = new Jugador ("Juana", 7);
		jugadores.add(jugador7);
		Jugador jugador8 = new Jugador ("Clara", 8);
		jugadores.add(jugador8);
		Jugador jugador9 = new Jugador ("Raul", 9);
		jugadores.add(jugador9);
		Jugador jugador10 = new Jugador ("Blas", 10);
		jugadores.add(jugador10);
		
		for (int i = 0; i < jugadores.size(); i++) {
			System.out.println(jugadores.get(i).toString());
		}
		
	}
	
}
