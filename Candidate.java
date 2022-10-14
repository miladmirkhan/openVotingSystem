public class Candidate {
    private int nationalID;
    private String name, email, mobileNumber, password, address, group;


    public Candidate(int id, String name, String email, String mobileNumber, String password, String address, String group) {
        this.nationalID = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.address = address;
        this.group = group;
    }

    public int getNationalID() {
        return nationalID;
    }

    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public boolean isEligible(int age){
        if(age>=18){
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "nationalID=" + nationalID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
