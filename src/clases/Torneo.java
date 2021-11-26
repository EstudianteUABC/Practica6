package clases;

import clases.Equipo;
import clases.Jugador;
import java.util.LinkedList;

public class Torneo {
	private String nombre;
	private String region;
	private int noEquipos;
	private int noPartidos;
	private int noPartPendientes;
	private LinkedList<Equipo> equipos = new LinkedList<Equipo>();
	
	
	public Torneo( String nombre, String region, int noEquipos, 
				   int noPartidos, int noPartPendientes ){
		this.nombre = nombre;
		this.region = region;
		this.noEquipos = noEquipos;
		this.noPartidos = noPartidos;
		this.noPartPendientes = noPartPendientes;
	}
	
	public void agregarEquipo( Equipo equipo ) {
		equipos.add(equipo);
	}
	
	public boolean enOtroEquipo( Jugador jugador ){
		for( int i = 0; i < equipos.size(); i++ ) {
			for( int j = 0; j < equipos.get(i).noJugadores(); j++ ) {
				if( jugador.getID().equals( equipos.get(i).getJugador(j).getID() ) )
					return true; //si el jugador ya esta en otro equipo no se puede agregar
			}
		}
		return false; //si ya se recorrieron todos los equipos 
					  //y no es un jugador repetido, se puede agregar
	}
	
	public int getNoEquipos() {
		return equipos.size();
	}
	
	public Equipo getEquipo( int index ) {
		return equipos.get( index );
	}
	
	public void mostraDatos() {
		System.out.println( "\n--- Datos del torneo --- " );
		System.out.println( "Nombre: " + nombre );
		System.out.println( "Region: " + region );
		System.out.println( "Numero de equipos: " + noEquipos );
		System.out.println( "Numero de partidos: " + noPartidos );
		System.out.println( "Numero de partidos pendientes: " + noPartPendientes );
	}
}
