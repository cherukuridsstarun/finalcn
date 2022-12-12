import java.net.*;
import java.io.*;
public class Server {
public static void main(String[] args) throws Exception {
System.out.println("server is connected");
ServerSocket ss=new ServerSocket(3333);
System.out.println("Server is waiting for client request");
Socket s=ss.accept();
System.out.println("Client is connected, start chatting");
DataInputStream din=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str="",str2="";
while(!str.equals("stop"))
{
str=din.readUTF();
System.out.println("Client Says : "+str);
str2=br.readLine();
dout.writeUTF(str2);
dout.flush();
}
din.close();
ss.close();
}
}
