import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) throws IOException,UnknownHostException {
        int port =5000;
        ServerSocket serverSocket;
        try{
            serverSocket=new ServerSocket(port);
            System.out.println("Server started on port: "+port);
            ObjectInputStream in=new ObjectInputStream(serverSocket.accept().getInputStream());
            String input=(String)in.readObject();
            if(input.equals("0")) {
                System.out.println("Server stopped");
                serverSocket.close();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
