package method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import models.Admin;

public class AdminJson {
    
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
