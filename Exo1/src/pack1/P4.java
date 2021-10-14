package pack1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pack1.P4;

public class P4 extends java.rmi.server.UnicastRemoteObject implements interfaceRMI{
	public P4() throws RemoteException{}
	public int Envoyer (int a) throws RemoteException
	{
		return a;
	}
	public int Produit (int a, int b) throws RemoteException
	{
		return a*b;
	}
	
	public static void main(String[] args) {
		try {
			//Serveur RMI
			//creation d'un obj p4
			P4 p4 = new P4();
			
			// la creation du regitre qui va recevoirle registre
			// dans le port de rmi par defaut 1099
			Registry reg = LocateRegistry.createRegistry(1099);
			
			//l'utilisation du reg
			reg.rebind("Refp4", p4);
		
			
		}
		catch(Exception e) {System.out.println(e.toString());}

	}
	

}
