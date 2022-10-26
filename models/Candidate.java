public class Candidate {

    private String nationalID,name, email, mobileNumber, password, address, group,zone;
    private boolean isValid;
    
    public Candidate(String id, String name, String email, String mobileNumber,
                     String password, String address, String group,boolean isValid,String zone) {
        this.nationalID = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.address = address;
        this.group = group;
        this.isValid=isValid;
        this.zone=zone;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
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
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getZone(){
        return zone;
    }
    public void setZone(String zone){
        this.zone=zone;
    }


   @Override
    public String toString() {
        return "Candidate{" +
                "nationalID='" + nationalID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", group='" + group + '\'' +
                ", zone='" + zone + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}

