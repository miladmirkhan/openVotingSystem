package connections;
import java.sql.*;


public class JDBC {

    public static void insert(String sql){
            

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/openvotingsystem","root",""); 
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                    
                } catch (ClassNotFoundException e) {
        
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
        }
    }
    public static ResultSet display(String sql) {
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/openvotingsystem","root",""); 
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void remove(String sql) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/openvotingsystem","root",""); 
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }   
    
    public static void update(String sql) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/openvotingsystem","root",""); 
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }    

}