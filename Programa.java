import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import java.util.Random;

public class Programa{
	public static void main(String[] args) {
		System.out.println("  ___ _  _ ____ ____ ____ ____ _  _ ____ ____  __  __ _  ___   ");
		System.out.println(" / __) )( (  __) ___) ___|_  _) )( (  __) ___)/  \\(  ( \\/ __) ");
		System.out.println("( (_ ) \\/ () _)\\___ \\___ \\ )( ) __ () _)\\___ (  O )    ( (_ \\ ");
		System.out.println(" \\___|____(____|____(____/(__)\\_)(_(____|____/\\__/\\_)__)\\___/ " );

		AnsiConsole.systemInstall();
    	Audio audio = new Audio();
    	int centinela = 0;
		Random rand = new Random();
		int randomcancion;
    	String [] canciones = ConsoleFile.read ("recursos/letras.csv");
    	String [][] info_canciones = ConsoleData.dataList(canciones);
	
	
		System.out.println("¡Hola! Bienvenido a GuessTheSong, estas son las opciones de juego:");
    	System.out.println("1. Presione 1 para iniciar el juego, sonara una cancion aleaotrea, intenta adivinar cual es y digita su nombre");
    	System.out.println("2. En caso de apoyo, presione 2 para ver un fragmento de la letra, en caso de adivinar la canción ingrese su nombre");
    	System.out.println("3. Imprima las letras de las canciones");
    	System.out.println("4. Salir del juego");
    	centinela = ConsoleInput.getInt();

    	if (centinela ==1)
    	{ randomcancion = rand.nextInt(14)+1;
			System.out.println("El numero aleatoreo es:" + randomcancion);
    		audio.seleccionarCancion(info_canciones[randomcancion][ConsoleData.RUTA_CANCION]);
    		audio.reproducir();
			
    	}

		
	}
}