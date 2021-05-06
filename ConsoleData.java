import java.util.ArrayList;
import java.util.*;

public class ConsoleData{
	
	public static final int INICIO_CANCION = 0; 
	public static final int FIN_CANCION = 1; 
	public static final int NOMBRE_CANCION = 2; 
	public static final int AUTOR_CANCION = 3; 
	public static final int RUTA_CANCION = 7; 
	public static final int SET_LENGTH = 8;

	public static void processDescription(){

	}

	public static boolean isTitle(String line)
	{
		StringTokenizer st = new StringTokenizer(line,";");
		//String[] out = new String[st.countTokens()];
		//int count = 0;
		String temp;

		while(st.hasMoreTokens()){
			temp = st.nextToken();
			if(temp.length()>5){
				if(temp.substring(0,5).equals("https"))
				{
					return true;
				}
			}
			//System.out.print(token);
		}//System.out.println(); 
		return false;
	}

	public static String[][] dataList(String []data){
		
		ArrayList<String> out = new ArrayList<String>(); 
		int inicio_letra = -1, fin_letra = -1, actual_cancion = -1;
		boolean bandera = true;
		String info_actual = null;

		for(int i=0;i<data.length;i++)
		{
			if(isTitle(data[i]))
			{
				fin_letra = i-2;

				if(fin_letra>0)
				{
					// System.out.println(inicio_letra+" "+fin_letra);
					out.add(inicio_letra+";"+fin_letra+";"+info_actual);
				}

				inicio_letra = i+1;
				info_actual = data[i];
				
			}

		}

		fin_letra = data.length-2;
		out.add(inicio_letra+";"+fin_letra+";"+info_actual);

		return ConsoleFile.arrayListToMatrix(out);
	}

	public static String[] getChunkData(String []data){
		return null;
	}
}