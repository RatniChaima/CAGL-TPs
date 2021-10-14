package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P2 {

	public static void main(String[] args) {
		try {
			// il faut tjrs commencer par executer le serveur
			// le serveur
			ServerSocket s = new ServerSocket(2007);
			System.out.println("Serveur en attente");
			
			//une bcl pr plusieurs clients
			while(true)
			{
			Socket connection = s.accept(); // accepter les demandes de connections
			System.out.println("Accepted ...");
			
			//la creation des flux d'infos d'entrees et de sorties
			
			// output.. pour l'envoi du message
			ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
			// input.. pour la reception des messages
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
			
			// la reception ou la communication
			// on va recevoir un message a partir du client
			String ch=(String) in.readObject();
			System.out.println("Reception >>>>>>"+ch);
			
			out.writeObject("ack1");
			}
			
			/*
			//client num2 =p3
			connection = s.accept(); // accepter les demandes de connections
			System.out.println("Accepted ...");
			
			out = new ObjectOutputStream(connection.getOutputStream());
			in = new ObjectInputStream(connection.getInputStream());
			ch=(String) in.readObject();
			System.out.println("Reception >>>>>>"+ch);
			out.writeObject("ack2");
			
			s.close();in.close();out.close();connection.close();
			
			*/
		}
		catch(Exception e) {System.out.println(e.toString());

	}

}
}
