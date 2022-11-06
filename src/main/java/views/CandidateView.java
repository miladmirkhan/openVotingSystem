package views;

public class CandidateView {
    public void printCandidateDetails(String nationalID, String name, String email,String mobileNumber,String password,String address, String group, String zone, boolean valid ){
        System.out.println("Candidate:");
        System.out.println("National ID"+nationalID);
        System.out.println("Name:"+name);
        System.out.println("Email:"+email);
        System.out.println("Mobile Number:"+mobileNumber);
        System.out.println("Password:"+password);
        System.out.println("Address:"+address);
        System.out.println("Group:"+group);
        System.out.println("Zone:"+zone);
        System.out.println("isValid:"+valid);
    }
}
