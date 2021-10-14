package Pack1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P3 {

	public static void main(String[] args) {
		try {
			// recevoir S1 depuis p2
			ServerSocket s3 =  new ServerSocket(2004);
			System.out.println("P3 serveur en attente ...");
			// accepter la demande qui vient du client P2
			Socket con = s3.accept();
			System.out.println("P2 est accepte");
			ObjectInputStream inp3 = new ObjectInputStream(con.getInputStream());
			String S1 = (String) inp3.readObject();
			
			int S2 = Integer.parseInt(S1)*3;
			System.out.println("S2 : "+S2);
			
			//envoi du S2 vers P2
			
			ObjectOutputStream outp3 = new ObjectOutputStream(con.getOutputStream());
			outp3.writeObject(Integer.toString(S2));
			
			
			s3.close();con.close();inp3.close();outp3.close();

		}
		catch(Exception e) {System.out.println(e.toString());}

	}

}
