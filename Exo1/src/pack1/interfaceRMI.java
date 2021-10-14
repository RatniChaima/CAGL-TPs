package pack1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceRMI extends Remote{
	public int Envoyer (int a) throws RemoteException;
	public int Produit (int a, int b) throws RemoteException;
}
