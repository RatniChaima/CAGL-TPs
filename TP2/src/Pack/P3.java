package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P3 {

	public static void main(String[] args) {
		try {
			ServerSocket s3 = new ServerSocket(2003);
			System.out.println("P3 en attente ...");
			Socket con3 = s3.accept();
			System.out.println("Connexion accepted ...");
			
			ObjectInputStream in3 = new ObjectInputStream(con3.getInputStream());
			String str = (String) in3.readObject();
			System.out.println("Reception >>> "+str);
			
			// repondre a p1
			ObjectOutputStream out3 = new ObjectOutputStream(con3.getOutputStream());
			//envoyer all is ok a p1
			out3.writeObject("All is ok");
			
			s3.close();con3.close();in3.close();out3.close();
		}
		catch(Exception e) { System.out.println(e.toString());}
	}

}
