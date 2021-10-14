package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P2 {

	public static void main(String[] args) {
		//serveur
		try {
			ServerSocket s2 = new ServerSocket(2002);
			System.out.println("P2 en attente ...");
			Socket con2 = s2.accept();
			System.out.println("Connexion accepted ...");
			
			ObjectInputStream in2 = new ObjectInputStream(con2.getInputStream());
			String str = (String) in2.readObject();
			
			// envoyer ce qu'on a stocker dans str a p3
			Socket c1 = new Socket ("localhost",2003);
			System.out.println("Connected ...");
			
			ObjectOutputStream out2 = new ObjectOutputStream(c1.getOutputStream());
			// envoyer l'info
			out2.writeObject(str);
			
			//connecter avec p3 , recevoir a partir de p3
			ObjectInputStream inp3 = new ObjectInputStream(c1.getInputStream());
			str = (String) inp3.readObject();// reception de str
			
			// envoyer cette info a p1
			ObjectOutputStream outp1 = new ObjectOutputStream(con2.getOutputStream());
			outp1.writeObject(str);
			
			s2.close();con2.close();in2.close();c1.close();out2.close();inp3.close();outp1.close();
		}
		catch(Exception e) { System.out.println(e.toString());}

	}

}
