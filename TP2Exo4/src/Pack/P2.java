package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		try { // lire un entier M et envoyer N et M a P3
			ServerSocket s2 = new ServerSocket(2002);
			System.out.println("P2 serveur en attente ...");
			// accepter la demande qui vient du client 
			Socket con2 = s2.accept();
			System.out.println("P1 est accepte");
			
			//recevoir from p1
			ObjectInputStream inp1 = new ObjectInputStream(con2.getInputStream());
			String N = (String) inp1.readObject();
			
			// lire un entier du clavier
			Scanner sc = new Scanner(System.in);
			System.out.println("Donner M : ");
			String M= sc.next();
			
			Socket c2 = new Socket("localhost",2003);
			System.out.println("Connected ...");
			ObjectOutputStream outp3 = new ObjectOutputStream(c2.getOutputStream());
			outp3.writeObject(N);outp3.writeObject(M);
			
			s2.close();con2.close();inp1.close();c2.close();outp3.close();
			
		}
		catch(Exception e) {System.out.println(e.toString());}


	}

}
