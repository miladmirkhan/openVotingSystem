package method;

import models.Voter;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.MainTerminal;

public class VoterFunction{

    public void addVoter() throws IOException, ParseException, org.json.simple.parser.ParseException {
        Scanner io = new Scanner(System.in);
        System.out.println("Enter the national id:");
        String id = io.nextLine();
        System.out.println("Enter Voter Name:");
        String name = io.nextLine();
        System.out.println("Enter the email:");
        String email = io.nextLine();
        System.out.println("Enter the mobile number:");
        String mobileNumber = io.nextLine();
        System.out.println("Enter the password:");
        String password = io.nextLine();
        System.out.println("Enter the address:");
        String address = io.nextLine();
        System.out.println("Enter the voter's age:");
        String age = io.nextLine();
        System.out.println("Enter the zone:");
        String zone = io.nextLine();
        Voter newVoter = new Voter(name,age,email,mobileNumber,password, address,zone, id); 
        ArrayList<Voter> voterList = VoterJson.readAllVoterFromJson();
        if(voterList== null) voterList=new ArrayList<Voter>();
        voterList.add(newVoter);
        VoterJson.sendVoterListToJson(voterList);
        System.out.println("Voter added successfully");

        System.out.println("Press 0 to exit or any key to continue");
         String cont= io.nextLine();
        if(cont.equals("0")){
        System.exit(0);
        }else{
        voterTerminal();
        }
    }

    public void displayAllVoter() throws IOException, ParseException, org.json.simple.parser.ParseException{
        ArrayList<Voter> voterList= VoterJson.readAllVoterFromJson();
        if(voterList !=null){
          for(Voter voter:voterList){
            String id= voter.getNationalID();
            String name= voter.getFullName();
            String age= voter.getAge();
            String zone= voter.getZone();
            String address= voter.getAddress();
            String Email= voter.getEmail();
            String MobileNumber= voter.getMobileNumber();
            String Password= voter.getPassword();
            
            System.out.println(
            "ID: "+id+
            "\nName: " +name+
            "\nAge: " +age+
            "\nZone: " +zone+
            "\nAddress: " +address+
            "\nEmail: "+Email+
            "\nMobile Number: "+MobileNumber+
            "\nPassword: "+Password+
            "\n");
          }
        } else{
          System.out.println("There is not any Voter");
        }
        Scanner io= new Scanner(System.in);
        System.out.println("Press 0 to exit or any key to continue");
        String cont= io.nextLine();
        if(cont.equals("0")){
          System.exit(0);
        }else{
          voterTerminal();
        }
      
      }

    public void displayOneVoter() throws IOException, ParseException, org.json.simple.parser.ParseException{
        ArrayList<Voter> voterList= VoterJson.readAllVoterFromJson();
        Scanner io=new Scanner(System.in);
        if (voterList!=null){
          System.out.println("Enter id of the Voter you want to see: ");
          String id=io.nextLine();
          
          for(Voter voter:voterList){
            if(voter.getNationalID().equals(id)){
                String ID= voter.getNationalID();
                String name= voter.getFullName();
                String age= voter.getAge();
                String zone= voter.getZone();
                String address= voter.getAddress();
                String Email= voter.getEmail();
                String MobileNumber= voter.getMobileNumber();
                String Password= voter.getPassword();
                
                System.out.println(
                "ID: "+ID+
                "\nName: " +name+
                "\nAge: " +age+
                "\nZone: " +zone+
                "\nAddress: " +address+
                "\nEmail: "+Email+
                "\nMobile Number: "+MobileNumber+
                "\nPassword: "+Password+
                "\n");
            }else{
              System.out.println("This Voter doesn't exist");
            }
          }
        }else{
          System.err.println("There is not any Voter\n");
        }
        System.out.println("Press 0 to exit or any key to continue");
        String cont= io.nextLine();
        if(cont.equals("0")){
          System.exit(0);
        }else{
          voterTerminal();
        }
      }  

