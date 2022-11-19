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

import models.Candidate;

public class CandidateJson {
    
    public static void sendcandidateListToJson(ArrayList<Candidate> candidates) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("data/candidates.json"));
        writer.write("{");
        writer.write("\"Candidate\":[");
            for (int i = 0; i < candidates.size(); i++) {
           
            writer.write("{");
            
            writer.write("\n \"ID\": \"" + candidates.get(i).getNationalID() + "\" \n");
    
            writer.write(", \"Name\": \"" + candidates.get(i).getName() + "\"\n");
        
            writer.write(", \"Email\": \"" + candidates.get(i).getEmail() + "\" \n");
         
            writer.write(", \"Mobile Number\": \"" + candidates.get(i).getMobileNumber() + "\" \n");
          
            writer.write(", \"password\": \"" + candidates.get(i).getPassword() + "\"\n");
       
            writer.write(", \"address\": \"" + candidates.get(i).getAddress() + "\"\n");
         
            writer.write(", \"group\": \"" + candidates.get(i).getGroup() + "\"\n");
           
            writer.write(", \"zone\": \"" + candidates.get(i).getZone() + "\"\n");
           
            writer.write(", \"Is Valid\": \"" + candidates.get(i).isValid() + "\"\n");
            writer.write("}");
            if (i != candidates.size() - 1) {
                writer.write(",");
            }
        }
    
        writer.write("]}");
        writer.close();
        }

    public static ArrayList<Candidate> readAllCandidateFromJson() throws IOException, ParseException{
        JSONParser parser= new JSONParser();
        FileReader reader = new FileReader("data/candidates.json");
        
        ArrayList<Candidate> candidateList=new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        
        if (bufferedReader.readLine() != null){

        reader = new FileReader("data/candidates.json");
        JSONObject objects = (JSONObject) parser.parse(reader);
        JSONArray array = (JSONArray) objects.get("Candidate");    
            
        for(int i=0; i<array.size(); i++){
            JSONObject candidates = (JSONObject) array.get(i);
            
            String ID = (String) candidates.get("ID");
            String Name = (String) candidates.get("Name");
            String Email = (String) candidates.get("Email");
            String MobileNumber = (String) candidates.get("Mobile Number");
            String Password = (String) candidates.get("password");
            String address = (String) candidates.get("address");
            String group = (String) candidates.get("group");
            String zone = (String) candidates.get("zone");
            String isValid = (String) candidates.get("Is Valid");
            
            Candidate newCandidate=new Candidate(ID,Name,Email,MobileNumber,Password, address,group, zone);
            candidateList.add(newCandidate);
        }
        reader.close();
        return candidateList;
        }else{
            bufferedReader.close();
            return candidateList=null;
        }
}
}
