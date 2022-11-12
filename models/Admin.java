package method;

import models.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;


public class AdminFunction{

  AdminJson adminJson;

  ArrayList<Admin> adminList;

  public AdminFunction(ArrayList<Admin> adminList){

    this.adminList=adminList;
  }

  public void addAdmin() throws IOException, ParseException{
    Scanner io=new Scanner(System.in);
    System.out.println("Please enter your name: ");
    String name= io.nextLine();
    System.out.println("Please enter your national-ID: ");
    String nationalId=io.nextLine();
    System.out.println("Please enter your email: ");
    String email=io.nextLine();
    System.out.println("Please enter your phone number: ");
    String phoneNo=io.nextLine();
    System.out.println("please set a password: ");
    String password=io.nextLine();
    Admin newAdmin=new Admin(name,nationalId,email,password,phoneNo);
    ArrayList<Admin> adminList= AdminJson.readAllAdminFromJson();
    adminList.add(newAdmin);
    AdminJson.sendAdminListToJson(adminList);
    System.out.println("Admin added successfully");

    adminTerminal();

  }

  public void displayAllAdmin() throws IOException, ParseException{
    ArrayList<Admin> adminList= AdminJson.readAllAdminFromJson();
    if(adminList !=null){
      for(Admin admin:adminList){
        String ID= admin.getNationalId();
        String Name= admin.getFullname();
        String Email= admin.getEmail();
        String MobileNumber= admin.getPhoneNo();
        String Password= admin.getPassword();

        System.out.println("ID: "+ID+"\nName: "
            +Name+"\nEmail: "+Email+"\nMobile Number: "
            +MobileNumber+"\nPassword: "+Password+"\n");
      }
    } else if(adminList==null){
      System.out.println("There is not any admin");
    }
    System.out.println("Press 0 to continue or 6 to exit");
    Scanner io= new Scanner(System.in);
    int cont= io.nextInt();
    if(cont==0){
      adminTerminal();
    }else if(cont==6){
      System.exit(0);
    }

  }

  public void displayOneAdmin() throws IOException, ParseException{
    ArrayList<Admin> adminList= AdminJson.readAllAdminFromJson();
    Scanner io=new Scanner(System.in);
    if (adminList==null){
      System.err.println("There is not any admin\n");
      System.out.println("Press 0 to continue or 6 to exit");
    int cont= io.nextInt();
    if(cont==0){
      adminTerminal();
    }else if(cont==6){
      System.exit(0);
    }
    }

    System.out.println("Enter id of the admin you want to see: ");
    String id=io.nextLine();

    for(Admin admin:adminList){
      if(admin.getNationalId().equals(id)){
          String ID= admin.getNationalId();
          String Name= admin.getFullname();
          String Email= admin.getEmail();
          String MobileNumber= admin.getPhoneNo();
          String Password= admin.getPassword();

          System.out.println("ID: "+ID+"\nName: "
          +Name+"\nEmail: "+Email+"\nMobile Number: "
          +MobileNumber+"\nPassword: "+Password);
      }else{
        System.out.println("This admin doesn't exist");
      }
    }
    System.out.println("Press 0 to continue or 6 to exit");
    int cont= io.nextInt();
    if(cont==0){
      adminTerminal();
    }else if(cont==6){
      System.exit(0);
    }
  }

  public void removeAdmin(ArrayList<Admin> list) throws IOException, ParseException{
    Scanner io=new Scanner(System.in);
    if(list==null){
      System.out.println("There is not any admin");

      adminTerminal();
    }
    System.out.println("Enter the national-ID that you want to remove: ");
    String id=io.nextLine();
    if(list.removeIf(x->x.getNationalId().equals(id))){

      System.out.println("admin Successfully Deleted");

    } else{

      System.out.println("We couldn't an admin whith such id");
    }
    adminTerminal();
  }


