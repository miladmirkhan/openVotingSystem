package method;

import models.Candidate;
import java.io.IOException;
import java.util.*;

import org.json.simple.parser.ParseException;
public class CandidateFunction {

    public void addCandidate() throws IOException, ParseException {
        Scanner io = new Scanner(System.in);
        System.out.println("Enter the national id:");
        String nationalID = io.nextLine();
        System.out.println("Enter Candidate Name:");
        String name = io.nextLine();
        System.out.println("Enter the email:");
        String email = io.nextLine();
        System.out.println("Enter the mobile number:");
        String mobileNumber = io.nextLine();
        System.out.println("Enter the password:");
        String password = io.nextLine();
        System.out.println("Enter the address:");
        String address = io.nextLine();
        System.out.println("Enter the candidate's group:");
        String group = io.nextLine();
        System.out.println("Enter the zone:");
        String zone = io.nextLine();
        Candidate newCandidate = new Candidate(nationalID, name, email
        , mobileNumber, password, address, group, zone); 
        ArrayList<Candidate> candidateList = CandidateJson.readAllCandidateFromJson();
        if(candidateList== null) candidateList=new ArrayList<Candidate>();
        candidateList.add(newCandidate);
        CandidateJson.sendcandidateListToJson(candidateList);
        System.out.println("Candidate added successfully");

        System.out.println("Press 0 to exit or any key to continue");
         String cont= io.nextLine();
        if(cont.equals("0")){
        System.exit(0);
        }else{
        candidateTerminal();
        }
    }

    public void displayAllCandidate() throws IOException, ParseException{
        ArrayList<Candidate> candidateList= CandidateJson.readAllCandidateFromJson();
        if(candidateList !=null){
          for(Candidate candidate:candidateList){
            String ID= candidate.getNationalID();
            String Name= candidate.getName();
            String group= candidate.getGroup();
            String zone= candidate.getZone();
            String address= candidate.getAddress();
            String Email= candidate.getEmail();
            String MobileNumber= candidate.getMobileNumber();
            String Password= candidate.getPassword();
            
            System.out.println(
            "ID: "+ID+
            "\nName: " +Name+
            "\nGroup: " +group+
            "\nZone: " +zone+
            "\nAddress: " +address+
            "\nEmail: "+Email+
            "\nMobile Number: "+MobileNumber+
            "\nPassword: "+Password+
            "\n");
          }
        } else{
          System.out.println("There is not any candidate");
        }
        Scanner io= new Scanner(System.in);
        System.out.println("Press 0 to exit or any key to continue");
        String cont= io.nextLine();
        if(cont.equals("0")){
          System.exit(0);
        }else{
          candidateTerminal();
        }
      
      }

    public void displayOneCandidate() throws IOException, ParseException{
        ArrayList<Candidate> candidateList= CandidateJson.readAllCandidateFromJson();
        Scanner io=new Scanner(System.in);
        if (candidateList!=null){
          System.out.println("Enter id of the candidate you want to see: ");
          String id=io.nextLine();
          
          for(Candidate candidate:candidateList){
            if(candidate.getNationalID().equals(id)){
                String ID= candidate.getNationalID();
                String Name= candidate.getName();
                String group= candidate.getGroup();
                String zone= candidate.getZone();
                String address= candidate.getAddress();
                String Email= candidate.getEmail();
                String MobileNumber= candidate.getMobileNumber();
                String Password= candidate.getPassword();
                
                System.out.println(
                "ID: "+ID+
                "\nName: " +Name+
                "\nGroup: " +group+
                "\nZone: " +zone+
                "\nAddress: " +address+
                "\nEmail: "+Email+
                "\nMobile Number: "+MobileNumber+
                "\nPassword: "+Password+
                "\n");
            }else{
              System.out.println("This candidate doesn't exist");
            }
          }
        }else{
          System.err.println("There is not any candidate\n");
        }
        System.out.println("Press 0 to exit or any key to continue");
        String cont= io.nextLine();
        if(cont.equals("0")){
          System.exit(0);
        }else{
          candidateTerminal();
        }
      }  

      public void editCandidate() throws IOException, ParseException{
        ArrayList<Candidate> candidateList = CandidateJson.readAllCandidateFromJson();
        Scanner io=new Scanner(System.in);
        if(candidateList!=null){
          System.out.println("Enter the national-ID that you want to edit: ");
          String id=io.nextLine();
          boolean found=false;
          for (Candidate candidate : candidateList) {
              if( candidate.getNationalID().equals(id)){
                found= true;
              }
          }
          if(found){
            System.out.println("What do you want to change ?"+
            "\n1-Name"+
            "\n2-Group"+
            "\n3-Zone"+
            "\n4-Address"+
            "\n5-Email"+
            "\n6-Mobile Number"+
            "\n7-password"
            );
            String option=io.nextLine();
            switch(option){
              case "1":
              System.out.println("Enter the new Name:");
              String newName=io.nextLine();
              candidateList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setName(newName));
              break;
    
              case "2":
              System.out.println("Enter the new group:");
              String newGroup=io.next();
              candidateList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setGroup(newGroup));
              break;
    
              case "3":
              System.out.println("Enter the new zone :");
              String newZone=io.nextLine();
              candidateList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setZone(newZone));
              break;

              case "4":
              System.out.println("Enter the new address :");
              String newAddress=io.nextLine();
              candidateList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setAddress(newAddress));
              break;

