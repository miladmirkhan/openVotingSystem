package server.voter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;

public class VoterServer {
    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket;
        try{
            serverSocket=new ServerSocket(port);
            System.out.println("Server started on port: "+port);
            ObjectInputStream in=new ObjectInputStream(serverSocket.accept().getInputStream());
            String input=(String)in.readObject();
            if(input.equals("0")) serverSocket.close();
        }catch(IOException e){
          System.out.println(e.getMessage()+ " there is no server running on port: "+port);
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
    }
}