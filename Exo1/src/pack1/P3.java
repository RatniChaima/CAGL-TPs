package pack1;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pack1.interfaceRMI;

public class P3 {

	public static void main(String[] args) {
		try {
			
			ServerSocket s3 = new ServerSocket(2000);
			System.out.println("P3 serveur en attente ...");
			// accepter la demande qui vient du client 
			Socket con3 = s3.accept();
			System.out.println("P2 : Connection Accepted");
			
			
			//recevoir from p2
			ObjectInputStream inp3 = new ObjectInputStream(con3.getInputStream());
			String N = (String) inp3.readObject();
			String M = (String) inp3.readObject();
			//System.out.println(N +"et "+ M);
			
			//RMI
			//envoi du N et M a P4
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			// creation d'une var de type interface(intP4)
			// lookup pour rechercher la reference de p4
			interfaceRMI i = (interfaceRMI) reg.lookup("Refp4");
			
			/*int Nenv = i.Envoyer(Integer.parseInt(N));
			int Menv = i.Envoyer(Integer.parseInt(M));*/
			
			int pr = i.Produit(i.Envoyer(Integer.parseInt(N)), i.Envoyer(Integer.parseInt(M)));
			//invoquer la mthd produit
			//int Np4 = i.Produit(Integer.parseInt(N));
			//input : des vals a envoyer - return : vals a recuperer
			
			System.out.println("N : "+N);
			System.out.println("M : "+M);
			System.out.println("produit : "+pr);
			
		}
		catch(Exception e) {System.out.println(e.toString());}
	}

}
