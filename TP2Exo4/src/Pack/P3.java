package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P3 {
	public static int Somme(int a, int b) {return a+b;}
	public static boolean Premier(int a) {
		int cpt=0;
		for (int i=1; i<a/2; i++)
		{
			if(a%i==0) cpt++;
		}
		return cpt==1; //si est vrai (c un diviseur)
		}
	public static int Produit(int a) {
		int pr=1;
		for (int i=1; i<=a; i++)
		{
			if (Premier(i)) { pr=pr*i;}
		}
		return pr;
	}
	public static void main(String[] args) {
		try {
			ServerSocket s3 = new ServerSocket(2003);
			System.out.println("P3 serveur en attente ...");
			// accepter la demande qui vient du client 
			Socket con3 = s3.accept();
			System.out.println("P2 est accepte");
			
			//recevoir from p2
			ObjectInputStream inp2 = new ObjectInputStream(con3.getInputStream());
			String N = (String) inp2.readObject();
			String M = (String) inp2.readObject();
			System.out.println(N);
			System.out.println(M);
			
			int S = Somme(Integer.parseInt(N), Integer.parseInt(M)) ;
			int Pr = Produit(S);
			
			// l'envoi du S et Pr a P4
			Socket con4 = new Socket("localhost",2004);
			System.out.println("Connected ...");
			ObjectOutputStream outp4 = new ObjectOutputStream(con4.getOutputStream());
			outp4.writeObject(Integer.toString(Pr));
			outp4.writeObject(Integer.toString(S));
			
			//envoyer ack au p1
			Socket con31 = new Socket("localhost",2001);
			System.out.println("Connected ...");
			ObjectOutputStream outp1 = new ObjectOutputStream(con31.getOutputStream());
			String ch="Ack";
			outp1.writeObject(ch);
			
			s3.close();inp2.close();con3.close();con4.close();outp4.close();con31.close();outp1.close();
		
		}
		catch(Exception e) {System.out.println(e.toString());}


	}

}
