package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import method.AdminFunction;
import method.AdminJson;
import method.CandidateFunction;
import method.VoterFunction;
import models.Admin;

public class MainTerminal {

    public static void loginTerminal() throws IOException, ParseException, java.text.ParseException{
        Scanner io= new Scanner(System.in);
        System.out.println("Welcome to the Open Voting System"+
        "\nPlease go ahead and choose your role: "+
        "\n1- Voter"+
        "\n2- Admin"
        );
        String role= io.nextLine();
        String input="1";
        while(!input.equals("0")){

            String id, password;
            switch (role) {
                case "1":
                    System.out.println("Enter your ID: ");
                    id=io.nextLine();
                    System.out.println("Enter your Password: ");
                    password= io.nextLine();
                    break;
                case "2":
    
                    System.out.println("Enter your ID: ");
                    id=io.nextLine();
                    System.out.println("Enter your Password: ");
                    password= io.nextLine();
                    ArrayList<Admin> adminList = AdminJson.readAllAdminFromJson();
                    if(adminList!=null){
                        boolean found=false;
                        for (Admin admin : adminList) {
                          if( admin.getNationalId().equals(id)&&admin.getPassword().equals(password)){
                          found= true;
                          System.out.println("Welcome: " + admin.getFullname());
                        }
                        if(found){
                            adminMainTerminal();
                        
                        }else{
                            System.out.println("Incorrect Id or Password!");
                        }
                    }
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Press 0 to exit or any other key to continue");
            input= io.nextLine();
        }
    }

    public static void adminMainTerminal() throws IOException, ParseException, java.text.ParseException{
        Scanner io= new Scanner(System.in);
        System.out.println("Open Voting System"+
        "\n1- Voter section."+
        "\n2- Candidate section."+
        "\n3- Admin section."+
        "\n4- Logout."
        );

        String section= io.nextLine();

        switch (section) {
            case "1":
                VoterFunction voterFunction= new VoterFunction();
                voterFunction.voterTerminal();
                break;
            case "2":
                CandidateFunction candidateFunction = new CandidateFunction();
                candidateFunction.candidateTerminal();
                break;
            case "3":
                AdminFunction adminFunction = new AdminFunction();
                adminFunction.adminTerminal();
                break;
            case "4":
                loginTerminal();
                break;
        
            default:
                break;
        }
    }


    public static void voterMainTerminal(){

    }
}
