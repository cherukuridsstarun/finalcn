import java.util.*;
import java.io.*;
import java.net.*;
public class cdserv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("======client2======");
			ServerSocket ss=new ServerSocket(3000);
			System.out.println("waiting for con");
			Socket con=ss.accept();
			ObjectInputStream in =new ObjectInputStream(con.getInputStream());
			System.out.print((String)in.readObject());
			in.close();
			ss.close();
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

}
