import java.io.*;
import java.net.*;
import java.util.*;
public class myreceiver {
	public static void main(String args[])
	{
		try {
			Socket s=new Socket("localhost",113);
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream di=new DataInputStream(s.getInputStream());
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of frames to be sent");
			int n=sc.nextInt();
			String k= Integer.toString(n);
			dout.writeUTF(k);
			String ack[]=new String[n];
			int sendwindow=0;
			System.out.println("Enter sendwindow size");
			sendwindow=sc.nextInt();
			for(int i=0,j=0;i<n/sendwindow;i++) {
				while(j<sendwindow) {
					System.out.println("enter frame"+j);
					String fr=sc.next();
					dout.writeUTF(fr);
					ack[i]=(String)di.readUTF();
					System.out.println(ack[i]);
					j++;
				}
				j=0;
			}
			dout.flush();
			dout.close();
			s.close();
			sc.close();
		}catch(Exception e) {System.out.println(e);}
	}

}
