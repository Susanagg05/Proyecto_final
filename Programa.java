import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import java.util.Random;


public class Programa{

    public static String convertirUnicode(String letra,String cadena){
        
        StringBuilder str = new StringBuilder(cadena);
        int indice = -1;
        char caracter = 0;
        indice = str.lastIndexOf(letra);
        
        if(indice>=0 )
        {
            switch(letra){
                case "á": caracter = '\u00E1';
                          break;
                case "é": caracter = '\u00E9';
                          break;
                case "í": caracter = '\u00ED';
                          break;
                case "ó": caracter = '\u00F3';
                          break;
                case "ú": caracter = '\u00FA';
                          break;
                case "ñ": caracter = '\u00F1';
                          break;
            }
            // System.out.println("\\u" + Integer.toHexString('÷' | 0x10000).substring(1));
            str.replace(indice,indice+2,""+caracter);
        }

        return str.toString();
    }

    public static void imprimir(String cadena)
    {
        String str; 
        str = convertirUnicode("á",cadena);
        str = convertirUnicode("é",str);
        str = convertirUnicode("í",str);
        str = convertirUnicode("ó",str);
        str = convertirUnicode("ú",str);
        str = convertirUnicode("ñ",str);

        System.out.println(str);
    }

    public static StringBuilder obtenerLetraCancion(int inicio,int fin, String[]data)
    {
        StringBuilder str = new StringBuilder();

        for(int i = inicio; i<=fin; i++)
        {
            str.append(data[i]+"\n");
        }

        return str;
    }

