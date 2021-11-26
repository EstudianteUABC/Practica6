package clases;

public class Jugador {
	private String nombre;
	private int noUniforme;
	private int noPuntos;
	private String posicion;
	private double estatura;
	private String ID;
	
	
	
	public Jugador(String nombre, int noUniforme, int noPuntos, String posicion, double estatura ) {
		this.nombre = nombre;
		this.noUniforme = noUniforme;
		this.noPuntos = noPuntos;
		this.posicion = posicion;
		this.estatura = estatura;
		ID = nombre + noUniforme + estatura; //datos para identificar a un jugador
	}

	public int getPuntos() {
		return noPuntos;
	}
	
	public int getNumero() {
		return noUniforme;
	}
	
	public String getID() {
		return ID;
	}
	
	public void mostrarDatos() {
		System.out.println( "Nombre: " + nombre );
		System.out.println( "Numero de uniforme: " + noUniforme );
		System.out.println( "Numero de puntos: " + noPuntos );
		System.out.println( "Posicion: " + posicion );
		System.out.println( "Estatura: " + estatura );
	}
}


