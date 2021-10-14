import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class ClientRMI {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			interfaceRMI i = (interfaceRMI) reg.lookup("Refs");
			i.receiveMessage("master il");
			int somme = i.calcul(10,15);
			
			System.out.println("somme : "+somme);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