      public void editVoter() throws IOException, ParseException, org.json.simple.parser.ParseException{
        ArrayList<Voter> voterList = VoterJson.readAllVoterFromJson();
        Scanner io=new Scanner(System.in);
        if(voterList!=null){
          System.out.println("Enter the national-ID that you want to edit: ");
          String id=io.nextLine();
          boolean found=false;
          for (Voter voter : voterList) {
              if( voter.getNationalID().equals(id)){
                found= true;
              }
          }
          if(found){
            System.out.println("What do you want to change ?"+
            "\n1-Name"+
            "\n2-age"+
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
              voterList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setFullName(newName));
              break;
    
              case "2":
              System.out.println("Enter the new age:");
              String newAge=io.next();
              voterList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setAge(newAge));
              break;
    
              case "3":
              System.out.println("Enter the new zone :");
              String newZone=io.nextLine();
              voterList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setZone(newZone));
              break;

              case "4":
              System.out.println("Enter the new address :");
              String newAddress=io.nextLine();
              voterList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setAddress(newAddress));
              break;

              case "5":
              System.out.println("Enter the new Email :");
              String newEmail=io.nextLine();
              voterList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setEmail(newEmail));
              break;

              case "6":
              System.out.println("Enter the new Mobile Number :");
              String newMobileNumber=io.nextLine();
              voterList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setMobileNumber(newMobileNumber));
              break;

              case "7":
              System.out.println("Enter the new password :");
              String newPassord=io.nextLine();
              voterList.stream().filter(x->x.getNationalID().equals(id)).forEach(x->x.setPassword(newPassord));
              break;
            }
            System.out.println("Voter Successfully updated");
            VoterJson.sendVoterListToJson(voterList);
          }else{
            System.out.println("There is not a Voter with such id");
          }
    
        } else{
          System.out.println("There is not any Voter");
        }
        System.out.println("Press 0 to exit or any key to continue");
        String cont= io.nextLine();
        if(cont.equals("0")){
          System.exit(0);
        }else{
          voterTerminal();
        }
        
      }


    public void removeVoter() throws IOException, ParseException, org.json.simple.parser.ParseException{
        ArrayList<Voter> voterList= VoterJson.readAllVoterFromJson();
        Scanner io=new Scanner(System.in);
        if(voterList!=null){
          System.out.println("Enter the national-ID that you want to remove: ");
          String id=io.nextLine();
          if(voterList.removeIf(x -> x.getNationalID().equals(id))){
            VoterJson.sendVoterListToJson(voterList);
            System.out.println("Voter Successfully Deleted");
          } else{
            System.out.println("We couldn't find a Voter whith such id");
          }
    
        }else{
          System.out.println("There is not any Voter");
        }
        System.out.println("Press 0 to exit or any key to continue");
        String cont= io.nextLine();
        if(cont.equals("0")){
          System.exit(0);
        }else{
          voterTerminal();
        }
      }


public void voterTerminal() throws IOException, ParseException, org.json.simple.parser.ParseException{
    Scanner io=new Scanner(System.in);
    
    String inputKey="Start";
    while (inputKey!="0") {
        System.out.println("Please Choose a number:"+
        "\n1. Display voters."+
        "\n2. Display one voter"+
        "\n3. Add voter."+
        "\n4. Edit voter."+
        "\n5. delete voter."+
        "\n6. go back"
        );
      inputKey=io.nextLine();
      switch (inputKey) {
        case "1":
        this.displayAllVoter();
        break;

        case "2":
        this.displayOneVoter();
        break;

        case "3":
        this.addVoter();
  
        break;
        case "4":
        this.editVoter();
  
        break;
        case "5":
        this.removeVoter();
        break;

        case "6":
        MainTerminal.adminMainTerminal();
        break;
      
        case "0":
        System.exit(0);
        break;
      }
    }
  }

}