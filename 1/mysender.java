import java.io.*;
import java.net.*;
public class mysender {
	public static void main(String args[])
	{
		try {
			ServerSocket ss=new ServerSocket(113);
			Socket s=ss.accept();
DataInputStream dis=new DataInputStream(s.getInputStream());
DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			int p=Integer.parseInt(dis.readUTF());
			//intreceivewindow=1;
			for(int i=0;i<p;i++)
			{
			String Str[]=new String[p];
			Str[i]=(String)dis.readUTF();
			System.out.println("Frame"+i+" is "+Str[i]);
			//System.out.println("Ack sent");
			dos.writeUTF("ACK");
			}
			ss.close();
		}catch(Exception e) {System.out.print(e);}
	}
}

