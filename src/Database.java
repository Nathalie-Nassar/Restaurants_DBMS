import java.sql.*;

public class Database {
    public static Connection Connect(String dbname){
        String url = "jdbc:mysql://localhost:3306/"+dbname;
        String username = "root";
        String passwd = "####";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, passwd);
        } catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
        return connection;
    }

    public static String getEmployees() throws SQLException {
         String result = "";
         Connection connection = Connect("restaurants");
         Statement stmt = connection.createStatement();
         String getEmployees = "select *  from  employee";
         ResultSet resultSet = stmt.executeQuery(getEmployees);

         while (resultSet.next()) {
             int id = resultSet.getInt("eid");
             int salary = resultSet.getInt("salary");
             String name = resultSet.getString("eName");
             String phoneNumber = resultSet.getString("phoneNumber");
             String address = resultSet.getString("adress");
             int restaurantId = resultSet.getInt("restaurantID");

             String getRestaurant = "select rName  from  restaurant where rID = "+restaurantId;

             Statement statement = connection.createStatement();
             ResultSet restaurantSet = statement.executeQuery(getRestaurant);
             String restaurant = "";
             while (restaurantSet.next()) {
                 restaurant = restaurantSet.getString("rName");
             }
             result+="The workers at " + restaurant +" are: \n";
             result+=("Name: " +name + " , " + phoneNumber + " and his salary is "+salary+"\n");
            }
         return result;
    }

}
