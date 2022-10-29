package method;

import models.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdminFunction{
  Scanner io=new Scanner(System.in);
  public void addAdmin(ArrayList<Admin> adminList){
    System.out.println("Please enter your name: ");
    String fullname=io.nextLine();
    System.out.println("Please enter your national-ID: ");
    String nationalId=io.nextLine();
    System.out.println("Please enter your email: ");
    String email=io.nextLine();
    System.out.println("Please enter your phone number: ");
    String phoneNo=io.nextLine();
    System.out.println("please set a password: ");
    String password=io.nextLine();
    Admin newAdmin=new Admin(fullname,nationalId,email,password,phoneNo);
    adminList.add(newAdmin);
    
  }
  public void displayAdmin(ArrayList<Admin> adminList){
    for(Admin admin:adminList){
      System.out.println(admin);
    }
  }

  public void removeAdmin(ArrayList<Admin> list){
    System.out.println("Enter the national-ID that you want to remove: ");
    String id=io.nextLine();
    list.removeIf(x->x.getNationalId().equals(id));
  }

  public void editAdmin(ArrayList<Admin> list){
    System.out.println("Enter the national-ID that you want to edit: ");
    String id=io.nextLine();
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

  @SuppressWarnings("unchecked")
  public List<Admin> openAdminList() {
    List<Admin> list = new ArrayList<>();
    try {
      FileInputStream file = new FileInputStream("files/admin.txt");
      ObjectInputStream get = new ObjectInputStream(file);
      list = (List<Admin>) get.readObject();

      file.close();
      get.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found ");
    } catch (IOException e) {
      System.out.println("Error initializing stream");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return list;
  }

  public boolean saveAdminListToFile(List<Admin> items){
    try{
      FileOutputStream f = new FileOutputStream("files/admin.txt");
      ObjectOutputStream o = new ObjectOutputStream(f);
      o.writeObject(items);
      o.close();
      f.close();
      System.out.println("done");

    } catch (FileNotFoundException e){
      System.out.println("File not found Exception.");
      return false;
    } catch (IOException e){
      System.out.println("Error initializing stream. "+e.getMessage());
      return false;
    }
    return true;
  }

}