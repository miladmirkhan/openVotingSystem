import java.io.*;
import java.net.*;
public class CandidateServer {
    public static void main(String[] args)throws IOException,ClassNotFoundException {
        Socket socket;
        ServerSocket serverSocket=new ServerSocket(5000);
        socket=serverSocket.accept();
        if(socket.isConnected()){
            System.out.println("Connected");
        }
        while(true){
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            if(inputStream.readObject().equals("0"))
                break;
        }
        serverSocket.close();
    }
}