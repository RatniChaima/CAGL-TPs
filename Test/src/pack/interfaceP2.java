package pack;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceP2 {
	

	public interface interfaceRMI extends Remote{
		
		public int somme (int a, int b) throws RemoteException;
	}

}
