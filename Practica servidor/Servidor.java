
import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor{

	public static void main(String args[]) throws UnknownHostException{

	

	try{
		ServerSocket server = new ServerSocket(8080);
		String operacion;
		

		while(true){

			Socket cliente = server.accept();
			Scanner entrada = new Scanner( cliente.getInputStream() );
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			System.out.println("Usuario conectado");

			salida.println("Hola, que operacion desea realizar");
			operacion = entrada.nextLine();

			System.out.println(operacion);
		
			int operando1, operando2;
			int caso = 0;
			String letra = "";
			boolean noNumero = false;
			//System.out.println(operacion);

			//salida.println("La operaciOn es:" + operacion);
			for( int i = 1 ; i <= operacion.length() ; ++i ){
				letra = operacion.substring( (i-1) , i);
				if( 
					letra.compareTo("0") != 0 &&
					letra.compareTo("1") != 0 &&
					letra.compareTo("2") != 0 &&
					letra.compareTo("3") != 0 &&
					letra.compareTo("4") != 0 &&
					letra.compareTo("5") != 0 &&
					letra.compareTo("6") != 0 &&
					letra.compareTo("7") != 0 &&
					letra.compareTo("8") != 0 &&
					letra.compareTo("9") != 0 &&
					letra.compareTo(" ") != 0 &&
					letra.compareTo("\n")!= 0 
				 ){
					// Si el caracter no es un nUmero se prueba por si es algun operando binario

					if( caso != 0 ) // Si ya se ha encontrado un operador antes
					{
						caso = -1;	// Se invalida la operación sin importar si el caracter
									// actual es un operadon binario o no pues en caso 
									// afirmativo significa que hay mAs de un operador y 
									// en caso contrario que es un caracter invalido
					}
					else if ( letra.compareTo("+") == 0 ) // Si el operador es un +
					{
						caso = 1;
					}
					else if ( letra.compareTo("-") == 0 ) // Si el operador es un -
					{
						caso = 2;
					}
					else if ( letra.compareTo("*") == 0 ) // Si el operador es un *
					{
						caso = 3;
					}
					else if ( letra.compareTo("/") == 0 ) // Si el operador es un /
					{ 
						caso = 4;
					}else{
						noNumero = true;
					}

				}
			}

			if( noNumero || (caso == -1) ){
				salida.println("Error de formato, asegurese de solo ingresar enteros y operaciones");		
			}else{
				StringTokenizer st = new StringTokenizer(operacion,"+-*/ ");

				try{
					String a = st.nextToken();
					operando1 = Integer.parseInt(a);

					a = st.nextToken();
					operando2 = Integer.parseInt(a);

					if( caso== 1 ){
						salida.println("El resultado es: " + (operando1+operando2) );						
					}else if ( caso == 2 ){
						salida.println("El resultado es: " + (operando1-operando2) );
					}else if ( caso == 3 ){
						salida.println("El resultado es: " + (operando1*operando2) );
					}else{
						salida.println("El resultado es: " + ((float)operando1/operando2) );
					}
				}catch( NoSuchElementException nope ){
					salida.println("Falta de operandos");
				}

				

			}

		}

	}catch(IOException e){
		System.out.println("No hay flujo...");

	}

	}
}
