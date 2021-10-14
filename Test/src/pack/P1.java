package pack;

import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		try {

			ServerSocket s = new ServerSocket(2000);
			System.out.println("P1 serveur en attente ...");
			// accepter la demande qui vient du client 
			Socket conRatni1 = s.accept();
			System.out.println("P0: Connection Accepted");
			
			
			//recevoir from p0
			ObjectInputStream inpRatni = new ObjectInputStream(conRatni1.getInputStream());
			String N = (String) inpRatni.readObject();
			System.out.println(N);
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Donner M : ");
			String M= sc.next();
			
			DatagramSocket cRATNI11 = new DatagramSocket();
			InetAddress ip = InetAddress.getByName("localhost");
			byte[] sendData = new byte[10];//pour ennvoyer le N a P2
			sendData = N.getBytes();//la conversion de la chaine N(String) en Byte
			byte[] sendDataM = new byte[10];//pour ennvoyer le N a P2
			sendData = M.getBytes();//la conversion de la chaine N(String) en Byte
			
			
			//la creation du packet
			DatagramPacket p = new DatagramPacket(sendData, sendData.length, ip, 9876);
			cRATNI11.send(p); // envoyer le packet p

			DatagramPacket p1 = new DatagramPacket(sendDataM, sendDataM.length, ip, 9876);
			cRATNI11.send(p1); // envoyer le packet p
			
			s.close();conRatni1.close();inpRatni.close();cRATNI11.close();
			
			
		}
		catch(Exception e) {System.out.println(e.toString());}

	}

}
