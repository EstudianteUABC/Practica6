package clases;

import clases.Equipo;
import clases.Jugador;
import clases.Torneo; 
import clases.Entrada;

public class opciones {
	
	public static void agregarEquipo( Torneo torneo ) {
		System.out.println( "\n-- Ingrese los datos del equipo --" );
		String nombreEquipo = Entrada.cadena( "Nombre del equipo: ");
		String division = Entrada.cadena( "Division: " );
		String nombreEntrenador = Entrada.cadena( "Nombre entrenador: " );
		int noTorneos = Entrada.entero( "Numero de torneos con participacion: " );
		int ganados = Entrada.entero( "Numero de torneos ganados: " );
		int perdidos = Entrada.entero( "Numero de torneos perdidios: ");
		
		
		//se llama al constructor de Equipo para asignar los datos
		Equipo equipo = new Equipo( nombreEquipo, division, nombreEntrenador,
				  			   noTorneos, ganados, perdidos );
		
		//pide los datos para agregar un jugador
		int noJugador = 1;
		while( equipo.noJugadores() < 10 ) {
			System.out.println( "\n-- Ingrese los datos del jugador[" + noJugador + "] --" );
			String nombreJugador = Entrada.cadena( "Nombre del jugador: " );
			int noUniforme = Entrada.entero( "Numero de uniforme: " );
			int puntosAnotados = Entrada.entero( "Puntos anotados: " );
			String posicion = Entrada.cadena( "Posicion: " );
			double estatura = Entrada.doble( "Estatura: " );
			
			Jugador jugador = new Jugador( nombreJugador, noUniforme, puntosAnotados, 
										   posicion, estatura );

			//si el jugador no esta en otro equipo, no esta repetido
			//en el mismo equipo, y tiene un numero de uniforme valido, se agrega
			if( torneo.enOtroEquipo(jugador) == false && 
			    equipo.jugadorRepetido( jugador ) == false && 
			    equipo.numeroValido(jugador) == true ) {
			
				equipo.agregarJugador(jugador);
				noJugador++;
			}
			
			else {
				System.out.println("\n-------------------------------------------");
				System.out.println("Cuidado!!! \nEste jugador ya esta registrado!");
				System.out.println("-------------------------------------------\n");
			}
		}
		
		torneo.agregarEquipo(equipo); //se agrego un equipo correctamente
	}
	
	public static void mostrarEquipo( Torneo torneo ) {
		for( int i = 0; i < torneo.getNoEquipos(); i++ ) {
			System.out.println( "" + ( i + 1 ) + ": " + torneo.getEquipo(i).getNombre() );
		}
		
		int opcion = Entrada.entero( "Seleccione un equipo: " ) - 1;
		
		
		//valida los datos de entrada
		while( opcion > torneo.getNoEquipos() || opcion < 0 ) {
			System.out.println( "Opcion no valida!" );
			opcion = Entrada.entero( "Seleccione un equipo: " ) - 1;
		}
		
		System.out.println("Nombre del equipo: " + torneo.getEquipo(opcion).getNombre() );
		System.out.println("Division: " + torneo.getEquipo(opcion).getDivision() );
		
		
		for( int i = 0; i < torneo.getEquipo( opcion ).noJugadores(); i++ ) {
			System.out.println( "\n-----------------------\n" );
			torneo.getEquipo(opcion).getJugador(i).mostrarDatos();
		}
		
		System.out.println("\nTotal de jugadores: " + torneo.getEquipo(opcion).noJugadores() );
		System.out.println("Total de puntos por equipo: " + torneo.getEquipo(opcion).puntosDeEquipo() );
	}
	
	//muestra los datos del torneo
	public static void datosDelTorneo( Torneo torneo ) {
		torneo.mostraDatos();
	}
}