  public void editAdmin(ArrayList<Admin> list) throws IOException, ParseException{
    Scanner io=new Scanner(System.in);
    if(list==null){
      System.out.println("There is not any admin");

      adminTerminal();
    }
    System.out.println("Enter the national-ID that you want to edit: ");
    String id=io.nextLine();

    boolean found=false;
    for (Admin admin1 : list) {
      if( admin1.getNationalId().equals(id)){
        found= true;
        System.out.println("We found the admin1");
      }
    }
    if(!found){
      System.out.println("There is not an admin with such id");

      adminTerminal();
    }


    System.out.println("What do you want to change ?\n1-Email\n2-Mobile Number\n3-password");
    int option=io.nextInt();
    switch(option){
      case 1:
      System.out.println("Enter the new Email:");
      String newEmail=io.next();
      list.stream().filter(x->x.getNationalId().equals(id)).forEach(x->x.setEmail(newEmail));

      break;
      case 2:
      System.out.println("Enter the new mobile number:");
      String newMobileNumber=io.next();
      list.stream().filter(x->x.getNationalId().equals(id)).forEach(x->x.setPhoneNo(newMobileNumber));

      break;
      case 3:
      System.out.println("Enter the new password :");
      String newPassword=io.next();
      list.stream().filter(x->x.getNationalId().equals(id)).forEach(x->x.setPassword(newPassword));

      break;
    }
  }

  public void adminTerminal() throws IOException, ParseException{
    Scanner io=new Scanner(System.in);
    System.out.println("Please Choose a number:"+
    "\n1. Display admins."+
    "\n2. Display one admin"+
    "\n3. Add admin."+
    "\n4. Edit admin."+
    "\n5. delete admin."+
    "\n6. go back"
    );

    int inputKey=0;
    while (inputKey!=6) {
      inputKey=io.nextInt();
      switch (inputKey) {
        case 1:
        this.displayAllAdmin();
        break;

        case 2:
        this.displayOneAdmin();
        break;

        case 3:
        this.addAdmin();

        break;
        case 4:
        this.editAdmin(adminList);

        break;
        case 5:
        this.removeAdmin(adminList);
          break;

        default:
          break;
      }
    }
  }

  public static void sendAdminListToJson(ArrayList<Admin> adminList) throws IOException{
    BufferedWriter writer = new BufferedWriter(new FileWriter("admins.json"));
    writer.write("{");
    writer.write("\"Admin\":[");
            for (int i = 0; i < adminList.size(); i++) {

                writer.write("{");

                writer.write("\n \"ID\": \"" + adminList.get(i).getNationalId() + "\" \n");

                writer.write(", \"Name\": \"" + adminList.get(i).getFullname() + "\"\n");

                writer.write(", \"Email\": \"" + adminList.get(i).getEmail() + "\" \n");

                writer.write(", \"Mobile Number\": \"" + adminList.get(i).getPhoneNo() + "\" \n");

                writer.write(", \"password\": \"" + adminList.get(i).getPassword() + "\"\n");           
                writer.write("}");
                    if (i != adminList.size() - 1) {
                        writer.write(",");
                    }
          }
          writer.write("]}");
          writer.close();
        }

public static ArrayList<Admin> readAllAdminFromJson() throws IOException, ParseException{
    JSONParser parser= new JSONParser();
    FileReader reader = new FileReader("admins.json");

    ArrayList<Admin> adminList=new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(reader);

    if (bufferedReader.readLine() != null){

    reader = new FileReader("admins.json");
    JSONObject objects = (JSONObject) parser.parse(reader);
    JSONArray array = (JSONArray) objects.get("Admin");    

    for(int i=0; i<array.size(); i++){
        JSONObject admins = (JSONObject) array.get(i);

        String ID = (String) admins.get("ID");
        String Name = (String) admins.get("Name");
        String Email = (String) admins.get("Email");
        String MobileNumber = (String) admins.get("Mobile Number");
        String Password = (String) admins.get("password");

        Admin newAdmin=new Admin(Name,ID,Email,Password,MobileNumber);
        adminList.add(newAdmin);
    }
    reader.close();
    return adminList;
    }else{
        bufferedReader.close();
        return adminList;
    }
}
}