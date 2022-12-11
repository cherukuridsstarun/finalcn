import java.io.*;
import java.net.*;
public class caserv 
{ 
	public static void main(String[] args) 
 	{ 
 		try
 		{
			System.out.println("============ Client 2 ===============");
 			while(true)
 			{ 
 				ServerSocket ss = new ServerSocket(3000);
 				System.out.println("Waiting for connection");
 				ss.accept();
 				ss.close();
 				System.out.println("Connected");
 			} 
 		} 
 		catch(Exception e)
		{ 
 			System.out.println(e);
 		} 
 	} 
}