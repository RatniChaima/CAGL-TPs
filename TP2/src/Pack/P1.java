package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

//P1->P2->P3
//EXEC : {P3, P2}, P1 on a le choix de commencer par p2 ou p3
public class P1 {
	//client

	// p1 lire une info a partir du clavier et l'envoyer au p2, p2 il recoit l'info et l'envoi ver p3
	
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Donner une chaine :");
			String ch = sc.next();
			
			Socket c = new Socket ("localhost",2002);
			System.out.println("Connected ...");
			
			ObjectOutputStream out1 = new ObjectOutputStream(c.getOutputStream());
			// envoyer l'info
			out1.writeObject(ch);
			
			// flux d'info d'entree
			ObjectInputStream in1 = new ObjectInputStream(c.getInputStream());
			String str = (String) in1.readObject();
			System.out.println("P1 : Reception >>> "+str);
			
			
			c.close();out1.close();
		}
		catch(Exception e) { System.out.println(e.toString());}

	}

}
