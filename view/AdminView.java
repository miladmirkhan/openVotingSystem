package view;

public class AdminView {
    public void printAdminDetails(String fullname,String nationalID, String email, String password, String phoneNo){
        System.out.println("Admin:");
        System.out.println("National-ID: "+nationalID);
        System.out.println("Fullname: "+fullname);
        System.out.println("Email: "+email);
        System.out.println("Phone Number: "+ phoneNo);
        System.out.println("Password: "+password);
    }
}
