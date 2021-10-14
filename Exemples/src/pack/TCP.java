package pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP {

	public static void main(String[] args) {
		try {
			//****************** envoyer et recevoir du mm prog*********
		// recevoir S1 depuis p2
		ServerSocket s3 =  new ServerSocket(2004);
		System.out.println("P2 : Waiting for connection");
		// accepter la demande qui vient du client P2
		Socket con = s3.accept();
		System.out.println("P2 : Connection Accepted");
		ObjectInputStream inp3 = new ObjectInputStream(con.getInputStream());
		String S1 = (String) inp3.readObject();
		
		int S2 = Integer.parseInt(S1)*3;
		System.out.println("S2 : "+S2);
		
		//envoi du S2 vers P2
		
		ObjectOutputStream outp3 = new ObjectOutputStream(con.getOutputStream());
		outp3.writeObject(Integer.toString(S2));
		
		
		//*******************************************************
		//******************** 2 prog diff************
		
		// lire un entier M et envoyer N et M a P3
		//serveur
		ServerSocket s2 = new ServerSocket(2002);
		System.out.println("P2 serveur en attente ...");
		// accepter la demande qui vient du client 
		Socket con2 = s2.accept();
		System.out.println("P1 : Connection Accepted");
		
		
		//recevoir from p1
		ObjectInputStream inp1 = new ObjectInputStream(con2.getInputStream());
		String N = (String) inp1.readObject();
		
		// lire un entier du clavier
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner M : ");
		String M= sc.next();
		//client
		Socket c2 = new Socket("localhost",2003);
		System.out.println("Connected ...");
		ObjectOutputStream outp4 = new ObjectOutputStream(c2.getOutputStream());
		outp3.writeObject(N);outp4.writeObject(M);

		//close......
		
		
		
		}
		catch(Exception e) {System.out.println(e.toString());}
					
	}

}
