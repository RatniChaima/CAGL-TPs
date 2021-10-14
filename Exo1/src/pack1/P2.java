package pack1;

import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		try {
			
			
			//recevoir N
			DatagramSocket s = new DatagramSocket(9876);//creation socketserveur
			// recevoir les donnees (sont arrivees sous forme de packets)
			byte[] receiveData = new byte[50];
			//creation de packet
			DatagramPacket q = new DatagramPacket(receiveData, receiveData.length);
			s.receive(q);// recevoir le packet q qui contient l'info N
			String N = new String(q.getData()).trim(); //recuperer les donnees , str contient N
			// la methode trim pour supprimer les blancs
			
			//int N = Integer.parseInt(str);
			//System.out.println("N : "+N);
			
			// lire un entier du clavier
			Scanner sc = new Scanner(System.in);
			System.out.println("Donner M : ");
			String M= sc.next();
			// serveur 
			
			Socket c2 = new Socket("localhost",2000);
			System.out.println("Connected ...");
			ObjectOutputStream outp3 = new ObjectOutputStream(c2.getOutputStream());
			outp3.writeObject(N);outp3.writeObject(M);
			
			s.close();c2.close();outp3.close();
			
			
			
		}
		catch(Exception e) {System.out.println(e.toString());}

	}

}
