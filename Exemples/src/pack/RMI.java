package pack;

import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Pack1.P4;
import Pack1.intP4;


	public class RMI extends java.rmi.server.UnicastRemoteObject implements intP4{
		public RMI() throws RemoteException{}
		public int Produit (int a) throws RemoteException
		{
			return a*4;
		}

	public static void main(String[] args) {
		try {
			//****************Serveur RMI*********************
			//creation d'un obj p4
			RMI p4 = new RMI();
			// la creation du regitre qui va recevoir le registre
			// dans le port de rmi par defaut 1099
			Registry reg = LocateRegistry.createRegistry(1099);
			//l'utilisation du reg
			reg.rebind("Refp4", p4);
			
			//***********************
		/*	ObjectInputStream inp2 = new ObjectInputStream(c2.getInputStream());
			String S2 = (String) inp2.readObject();
			System.out.println("S2 : "+S2);*/
			
			//****************Client RMI**********************
			//recuperer 
			Registry reg1 = LocateRegistry.getRegistry("localhost", 1099);
			// creation d'une var de type interface(intP4)
			// lookup pour rechercher la reference de p4
			intP4 i = (intP4) reg1.lookup("Refp4");
			//invoquer la mthd produit
			int S3 = i.Produit(Integer.parseInt(S2));
			//input : des vals a envoyer - return : vals a recuperer
			
			System.out.println("S3 : "+S3);
			
		}
		catch(Exception e) {System.out.println(e.toString());}


	}

}
