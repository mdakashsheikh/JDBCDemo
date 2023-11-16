import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/jdbcdemo";
        String username = "root";
        String password="";
        int uId = 4;
        String uName = "Ali";
        int uAge = 52;
//        String query = "select * from student";       //Fetch data from Student Table
//        String query = "insert into student values (3, 'Kamal', 25)";
        String query = "insert into student values (?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

//            Statement statement = connection.createStatement();
            PreparedStatement statement = connection.prepareStatement(query);

//          -----------------This fetch Data Code --------------
//            ResultSet resultSet = statement.executeQuery(query);

//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
//            }

            statement.setInt(1,uId);
            statement.setString(2, uName);
            statement.setInt(3, uAge);
            int count = statement.executeUpdate();

            System.out.println(count + " row/s affected.");

            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}