package pack;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP {

	public static void main(String[] args) {
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Donner N : ");
			String N= sc.next();
			
			//Methode UDP -- Client
			//l'envoi de N a p2 
			DatagramSocket c = new DatagramSocket();
			InetAddress ip = InetAddress.getByName("localhost");
			byte[] sendData = new byte[10];//pour ennvoyer le N a P2
			sendData = N.getBytes();//la conversion de la chaine N(String) en Byte
			
			//la creation du packet
			DatagramPacket p = new DatagramPacket(sendData, sendData.length, ip, 9876);
			c.send(p); // envoyer le packet p
			
			//**************Serveur UDP***********************
			//*************************************************
			DatagramSocket s = new DatagramSocket(9876);//creation socketserveur
			// recevoir les donnees (sont arrivees sous forme de packets)
			byte[] receiveData = new byte[10];
			//creation de packet
			DatagramPacket q = new DatagramPacket(receiveData, receiveData.length);
			s.receive(q);// recevoir le packet q qui contient l'info N
			String str = new String(q.getData()).trim(); //recuperer les donnees , str contient N
			// la methode trim pour supprimer les blancs
			
			int S1 = Integer.parseInt(str)*2;
			System.out.println("S1 : "+S1);
			
			
		}
		catch(Exception e) {System.out.println(e.toString());}

	}

}
