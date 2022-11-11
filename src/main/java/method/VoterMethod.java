package method;

import models.Vote;
import models.Voter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VoterMethod{

// add 
public void addVoter(ArrayList<Voter> list, Voter voter){

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
    System.out.println("What do you want to change ? \n 1-Email \n2-Mobile \nNumber \n3-password");
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


public void sendVoterListToJson(ArrayList<Voter> voters) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("voters.json"));
    writer.write("{");
        writer.write("\"Voter\":[");
        for (int i = 0; i < voters.size(); i++) {
       
            writer.write("{");
        
        writer.write("\n \"fullName\": \"" + voters.get(i).getFullName() + "\" \n");

        writer.write(", \"Age\": \"" + voters.get(i).getAge() + "\"\n");
    
        writer.write(", \"nationalID\": \"" + voters.get(i).getNationalID() + "\" \n");
     
        writer.write(", \"email\": \"" + voters.get(i).getEmail() + "\" \n");
      
        writer.write(", \"mobileNumber\": \"" + voters.get(i).getMobileNumber() + "\"\n");
   
        writer.write(", \"password\": \"" + voters.get(i).getPassword() + "\"\n");
     
        writer.write(", \"address\": \"" + voters.get(i).getAddress() + "\"\n");
       
        writer.write(", \"zone\": \"" + voters.get(i).getZone() + "\"\n");
       
        writer.write(", \"voted\": \"" + voters.get(i).getVote() + "\"\n");
        writer.write("}");
        if (i != voters.size() - 1) {
            writer.write(",");
        }
    }


    writer.write("]}");
    writer.close();
}

public void sendVoteListToJson(ArrayList<Vote> votes) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("votes.json"));
    writer.write("{");
        writer.write("\"Voter\":[");
        for (int i = 0; i < votes.size(); i++) {
            // voter full name 
            
            if( votes.get(i).isVoted()){
          writer.write("{");
        writer.write("\n \"Voted\": \"" + votes.get(i).isVoted() + "\" \n");
       
        writer.write(", \"Vote one\": \"" + votes.get(i).getRankedVote1() + "\" \n");
       
        writer.write(", \"Vote two\": \"" + votes.get(i).getRankedVote2() + "\" \n");
      
        writer.write(", \"Vote three\": \"" + votes.get(i).getRankedVote3() + "\"\n");
      }else{
        continue;
      }
        writer.write("}");
        if (i != votes.size() - 1||i==votes.size()) {
            writer.write(",");
        }
    }

    writer.write("]}");
    writer.close();
}

public static void readVoterListFromJson(ArrayList<Voter> voters) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("voters.json"));
    String line = reader.readLine();
    while (line != null) {
        System.out.println(line);
        line = reader.readLine();
    }
    reader.close();
}

public static void readVoteListFromJson(ArrayList<Vote> votes) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("votes.json"));
    String line = reader.readLine();
    while (line != null) {
        System.out.println(line);
        line = reader.readLine();
    }
    reader.close();

}

}