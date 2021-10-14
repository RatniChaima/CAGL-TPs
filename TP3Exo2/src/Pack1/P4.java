package Pack1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P4 extends java.rmi.server.UnicastRemoteObject implements intP4{
	public P4() throws RemoteException{}
	public int Produit (int a) throws RemoteException
	{
		return a*4;
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
