public class Admin{
    private String fullname, nationalId, email, password, phoneNo;

    public String getFullname(){
        return fullname;
    }

    public String getNationalId(){
        return nationalId;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public void setFullname(String fullname){
        this.fullname=fullname;
    }

    public void setNationalId(String nationalId){
        this.nationalId=nationalId;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }

}
