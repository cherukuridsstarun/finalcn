import java.io.*;
import java.net.*;
public class caclient 
{ 
public static void main(String[] args) 
 { 
 try
 { 
 	System.out.println("============ Client 1 ===============");
 	caclient cli = new caclient();
 	int R = 0;
 	Boolean bln = false;
 
 	for(int k=1; k<=15;k++)
 	{ 
 		System.out.println("attempt : "+k);
 		System.out.println("is Channel idle? ");
 		int i = 0;
 		while(true)
 		{ 
 			System.out.print(i=i+1);
 			if(cli.isidle())
 			{ 
 				System.out.println("\n Channel idle");
 				System.out.println("Wait IFS time 5000");
 				Thread.sleep(8000);
 				System.out.println("is still idle?");
 				if(cli.isidle())
 				{ 
 					System.out.println("Still idle");
 					R = 2^k-1;
 					System.out.println("Selected Random number :"+R);
 					System.out.println("waiting for R slot time: "+R*6000);
					Thread.sleep(R*6000);
					System.out.println("Message sent");
					System.out.println("Wait for time out : "+10000);
					Thread.sleep(10000);
 					if(cli.isidle())
					{
						System.out.println("Ack received");
 						bln = true;
 						break;
 					} 
 					else
 					{ 
 						System.out.println("Ack not received");
 						break;
					} 
 				} 
 				else
 				{ 
 					System.out.println("Busy, goes to channel idle check");
 				} 
 			} 
 		} 
 		if(bln == true)
 		{ 
 			break;
 		} 
	 } 
 	} 
 	catch (InterruptedException e)
 	{ 
 		System.out.println(e);
 	} 
 } 
 
Boolean isidle()
 { 
 	try
 	{ 
 		Socket soc= new Socket("localhost",3000); 
 		soc.close();
 		return true;
 	} 
 	catch (Exception e)
 	{ 
 		return false;
 	} 
 
 	} 
}