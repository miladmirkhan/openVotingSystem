import java.io.*;
import java.net.*;
import java.util.*;

public class CandidateClient {

    public static void main(String[] args)throws IOException,ClassNotFoundException, UnknownHostException {
        Socket socket=new Socket("localhost",5000);
        Scanner input=new Scanner(System.in);
        while(true){
            ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Press 1 to continue 0 to close");
            String getValue=input.nextLine();
            if(getValue.equals("0")){
                output.writeObject(getValue);
                break;
            }
            ArrayList<Candidate> arrayList=new ArrayList<>();
            CandidateFunction.candidateFunction(arrayList);
        }
        socket.close();
        input.close();

    }

}
