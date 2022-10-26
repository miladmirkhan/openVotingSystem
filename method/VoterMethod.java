import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VoterMethod{

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
            
            list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setEmail(newEmail));
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
    input.close();
}

public ArrayList<String> displayVoter(ArrayList<Voter> voters){
    var voterDisplay = new ArrayList<String>();
    for(Voter voter: voters){
        voterDisplay.add(voter.toString());
    }
    return voterDisplay;
}

public void deleteVoter(ArrayList<Voter> voters, Voter voter){
    voters.remove(voter);
}

public boolean deleteVoterByNationalId(ArrayList<Voter> voters, String id){
    for(Voter voter: voters){
        if (voter.getNationalID().equals(id)){
            voters.remove(voter);
            return true;
        }
    }
    return false;
}

public boolean deleteVoterByFullName(ArrayList<Voter> voters, String fullName){
    for(Voter voter: voters){
        if (voter.getFullName().equals(fullName)){
            voters.remove(voter);
            return true;
        }
    }
    return false;
}
// send information to file of .txt

 public void sendVoterDetailsToTextFile(ArrayList<Voter> VoterList) throws IOException {
    FileWriter fileWriter = new FileWriter("Voter.txt");
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    for (Voter Voter : VoterList) {
        bufferedWriter.write(Voter.getNationalID() + "," + Voter.getFullName() + "," + Voter.getEmail() + "," + Voter.getMobileNumber() + "," + Voter.getPassword() + "," + Voter.getAddress() + "," + Voter.getZone() + "," + Voter.getVote());
        bufferedWriter.newLine();
    }
    bufferedWriter.close();
}
    public void sendVoteDetailsToTextFile(ArrayList<Vote> VoteList) throws IOException {
        FileWriter fileWriter = new FileWriter("Vote.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Vote Vote : VoteList) {
            bufferedWriter.write("1."+ Vote.getRankedVote1() + "," +"2."+ Vote.getRankedVote2() + "," +"3."+ Vote.getRankedVote3() );
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
