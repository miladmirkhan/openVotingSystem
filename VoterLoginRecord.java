public record VoterLoginRecord(int nationalId, String email, String password) {
    public VoterLoginRecord(String email, String password) {
        this(0, email, password);
    }

    public VoterLoginRecord(int nationalId) {
        this(nationalId, null, null);
    }

    public boolean login(){
        if (nationalId==0){
            //this should login with email and pass
        }else{
            //login with national id
        }
        return false;
    }


}

