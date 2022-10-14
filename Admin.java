public class Admin{
  private String fullname, id, accessLevel, email, password, phoneNo;

  public Admin(String fullname, String id, String accessLevel, String email, String password, String phoneNo){
    this.fullname=fullname;
    this.id=id;
    this.accessLevel=accessLevel;
    this.email=email;
    this.password=password;
    this.phoneNo=phoneNo;
  }
  
  public String getFullname(){
    return fullname;
  }
  
  public String getId(){
    return id;
  }

  public String getAccessLevel(){
    return accessLevel;
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

  public void setId(String id){
    this.id=id;
  }

  public void setAccessLevel(String accessLevel){
    this.accessLevel=accessLevel;
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

  public String toString(){
    return "Admin{Fullname= "+fullname
    + "\nNationalID= "+ id
    +"\nAccessLevel= "+ accessLevel
    +"\nEmail= "+email
    +"\nPassword= "+password
    +"\nPhoneNo= "+phoneNo
    + "}";
    
  }
}