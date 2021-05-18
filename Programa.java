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
        System.out.println("2. Detener cancion");
        System.out.println("3. En caso de apoyo, presione 3 para ver un fragmento de la letra, en caso de adivinar la canción ingrese su nombre");
        System.out.println("3. Imprima las letras de las canciones");
        System.out.println("4. Salir del juego");
        centinela = ConsoleInput.getInt();
	do {
        
    	if (centinela ==1)
    	{ 
            randomcancion = rand.nextInt(18)+1;
			System.out.println("El numero aleatorio es:" + randomcancion);
            audio.seleccionarCancion(info_canciones[randomcancion][ConsoleData.RUTA_CANCION]);
            audio.reproducir();
            audio.fragmentoAleatorio();
            System.out.print("Ingrese el nombre de la cancion  ");
            nombrecancion = ConsoleInput.getString();
            System.out.println(info_canciones[1][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[2][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[3][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[4][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[5][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[6][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[7][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[8][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[9][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[10][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[11][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[12][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[13][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[14][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[15][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[16][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[17][ConsoleData.NOMBRE_CANCION]);
            System.out.println(info_canciones[18][ConsoleData.NOMBRE_CANCION]);
           
        if(nombrecancion.toLowerCase().equals(info_canciones[0][ConsoleData.NOMBRE_CANCION].toLowerCase())){
            System.out.println( "felicidades");
        }else{
            System.out.println( "fallaste");
        }
            
    	}
        if(centinela == 3)
                {
                    imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
                    indice_cancion = ConsoleInput.getInt();

                    inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
                    fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
                    
                    letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);


                    imprimir(letra_cancion.toString().replace(";"," ").substring(0, randomInt));
                }


        System.out.println("");
        System.out.println("");
        System.out.println("¡Hola! Bienvenido a GuessTheSong, estas son las opciones de juego:");
        System.out.println("1. Presione 1 para iniciar el juego, sonara una cancion aleatoria, intenta adivinar cual es y digita su nombre");
        System.out.println("2. Detener cancion");
        System.out.println("3. En caso de apoyo, presione 3 para ver un fragmento de la letra, en caso de adivinar la canción ingrese su nombre");
        System.out.println("3. Imprima las letras de las canciones");
        System.out.println("4. Salir del juego");
        centinela = ConsoleInput.getInt();		
    }while(centinela!=4);
}
}