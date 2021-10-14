package Pack1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P2 {
	public static void main(String[] args) {
		try {
			//Serveur UDP
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
			
			//Envoyer S1 a P3 
			//methode TCP
			Socket c2 = new Socket("localhost",2004);
			System.out.println("Connected ...");
			ObjectOutputStream outp2 = new ObjectOutputStream(c2.getOutputStream());
			outp2.writeObject(Integer.toString(S1));
			
			//recevoir S2 from P3 TCP
			
			ObjectInputStream inp2 = new ObjectInputStream(c2.getInputStream());
			String S2 = (String) inp2.readObject();
			System.out.println("S2 : "+S2);
			
			//Client RMI
			
			//recuperer 
			Registry reg1 = LocateRegistry.getRegistry("localhost", 1099);
			// creation d'une var de type interface(intP4)
			// lookup pour rechercher la reference de p4
			intP4 i = (intP4) reg1.lookup("Refp4");
			//invoquer la mthd produit
			int S3 = i.Produit(Integer.parseInt(S2));
			//input : des vals a envoyer - return : vals a recuperer
			
			System.out.println("S3 : "+S3);
			
			s.close();c2.close();outp2.close();inp2.close();
			
		}
		catch(Exception e) {System.out.println(e.toString());}

	}

}
