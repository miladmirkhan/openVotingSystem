package server.admin;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import method.AdminFunction;

public class Client {
  public static void main(String []args) throws java.text.ParseException{
    Socket socket;
    int port = 1234;
    Scanner io=new Scanner(System.in);
    try{
      socket=new Socket("localhost",port);
      System.out.println("Connected to server on port: "+port);
      System.out.println("press 1 to countinue, 0 to exit");
      String input=io.nextLine();
      if(input.equals("0")) { 
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(input);
        socket.close();
        io.close();
      }
      if(input.equals("1")) {
        AdminFunction adminFunction=new AdminFunction();
        adminFunction.adminTerminal();
      }
    }catch(IOException e){
      System.out.println(e.getMessage()+ " there is no server running on port: "+port);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
