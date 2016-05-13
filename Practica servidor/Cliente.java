
import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente{

	public static void main(String args[]) throws UnknownHostException{

	Scanner entrada = new Scanner(System.in);

	try{
		
		Socket sock = new Socket("127.0.0.1", 8080);
		Scanner in = new Scanner(sock.getInputStream());	
		PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

		System.out.println(in.nextLine());

		out.println(entrada.nextLine());
		System.out.println(in.nextLine());
		

	}catch(IOException e){
		System.out.println("No hay flujo...");
	}

	}

}