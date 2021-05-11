import java.util.*;

public class RandomHelper{
	
	public static int random(int inicio,int fin)
	{
		Random r = new Random();
		return r.nextInt(fin-inicio+1) + inicio;
	}

}