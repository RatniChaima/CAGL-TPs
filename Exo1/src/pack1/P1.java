package pack1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Donner N : ");
			String N= sc.next();
			
			//l'envoi de N a p2 
			DatagramSocket c = new DatagramSocket();
			InetAddress ip = InetAddress.getByName("localhost");
			byte[] sendData = new byte[10];//pour ennvoyer le N a P2
			sendData = N.getBytes();//la conversion de la chaine N(String) en Byte
			
			//la creation du packet
			DatagramPacket p = new DatagramPacket(sendData, sendData.length, ip, 9876);
			c.send(p); // envoyer le packet p
			
			
			
			c.close();
		}
		catch(Exception e) {System.out.println(e.toString());}
	}

}
