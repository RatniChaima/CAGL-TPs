package pack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface intP4 extends Remote{
public int Produit (int a) throws RemoteException;
}
