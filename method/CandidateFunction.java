package method;

import models.Candidate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.*;
public class CandidateFunction {
    static Scanner console = new Scanner(System.in);

    public static void candidateFunction(ArrayList<Candidate> candidateList) throws IOException {
        while (true){
            int option = -1;
            System.out.println("Welcome To Candidate Application" +
                    "\n1.Sign In" +
                    "\n2.Sign Up" +
                    "\n3.Delete Candidate" +
                    "\n4.Display all Candidate" +
                    "\n0.Quit\n");
            try {
                option = console.nextInt();
            } catch (Exception e){
                System.out.println("\n\n\n\n\n\n\n\nPlease enter a number");
                continue;
            }
            if (option==1){
                signIn(candidateList);
            }else if(option==2){
                addCandidate(candidateList);
                sendCandidateListToJson(candidateList);
            }else if (option==3){
                deleteCandidate(candidateList);
                sendCandidateListToJson(candidateList);
            }else if (option==4){
                displayCandidates(candidateList);
                sendCandidateListToJson(candidateList);
            }else if(option==0){
                System.out.println("Bye Bye");
                break;
            }else {
                System.out.println("Enter a valid number");
                continue;
            }
        }
    }

    public static boolean signIn(ArrayList<Candidate> candidateList){
        System.out.println("\n\n\nCandidate SignIn");
        while (true){
            System.out.println("Please Enter Your NationalId:(0 to quit)\n");
            String nationalId = console.next();
            if (nationalId.equals("0")){
                System.out.println("Bye BYe");
                break;
            }
            System.out.println("\nPlease Enter Your Password:(0 to quit)\n");
            String password = console.next();
            if (password.equals("0")){
                System.out.println("Bye BYe");
                break;
            }
            var account = candidateList.stream()
                    .filter(candidate -> candidate.getNationalID()==nationalId).findFirst();
            if (account.isEmpty()){
                System.out.println("This email not exist");
            }else{
                if (account.get().getPassword().equals(password)){
                    System.out.println("Succeed");
                    return true;
                }else {
                    System.out.println("Wrong password");
                }
            }
        }
        return false;
    }
    public static void addCandidate(ArrayList<Candidate> candidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the national id:");
        String nationalID = input.nextLine();
        System.out.println("Enter Candidate Name:");
        String name = input.nextLine();
        System.out.println("Enter the email:");
        String email = input.nextLine();
        System.out.println("Enter the mobile number:");
        String mobileNumber = input.nextLine();
        System.out.println("Enter the password:");
        String password = input.nextLine();
        System.out.println("Enter the address:");
        String address = input.nextLine();
        System.out.println("Enter the candidate's group:");
        String group = input.nextLine();
        System.out.println("Enter the zone:");
        String zone = input.nextLine();
        Candidate newCandidate = new Candidate(nationalID, name, email, mobileNumber, password, address, group, zone);
        candidateList.add(newCandidate);
        input.close();
    }

    public static void displayCandidates(ArrayList<Candidate> candidateArrayList) {
        for (Candidate candidate : candidateArrayList) {
            System.out.println(candidate);
        }
    }

    public static void deleteCandidate(ArrayList<Candidate> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the ID");
        String id = input.nextLine();
        list.removeIf(x -> x.getNationalID().equals(id));
        input.close();
    }

    public static void editCandidate(ArrayList<Candidate> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the national ID:");
        String id = input.nextLine();
        System.out.println("What do you want to change ?\n1-Email\n2-Mobile Number\n3-password\n4-address\n5-group\n6-zone");
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
            case 4:
                System.out.println("Enter the new address:");
                String newAddress = input.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setAddress(newAddress));
                break;
            case 5:
                System.out.println("Enter the new group:"); //in case if the group was entered wrongly
                String newGroup = input.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setGroup(newGroup));
                break;
            case 6:
                System.out.println("Enter the new zone:"); //in case if the zone was entered wrongly
                String newZone = input.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setZone(newZone));
        }
        input.close();
    }

    public static void sendCandidateListToJson(ArrayList<Candidate> candidates) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("candidates.json"));
        writer.write("{");
            writer.write("\"Candidate\":[");
            for (int i = 0; i < candidates.size(); i++) {
           
                writer.write("{");
            
            writer.write("\n \"ID\": \"" + candidates.get(i).getNationalID() + "\" \n");
    
            writer.write(", \"Name\": \"" + candidates.get(i).getName() + "\"\n");
        
            writer.write(", \"Email\": \"" + candidates.get(i).getEmail() + "\" \n");
         
            writer.write(", \"Mobile Number\": \"" + candidates.get(i).getMobileNumber() + "\" \n");
          
            writer.write(", \"password\": \"" + candidates.get(i).getPassword() + "\"\n");
       
            writer.write(", \"address\": \"" + candidates.get(i).getAddress() + "\"\n");
         
            writer.write(", \"group\": \"" + candidates.get(i).getGroup() + "\"\n");
           
            writer.write(", \"zone\": \"" + candidates.get(i).getZone() + "\"\n");
           
            writer.write(", \"Is Valid\": \"" + candidates.get(i).isValid() + "\"\n");
            writer.write("}");
            if (i != candidates.size() - 1) {
                writer.write(",");
            }
        }
    
    
        writer.write("]}");
        writer.close();
    }
    
    public static void readCandidateListFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("candidates.json"));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        reader.close();
    }
    
}