	public static void main(String[] args) {
		
        System.out.println("                                                                                ");
        System.out.println("             .-.     .-.     .-.     .-.     .-.     .-.     .-.                ");                                
        System.out.println("        `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'           ");
        System.out.println("          ___ _  _ ____ ____ ____ ____ _  _ ____ ____  __  __ _  ___            ");
		System.out.println("         / __) )( (  __) ___) ___|_  _) )( (  __) ___)/  \\(  ( \\/ __)         ");
		System.out.println("        ( (_ ) \\/ () _)\\___ \\___ \\ )( ) __ () _)\\___ (  O )    ( (_ \\     ");
		System.out.println("         \\___|____(____|____(____/(__)\\_)(_(____|____/\\__/\\_)__)\\___/      ");

        System.out.println("  ,           ;            ======o     o======      ,              ;            ");
        System.out.println("  ;;          ;;               ___________          ;;             ;;           ");
        System.out.println("  ;;          ;';.            |___________|         ;;             ;';.         ");
        System.out.println("  ;;          ;  ;;            | \\ /\\ /\\ |          ;;             ;  ;;     ");
        System.out.println("  ;;          ;   ;;           | _\\/__\\/_|          ;;             ;   ;;     ");
        System.out.println("  ;; .;;;,    ;    ;;         |___________|         ;; .;;;,       ;    ;;      ");
        System.out.println("  ;;.'  ;;    ;    ;;                               ;;.'  ;;       ;    ;;      ");
        System.out.println("  ;;' .;'     ;   ;'                                ;;' .;'        ;   ;'       ");
        System.out.println("  ;;.;'       ;  '                                  ;;.;'          ;  '         ");
        System.out.println("  ;;'    ,;;;,;                                     ;;'       ,;;;,;            ");
        System.out.println("         ;;;;;;                                     ,'        ;;;;;;            ");
        System.out.println("         `;;;;'                                               `;;;;'            ");
        System.out.println("                                                                                ");
        System.out.println("             .-.     .-.     .-.     .-.     .-.     .-.     .-.                ");                                
        System.out.println("        `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'           ");
		
        
        
        AnsiConsole.systemInstall();
    	Audio audio = new Audio();
        Random randomGenerator = new Random ();
    	int centinela = 0;
        int indice_cancion = 0;
        int inicio_letra = 0, fin_letra = 0;
		Random rand = new Random();
		int randomcancion;
        int randomInt= randomGenerator.nextInt (300) + 1;
    	String [] canciones = ConsoleFile.readBigFile ("recursos/letras.csv");
    	String [][] info_canciones = ConsoleData.dataList(canciones);
        StringBuilder letra_cancion;
        String nombrecancion;
        //for (int f=0;f<info_canciones.length;f++) {
        //    for (int i=0;i<8;i++) {
        //        System.out.print(info_canciones[f][i]+" ");
        //   }
        //    System.out.println(" ");
        //}
        
        //System.out.println(info_canciones.length);
        System.out.println("");
        System.out.println("                                                                  ");
        System.out.println("¡Hola! Bienvenido a GuessTheSong, estas son las opciones de juego:");
        System.out.println("1. Presione 1 para iniciar el juego, sonara una cancion aleatoria, intenta adivinar cual es y digita su nombre");
        System.out.println("En caso de que no reconozcas la cancion, escribe 'no se' el programa te dara una pista y podras intentar de nuevo" );
        System.out.println("2. Presione el numero 4 para detener la cancion");
        System.out.println("4. Presione enter para salir del juego");
        System.out.println("                  ");
        System.out.println("                  ");
        System.out.println("                  ");
        centinela = ConsoleInput.getInt();
	do {
        
    	if (centinela ==1)
    	{ 
            randomcancion = rand.nextInt(18)+1;
			
            audio.seleccionarCancion(info_canciones[randomcancion][ConsoleData.RUTA_CANCION]);
            //audio.reproducir();
            audio.fragmentoAleatorio();
            //System.out.println("Esta sonando " + info_canciones[randomcancion][ConsoleData.NOMBRE_CANCION]);
            System.out.print("Ingrese el nombre de la cancion  ");
            nombrecancion = ConsoleInput.getString();
            
        if (nombrecancion.equals(info_canciones[randomcancion][ConsoleData.NOMBRE_CANCION])){
            System.out.println( "felicidades, ¡Adivinaste! ");
        }else if (nombrecancion.equals("no se")){
           mostrarLetra(randomcancion,info_canciones);
           System.out.println("\n\n¿Ya sabes cual es la cancion? Escribe el nombre de la canción");
           nombrecancion = ConsoleInput.getString();
           if((info_canciones[randomcancion][ConsoleData.NOMBRE_CANCION]).equals(nombrecancion)){
            System.out.println( "felicidades, ¡Adivinaste! ");
        }else{
            System.out.println( "intenta de nuevo");
        }
        }else{
        	 System.out.println( "intenta de nuevo");
        }
        
            
    	}
        


        System.out.println("");
        System.out.println("");
        System.out.println("¡Hola! Bienvenido a GuessTheSong, estas son las opciones de juego:");
        System.out.println("1. Presione 1 para iniciar el juego, sonara una cancion aleatoria, intenta adivinar cual es y digita su nombre");
        System.out.println("En caso de que no reconozcas la cancion, escribe 'no se' el programa te dara una pista y podras intentar de nuevo" );
        System.out.println("2. Presione el numero 4 para detener la cancion");
        System.out.println("4. Presione enter para salir del juego");
        System.out.println("                  ");
        System.out.println("                  ");
        System.out.println("                  ");
        
        centinela = ConsoleInput.getInt();	
        audio.detener();	
    }while(centinela!=4);
}
public static void mostrarLetra(int randomcancion,String [][] info_canciones){
    int inicio_letra= 0, fin_letra = 0;
    StringBuilder letra_cancion;
    Random randomGenerator = new Random ();
    int randomInt= randomGenerator.nextInt (300) + 1;
    String [] canciones = ConsoleFile.readBigFile ("recursos/letras.csv");
    inicio_letra = ConsoleInput.stringToInt(info_canciones[randomcancion][ConsoleData.INICIO_CANCION]);
    fin_letra = ConsoleInput.stringToInt(info_canciones[randomcancion][ConsoleData.FIN_CANCION]);
    
    letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);


    imprimir(letra_cancion.toString().replace(";"," ").substring(0, randomInt));
}
}