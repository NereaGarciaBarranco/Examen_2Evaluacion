package examen;

public class Jugador {
	private String nombre;
	private int dorsal;
	private int potenciaDisparo;
	private int calidadPorteria;
	private int vidas;
	
	public Jugador (String nombre, int dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		potenciaDisparo = (int) Math.round(Math.random() * 50);
		calidadPorteria = (int) Math.round(Math.random() * 50);
		vidas = 2;
	}
	
	// Metodo constructor vacio para usarlo como auxiliar
	public Jugador () {
		nombre = "";
		dorsal = 99999;
		potenciaDisparo = 0;
		calidadPorteria = 0;
		vidas = 2;
	}
	
	// Metodos get y set de la clase Jugador
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getDorsal() {
		return dorsal;
	}
	
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	public int getPotenciaDisparo() {
		return potenciaDisparo;
	}
	
	public void setPotenciaDisparo(int potenciaDisparo) {
		this.potenciaDisparo = potenciaDisparo;
	}
	
	public int getCalidadPorteria() {
		return calidadPorteria;
	}
	
	public void setCalidadPorteria(int calidadPorteria) {
		this.calidadPorteria = calidadPorteria;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	@Override
	public String toString() {
		return nombre + " " + dorsal + " " + potenciaDisparo + " " + calidadPorteria + " " + vidas;
	}
	
}
