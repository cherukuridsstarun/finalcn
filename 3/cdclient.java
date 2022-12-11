import java.io.*;
import java.net.*;
public class cdclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		 { 
			System.out.println("============ Client 1 ===============");
			cdclient cli = new cdclient();
			int Tp = 2000;
			int R = 0;
		 	int Tb = 0;
		 	for(int i=1; i<=15;i++)
		 	{ 
		 		System.out.println("attempt : "+i);
		 		if(cli.send() == "sent")
		 		{ 
		 			break;
		 		} 
		 		else
		 		{ 
		 			R = 2^i-1;
					System.out.println("Selected Random number :"+R);
		 			Tb = R*Tp;
		 			System.out.println("waiting for next attempt with back time (in seconds): "+Tb);
		 			Thread.sleep(Tb);
		 		} 
			} 
		 } 
		 catch (InterruptedException e)
		 { 
		 	System.out.println(e);
		 } 
	} 
	String send()
	{ 
		String str=null;
		String msg = "CNLAB";
		try
		{ 
			Socket soc = new Socket("localhost",3000);
			ObjectOutputStream out = new 
			ObjectOutputStream(soc.getOutputStream());
			out.writeObject(msg);
		 	System.out.println("Message sent : "+msg);
		 	str = "sent";
		 } 
		 catch(Exception e)
		 { 
			str = "collision occured";
		 	System.out.println("Message sent : "+msg);
		 } 
		 return str; 
		 } 
		}