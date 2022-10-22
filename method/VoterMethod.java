package method;

import java.util.ArrayList;

public class VoterMethod<Voter> {

// add 
public void addVoter(ArrayList<Voter> list,Voter voter){

    list.add(voter);
}
// edit
public void editVoter(ArrayList<Voter> list,int index,Voter voter){
    list.set(index, voter);
}

public void editVoter(ArrayList<Voter> list,Voter voter,Voter newVoter){

    int index = list.indexOf(voter);
    list.set(index, newVoter);
}



}
