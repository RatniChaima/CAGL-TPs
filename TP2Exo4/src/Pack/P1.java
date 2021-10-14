package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		
		try {// lire un entier du clavier
			Scanner sc = new Scanner(System.in);
			System.out.println("Donner N : ");
			String N= sc.next();
			// envoyer N a p2
			Socket c = new Socket("localhost",2002);
			System.out.println("Connected ...");
			ObjectOutputStream outp2 = new ObjectOutputStream(c.getOutputStream());
			outp2.writeObject(N);
			
			// recevoir Ack depuis p3
			ServerSocket s1 = new ServerSocket(2001);
			System.out.println("P1 serveur en attente ...");
			// accepter la demande qui vient du client 
			Socket con1 = s1.accept();
			System.out.println("P3 est accepte");
			ObjectInputStream inp3 = new ObjectInputStream(con1.getInputStream());
			String ss = (String) inp3.readObject();
			System.out.println("Reception from P3 :"+ss);
			
			
			c.close();outp2.close();inp3.close();s1.close();con1.close();
		}
		catch(Exception e) {System.out.println(e.toString());}

	}

}
