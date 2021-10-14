package pack;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class P0 {

	public static void main(String[] args) {
		try {
			// lire un entier du clavier
						Scanner sc = new Scanner(System.in);
						System.out.println("Donner N : ");
						String N= sc.next();
						// serveur 
						
						Socket cRATNI = new Socket("localhost",2000);
						System.out.println("Connected ...");
						ObjectOutputStream outRatni = new ObjectOutputStream(cRATNI.getOutputStream());
						outRatni.writeObject(N);
						
						//****************Serveur RMI*********************
						//creation d'un obj 
						P0 p0 = new P0();
						// la creation du regitre qui va recevoir le registre
						// dans le port de rmi par defaut 1099
						Registry reg = LocateRegistry.createRegistry(1099);
						//l'utilisation du reg
						reg.rebind("Refp0", p0);
						
						cRATNI.close();outRatni.close();
		
			
		}
		catch(Exception e) {System.out.println(e.toString());}
	}
		
}
