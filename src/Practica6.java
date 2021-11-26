import clases.opciones;
import clases.Entrada;
import clases.Torneo;

public class Practica6 {
	public static void main(String[] args) {
		boolean flag = true; //controlar la continuacion del ciclo
		Torneo torneo = new Torneo( "Torneo nacional", "Sonora", 5, 10, 7  ); //torneo actual

		do {
			System.out.println("\n1) Agregar Equipo." );
			System.out.println(  "2) Mostrar datos de equipo." );
			System.out.println(  "3) Mostrar datos del torneo." );
			System.out.println(  "4) Salir" );
			System.out.print( "Seleccione una opcion y presione ENTER: " );
			
			int seleccion = Entrada.entero( "" ); 
			
			switch( seleccion ) {
				case 1:
					opciones.agregarEquipo( torneo );
					break;
				
				case 2:
					opciones.mostrarEquipo( torneo );
					break;
					
				case 3: 
					opciones.datosDelTorneo(torneo);
					break;
					
				case 4:
					flag = false;
					break;
				
				default:
					System.out.println( "Opcion invalida." );
					break;
			}	
		}while( flag ); //mientras flag sea igual a true
	}

}
