package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class P3 {

	public static void main(String[] args) {
		// le client
		
		try {
			//creation d'un obj de type socket 
			//et au mm temps c une demande de connection
			Socket c = new Socket("localhost",2006);
			
			//creation de flux d'info a partir de lobj socket c
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(c.getInputStream());
			
			//envoyer l'info "Info IL"
			out.writeObject("Info RSD");
			
			String str = (String) in.readObject();
			System.out.println(str);
			
			c.close();out.close(); in.close();
			
			
		}
		catch(Exception e) {System.out.println(e.toString());
		}
	}

}
