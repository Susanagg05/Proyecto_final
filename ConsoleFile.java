import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ConsoleFile{
	
	/*public static String[] read(String filename){

		FileWriter fw = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("C:\\archivos\\estudiantes.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Estudiante estudiante : lista) {
				//escribe los datos en el archivo
				bfwriter.write(estudiante.getCedula() + "," + estudiante.getNombres() + "," + estudiante.getApellidos()
						+ "," + estudiante.getTelefono() + "," + estudiante.getDireccion() + "\n");
			}
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}*/

	public static String[] arrayListToStrings(ArrayList<String> al)
	{
		String []out = new String[al.size()];
		int count = 0;
		for (String token : al) {
			out[count++] = token;
			//System.out.print(token);
		}//System.out.println(); 
		return out;
	}

	public static String[][] arrayListToMatrix(ArrayList<String> al)
	{
		String [][]out = new String[al.size()][ConsoleData.SET_LENGTH];
		StringTokenizer line;
		int filas = 0,columnas = 0;

		for (String token : al) {
			line = new StringTokenizer(token,";");
			columnas = 0;
			while (line.hasMoreTokens())
			{
				out[filas][columnas] = line.nextToken();
				columnas++;
			} 
			filas++;
			//System.out.print(token);
		}//System.out.println(); 
		return out;
	}

	public static String[] processLine(String line)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(line,";");

		while (st.hasMoreTokens()){
            tokens.add(st.nextToken()); 
		} 

		return arrayListToStrings(tokens);
	}

	//Este metodo solo lee hasta 806 linea, revisar por que
	public static String[] read(String file_name) {
		// crea el flujo para leer desde el archivo
		File file = new File(file_name);
		ArrayList<String> out = new ArrayList<String>(); 
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				out.add(scanner.nextLine());				
			}
			//se cierra el objeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Error no se encuentra el archivo "+file_name);
		}
		return arrayListToStrings(out);
	}

	//Este metodo funciona en java 8
	public static String[] readBigFile(String file_name){
		
		ArrayList<String> out = new ArrayList<String>(); 
		Stream<String> stream;
        //read file into stream, try-with-resources
        try{

        	stream = Files.lines(Paths.get(file_name));
            //stream.forEach(System.out::println);
			stream.forEach(linea->{
			 out.add(linea);
			});

        } catch (IOException e) {
            e.printStackTrace();
        }

		return arrayListToStrings(out);

	}

	public static String[] stringToArray(String str){
		StringTokenizer st = new StringTokenizer(str,";");
		String[] out = new String[st.countTokens()];
		int count = 0;
		while(st.hasMoreTokens()){
			out[count++] = st.nextToken();
			//System.out.print(token);
		}//System.out.println(); 
		return out;
	}

	public static String getPath(String ruta)
	{
		return new File(ruta).getPath();
	}

}
