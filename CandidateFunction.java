import java.util.*;
public class CandidateFunction {
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
    }
}