              case "5":
              System.out.println("Enter the new Email :");
              String newEmail=io.nextLine();
              candidateList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setEmail(newEmail));
              break;

              case "6":
              System.out.println("Enter the new Mobile Number :");
              String newMobileNumber=io.nextLine();
              candidateList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setMobileNumber(newMobileNumber));
              break;

              case "7":
              System.out.println("Enter the new password :");
              String newPassord=io.nextLine();
              candidateList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setPassword(newPassord));
              break;
            }
            System.out.println("Candidate Successfully updated");
            CandidateJson.sendcandidateListToJson(candidateList);
          }else{
            System.out.println("There is not a candidate with such id");
          }
    
        } else{
          System.out.println("There is not any candidate");
        }
        System.out.println("Press 0 to exit or any key to continue");
        String cont= io.nextLine();
        if(cont.equals("0")){
          System.exit(0);
        }else{
          candidateTerminal();
        }
        
      }

    public static void deleteCandidate(ArrayList<Candidate> list) {
        Scanner io = new Scanner(System.in);
        System.out.println("enter the ID");
        String id = io.nextLine();
        list.removeIf(x -> x.getNationalID().equals(id));
        io.close();
    }

    public static void editCandidate(ArrayList<Candidate> list) {
        Scanner io = new Scanner(System.in);
        System.out.println("Enter the national ID:");
        String id = io.nextLine();
        System.out.println("What do you want to change ?\n1-Email\n2-Mobile Number\n3-password\n4-address\n5-group\n6-zone");
        int option = io.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the new Email:");
                String newEmail = io.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setEmail(newEmail));
                break;
            case 2:
                System.out.println("Enter the new mobile number:");
                String newMobileNumber = io.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setMobileNumber(newMobileNumber));
                break;
            case 3:
                System.out.println("Enter the new password :");
                String newPassword = io.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setPassword(newPassword));
                break;
            case 4:
                System.out.println("Enter the new address:");
                String newAddress = io.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setAddress(newAddress));
                break;
            case 5:
                System.out.println("Enter the new group:"); //in case if the group was entered wrongly
                String newGroup = io.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setGroup(newGroup));
                break;
            case 6:
                System.out.println("Enter the new zone:"); //in case if the zone was entered wrongly
                String newZone = io.next();
                list.stream().filter(x -> x.getNationalID().equals(id)).forEach(x -> x.setZone(newZone));
        }
        io.close();
    }

    public void removeCandidate() throws IOException, ParseException{
        ArrayList<Candidate> candidateList= CandidateJson.readAllCandidateFromJson();
        Scanner io=new Scanner(System.in);
        if(candidateList!=null){
          System.out.println("Enter the national-ID that you want to remove: ");
          String id=io.nextLine();
          if(candidateList.removeIf(x -> x.getNationalID().equals(id))){
            CandidateJson.sendcandidateListToJson(candidateList);
            System.out.println("candidate Successfully Deleted");
          } else{
            System.out.println("We couldn't find a candidate whith such id");
          }
    
        }else{
          System.out.println("There is not any candidate");
        }
        System.out.println("Press 0 to exit or any key to continue");
        String cont= io.nextLine();
        if(cont.equals("0")){
          System.exit(0);
        }else{
          candidateTerminal();
        }
      }


    public void candidateTerminal() throws IOException, ParseException{
        Scanner io=new Scanner(System.in);
        System.out.println("Please Choose a number:"+
        "\n1. Display candidates."+
        "\n2. Display one candidate"+
        "\n3. Add candidate."+
        "\n4. Edit candidate."+
        "\n5. delete candidate."+
        "\n6. go back"
        );
        
        String inputKey="Start";
        while (inputKey!="0") {
          inputKey=io.nextLine();
          switch (inputKey) {
            case "1":
            this.displayAllCandidate();
            break;
    
            case "2":
            this.displayOneCandidate();
            break;
    
            case "3":
            this.addCandidate();
      
            break;
            case "4":
            this.editCandidate();
      
            break;
            case "5":
            this.removeCandidate();
              break;
          
            default:
              break;
          }
        }
      }
    
    }




