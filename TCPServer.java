import java.io.*;
import java.net.*;

public class TCPServer {

    private static Socket socket;

    public static void main(String[] args) throws Exception
    {
    	  String clientSentence=""; 
	      String capitalizedSentence=""; 

	      ServerSocket welcomeSocket = new ServerSocket(6789); 
	  
	     // while(true) { 
	  
	            Socket connectionSocket = welcomeSocket.accept(); 
	     DataInputStream inFromClient=new DataInputStream(connectionSocket.getInputStream());
	     DataOutputStream outFromServer=new DataOutputStream(connectionSocket.getOutputStream());
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     while(!clientSentence.equals("close")) {
	    	 clientSentence=inFromClient.readUTF();
	    	if(clientSentence.equals("close")) {
	    		 br.close();break;
	    	}
	    	 System.out.println("From Client: "+clientSentence);
	    	 capitalizedSentence=br.readLine();
	    	 outFromServer.writeUTF(capitalizedSentence);
	    	 outFromServer.flush();
	     }
	     br.close();
	     //connectionSocket.close();
    }
    
}