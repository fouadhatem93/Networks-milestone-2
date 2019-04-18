import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

    private static Socket socket;

    public static void main(String args[])throws Exception
    {   String sentence=""; 
    String modifiedSentence=""; 
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    sentence=br.readLine();
    if(sentence.equals("CONNECT")) {
    System.out.println("CONNECTION ESTABLISHED");	
    
        Socket connectionSocket = new Socket("127.0.0.1",6789); 
        DataInputStream inFromServer=new DataInputStream(connectionSocket.getInputStream());
        DataOutputStream outFromClient=new DataOutputStream(connectionSocket.getOutputStream());
	     while(!sentence.equals("close")) {
	    	 sentence=br.readLine();
	    	 if(sentence.equals("close")) {
	    		 System.out.println("Connection closed");
	    		 outFromClient.writeUTF(sentence);
	    	     br.close();
	    	     connectionSocket.close();break;
	    	 }
	    	
	    	 outFromClient.writeUTF(sentence);
	    	 
	    	//outFromClient.flush();
	    	 modifiedSentence=inFromServer.readUTF();
	    	 System.out.println("From Server: "+modifiedSentence );
	    	 
	     }
	    /* System.out.println("Connection closed");
	     br.close();
	     connectionSocket.close();*/
	     
    }else System.out.println("CONNECTION REFUSED");
}
    }