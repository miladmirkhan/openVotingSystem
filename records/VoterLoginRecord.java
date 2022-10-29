package records;

public record VoterLoginRecord(int nationalId, String email, String password) {
    public VoterLoginRecord(String email, String password) {
        this(0, email, password);
    }

    public VoterLoginRecord(int nationalId) {
        this(nationalId, null, null);
    }

    public void login(){
        if (nationalId==0){
            // login with national id
        }else{
            // login with email and password
        }
    }


}