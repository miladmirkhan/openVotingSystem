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
public void addVoter(ArrayList<Voter> voterlist){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your full name:");
    String fullName = input.next();
    System.out.println("Enter your age:");
    String age = input.next();
    System.out.println("Enter your national ID:");
    String nationalID = input.next();
    System.out.println("Enter your email:");
    String email = input.next();
    System.out.println("Enter your mobile number:");
    String mobileNumber = input.next();
    System.out.println("Enter your password:");
    String password = input.next();
    System.out.println("Enter your address:");
    String address = input.next();
    System.out.println("Enter your zone:");
    String zone = input.next();
    
    Voter voter = new Voter(fullName,age, nationalID, email, mobileNumber, password, address,zone);
    voterlist.add(voter);
    input.close();
    System.out.println("Voter added successfully!");

}

public void addVoteByVoter(ArrayList<Voter> list){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your national ID:");
    String nationalID = input.next();
    for (Voter voter : list) {
        if (voter.getNationalID().equals(nationalID)) {
            System.out.println("Enter your first ranked vote:");
            String rankedVote1 = input.next();
            System.out.println("Enter your second ranked vote:");
            String rankedVote2 = input.next();
            System.out.println("Enter your third ranked vote:");
            String rankedVote3 = input.next();
            Vote vote = new Vote(true, rankedVote1, rankedVote2, rankedVote3);
            voter.setVote(vote);
            System.out.println("Vote added successfully!");
        }
    }
    input.close();

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

// vote with voter
public void voteWithVoter(ArrayList<Voter> voters,ArrayList<Vote> votes, Vote vote){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your national ID:");
    String id = input.nextLine();
    System.out.println("Enter your password:");
    String password = input.nextLine();
    for(Voter voter: voters){
        if(voter.getNationalID().equals(id) && voter.getPassword().equals(password)){
            votes.add(vote);
            System.out.println("Vote added successfully!");
            break;
        }
    }
    input.close();
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

public void voterApplication(ArrayList<Voter> voterlist){

    while(true){
        System.out.println("Welcome to the voter application");
        System.out.println("1- Sign up");
        System.out.println("2- Sign in");
        System.out.println("3- Delete voter");
        System.out.println("4- Edit voter");
        System.out.println("5- Display all voters");
        System.out.println("6- vote");
        System.out.println("7-send voter list to json");
        System.out.println("8-get voter list from json");
        System.out.println("9- Exit");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            case 1:
            addVoter(voterlist);
                break;
            case 2:
            if(signInVoter(voterlist)){
                System.out.println("You are signed in successfully!");
            }else{
                System.out.println("You are not signed in!");
            }
                break;
            case 3:
                     System.out.println("1- Delete voter by national id");
                     System.out.println("2- Delete voter by full name");
                      int deleteOption = input.nextInt();
                                switch (deleteOption) {
                                    case 1:
                                    System.out.println("Enter national id");
                                    String nationalId = input.next();
                                    deleteVoterByNationalId(voterlist, nationalId);
                                        break;
                                    case 2:
                                    System.out.println("Enter full name");
                                    String fullName = input.next();
                                    deleteVoterByFullName(voterlist, fullName);
                                        break;
                                    default:
                                        break;
                                }
                break;
            case 4:
            editVoter(voterlist);
                 
                break;
            case 5:
                displayVoter(voterlist);
                break;
            case 6:
            addVoteByVoter(voterlist);
                break;
           
            case 7:
            try {
                sendVoterListToJson(voterlist);
            } catch (IOException e) {
                
                e.printStackTrace();
            }
                break;    

            case 8:
            try {
                readVoterListFromJson(voterlist);
            } catch (IOException e) {

                e.printStackTrace();
            }
                break;
            case 9:
                
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;


            }
            input.close();
        }
        
    }



public void signInVoter(ArrayList<Voter> list){

    Scanner input = new Scanner(System.in);
    System.out.println("Enter your national ID:");
    String id = input.next();
    System.out.println("Enter your password:");
    String pass = input.next();
    if (signIn(list, id, pass)) {
        System.out.println("You are signed in");
    } else {
        System.out.println("You are not signed in");
    }
    input.close();
}


private boolean signIn(ArrayList<Voter> list, String id, String pass) {
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getNationalID().equals(id) && list.get(i).getPassword().equals(pass)) {
            return true;
        }
    }
    return false;
}
}