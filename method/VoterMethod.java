package method;

import java.util.ArrayList;
import java.util.Scanner;

public class VoterMethod<Voter> {

// add 
public void addVoter(ArrayList<Voter> list,Voter voter){

    list.add(voter);
}
// edit
public void editVoter(ArrayList<Voter> list,int index,Voter voter){
    list.set(index, voter);
}

public void editVoter(ArrayList<Voter> list,Voter voter,Voter newVoter){

    int index = list.indexOf(voter);
    list.set(index, newVoter);
}


public  void editVoter(ArrayList<Voter> list) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the national ID:");
    String id = input.nextLine();
    System.out.println("""
    What do you want to change ?
      1-Email
      2-Mobile Number
      3-password""");
    int option = input.nextInt();
    switch (option) {
        case 1:
            System.out.println("Enter the new Email:");
            String newEmail = input.next();
            
            list.stream().filter(x -> x.getNatioxnalID().equals(id)).forEach(x -> x.setEmail(newEmail));
            break;
        case 2:
            System.out.println("Enter the new mobile number:");
            String newMobileNumber = input.next();
            list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setMobileNumber(newMobileNumber));
            break;
        case 3:
            System.out.println("Enter the new password :");
            String newPassword = input.next();
            list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setPassword(newPassword));
            break;
    }
}

}
