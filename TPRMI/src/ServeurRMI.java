import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurRMI extends java.rmi.server.UnicastRemoteObject implements interfaceRMI{
	public ServeurRMI() throws RemoteException{
		System.out.println("Serveur RMI..");
	}
	public	void receiveMessage(String ch) throws RemoteException{
		System.out.println("invocation de la methode receiveMessage : "+ch);
	}
	public int calcul(int a, int b)throws RemoteException{
		System.out.println("invocation de la methode calcul ");
		
		return a+b;
		
	}
	public static void main(String[] args) throws RemoteException{
		
		ServeurRMI s= new ServeurRMI();
		System.out.println("serveur en execution..");
		Registry reg = LocateRegistry.createRegistry(1099);
		System.out.println("Creation de registre ... ok");
		reg.rebind("Refs", s);
	}

}
