package Pack;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P4 {
	
	public static void TableMultiplicatin(int a)
	{
		for (int i=1; i<=10; i++)
		{
			System.out.println(i+ " * "+a+" = "+a*i);
		}
	}
	public static void Diviseur(int a)
	{
		for (int i=1; i<=a/2; i++)
		{
			if(a%i==0)System.out.println(i+ " est un diviseur");
		}
	}
	public static int Fact(int a)
	{	int f=1;
		for (int i=1; i<=a; i++)
		{
			f=f*i;
		}
		return f;
	}

	public static void main(String[] args) {
		try {
			ServerSocket s4 = new ServerSocket(2004);
			System.out.println("P4 serveur en attente ...");
			// accepter la demande qui vient du client p3
			Socket con4 = s4.accept();
			System.out.println("P3 est accepte");
			
			ObjectInputStream inp3 = new ObjectInputStream(con4.getInputStream());
			String Pr = (String) inp3.readObject();
			String S = (String) inp3.readObject();
			
			System.out.println("Pr = "+Pr);
			System.out.println("S = "+S);
			
			TableMultiplicatin(Integer.parseInt(Pr));
			Diviseur(Integer.parseInt(Pr));
			System.out.println("Fact >>>"+Fact(Integer.parseInt(S)));
			
			s4.close();con4.close();inp3.close();
		}
		catch(Exception e) {System.out.println(e.toString());}


	}

}
