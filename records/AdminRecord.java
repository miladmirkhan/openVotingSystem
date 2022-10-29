package records;

public record AdminRecord(int id, String fullName,
                          String email, String password, String phoneNumber)
{
    
    public AdminRecord(int id, String fullName,
                String password, String phoneNumber)
    {
        this(id, fullName, "undefined@gmail.com", password, phoneNumber);
    }
}
