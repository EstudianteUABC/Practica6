package clases;

import clases.Jugador;
import java.util.LinkedList;

public class Equipo {
	private String nombreEquipo;
	private String division;
	private String nombreEntrenador;
	private int noParticipaciones;
	private int noGanados;
	private int noPerdidos;
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
	
	public Equipo( String nombreEquipo, String division, String nombreEntrenador,
			       int noParticipaciones, int noGanados, int noPerdidos) {
		this.nombreEquipo = nombreEquipo;
		this.division = division;
		this.nombreEntrenador = nombreEntrenador;
		this.noParticipaciones = noParticipaciones;
		this.noGanados = noGanados;
		this.noPerdidos = noPerdidos;	
	}
	
	public int noJugadores() {
		return jugadores.size();
	}
	
	public int puntosDeEquipo() {
		int total = 0;
		
		for( int i = 0; i < jugadores.size(); i++ ) {
			total += jugadores.get(i).getPuntos();
		}
		
		return total;
	}
	
	public void agregarJugador( Jugador jugador ) {
		jugadores.add(jugador);
	}
	
	public boolean numeroValido( Jugador jugador ) {
		for( int i = 0; i < jugadores.size(); i++ ) {
			if( jugadores.get(i).getNumero() == jugador.getNumero() )
				return false; //si hay otro jugador con el mismo numero
		}
		return true; //si el numero esta disponible
	}
	
	public Jugador getJugador( int index ) {
		return jugadores.get( index );
	}
	
	public String getNombre() {
		return nombreEquipo;
	}
	
	public String getDivision() {
		return division;
	}
	
	public boolean jugadorRepetido( Jugador jugador ) {
		for( int i = 0; i < jugadores.size(); i++ ) {
			if( jugador.getID().equals( jugadores.get(i).getID() ) )
				return true; //si el jugador ya se encuentra en el equipo, no se agrega
		}
		return false; //si no esta en el equipo, se agrega
	}
}
