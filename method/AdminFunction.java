import java.util.*;


public class AdminFunction{
  Scanner io=new Scanner(System.in);
  public Admin add(){
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
    return newAdmin;
  }
  public void printAdmin(ArrayList a){
    System.out.println(a);
  }

  public void remove(ArrayList<Admin> list){
    System.out.println("Enter the national-ID that you want to remove: ");
    String id=io.nextLine();
    list.removeIf(x->x.getId().equals(id));
  }

  public void edit(ArrayList<Admin> list){
    System.out.println("Enter your national-ID: ");
    String id= io.nextLine();;
    System.out.println("What to change\n1- Email\n2- Phone Number\n3- Password");
    int change=io.nextInt();
    switch (change){
      case 1:
        System.out.println("Enter the new Email: ");
        String email= io.next();
        list.stream().filter(x -> x.getId().equals(id)).forEach(x -> x.setEmail(email));
        break;
      case 2:
        System.out.println("Enter the new Phone Number: ");
        String phoneNo= io.next();
        list.stream().filter(x->x.getId().equals(id)).forEach(x->x.setPhoneNo(phoneNo));
        break;
      case 3:
        System.out.println("Enter the new Password: ");
        String password= io.next();
        list.stream().filter(x->x.getId().equals(id)).forEach(x->x.setPassword(password));
        break;
    }
  }
}