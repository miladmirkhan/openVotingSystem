package views;
import models.Vote;
public class VoterView {
        public void printVoterDetails(String fullname, String nationalID, String email, String password, String phoneNo, Vote vote){
            System.out.println("Admin:");
            System.out.println("National-ID: "+nationalID);
            System.out.println("Fullname: "+fullname);
            System.out.println("Email: "+email);
            System.out.println("Phone Number: "+ phoneNo);
            System.out.println("Password: "+password);
            System.out.println("Vote: "+vote);
        
    }
    
}
