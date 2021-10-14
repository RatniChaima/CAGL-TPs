import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceRMI extends Remote{

void receiveMessage(String ch) throws RemoteException;
int calcul(int a, int b)throws RemoteException;

}
