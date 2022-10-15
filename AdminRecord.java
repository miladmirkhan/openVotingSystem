public record AdminRecord(int id, String fullName, String accessLevel,
                    String email, String password, String phoneNumber)
{
    
    public AdminRecord(int id, String fullName,
                String password, String phoneNumber)
    {
        this(id, fullName, "undefined", null, password, phoneNumber);
    }
}
