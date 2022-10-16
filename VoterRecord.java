public record VoterRecord(int nationalID, String fullName,String email, String password, String mobileNumber) {
    public boolean signUp(){
        return false;
    }

    public boolean vote(){
        return false;
    }
}