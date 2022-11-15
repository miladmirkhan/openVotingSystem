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

import models.Voter;

public class VoterJson {
    
    public static void sendVoterListToJson(ArrayList<Voter> voters) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("voters.json"));
        writer.write("{");
        writer.write("\"Voter\":[");
        for (int i = 0; i < voters.size(); i++) {
       
         writer.write("{");
        
        writer.write(", \"id\": \"" + voters.get(i).getNationalID() + "\" \n");
        
        writer.write("\n \"name\": \"" + voters.get(i).getFullName() + "\" \n");

        writer.write(", \"age\": \"" + voters.get(i).getAge() + "\"\n");
     
        writer.write(", \"email\": \"" + voters.get(i).getEmail() + "\" \n");
      
        writer.write(", \"mobileNumber\": \"" + voters.get(i).getMobileNumber() + "\"\n");
   
        writer.write(", \"password\": \"" + voters.get(i).getPassword() + "\"\n");
     
        writer.write(", \"address\": \"" + voters.get(i).getAddress() + "\"\n");
       
        writer.write(", \"zone\": \"" + voters.get(i).getZone() + "\"\n");
       
        writer.write(", \"vote\": \"" + voters.get(i).getVote() + "\"\n");
        writer.write("}");
        if (i != voters.size() - 1) {
            writer.write(",");
        }
    }

    writer.write("]}");
    writer.close();
}

    public static ArrayList<Voter> readAllVoterFromJson() throws IOException, ParseException{
        JSONParser parser= new JSONParser();
        FileReader reader = new FileReader("voters.json");
        
        ArrayList<Voter> voterList=new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        
        if (bufferedReader.readLine() != null){

        reader = new FileReader("voters.json");
        JSONObject objects = (JSONObject) parser.parse(reader);
        JSONArray array = (JSONArray) objects.get("Voter");    
            
        for(int i=0; i<array.size(); i++){
            JSONObject voters = (JSONObject) array.get(i);
            
            String id = (String) voters.get("id");
            String name = (String) voters.get("name");
            String email = (String) voters.get("email");
            String age = (String) voters.get("age");
            String password = (String) voters.get("password");
            String address = (String) voters.get("address");
            String mobileNumber = (String) voters.get("mobileNumber");
            String zone = (String) voters.get("zone");
            // String vote = (String) voters.get("vote");
            
            Voter newVoter=new Voter(name,age,email,mobileNumber,password, address,zone, id);
            voterList.add(newVoter);
        }
        reader.close();
        return voterList;
        }else{
            bufferedReader.close();
            return voterList=null;
        }
}
}
