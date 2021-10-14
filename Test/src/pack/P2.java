package pack;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P2 {

	public static void main(String[] args) {
		try {
			DatagramSocket s = new DatagramSocket(9876);//creation socketserveur
			// recevoir les donnees (sont arrivees sous forme de packets)
			byte[] receiveData = new byte[10];
			byte[] receiveDataM = new byte[10];
			//creation de packet
			DatagramPacket q = new DatagramPacket(receiveData, receiveData.length);
			s.receive(q);// recevoir le packet q qui contient l'info N
			String str = new String(q.getData()).trim(); //recuperer les donnees , str contient N

			DatagramPacket q1 = new DatagramPacket(receiveDataM, receiveDataM.length);
			s.receive(q);// recevoir le packet q1 qui contient l'info M
			String str1 = new String(q1.getData()).trim(); //recuperer les donnees , str contient N
			// la methode trim pour supprimer les blancs
			
			Registry reg1 = LocateRegistry.getRegistry("localhost", 1099);
			// creation d'une var de type interface(intP4)
			// lookup pour rechercher la reference de p4
			interfaceP2 i = (interfaceP2) reg1.lookup("Refp0");
			//invoquer la mthd produit
			int som = i.somme(Integer.parseInt(str),Integer.parseInt(str1));
			//input : des vals a envoyer - return : vals a recuperer
			
			
			
			//int S1 = Integer.parseInt(str)*2;
		}
		catch(Exception e) {System.out.println(e.toString());}

	}

}
