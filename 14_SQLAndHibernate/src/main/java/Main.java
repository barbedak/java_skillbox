import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "$Master";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, " +
                "(count(subscription_date) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)))) as avg" +
                " FROM Purchaselist GROUP BY course_name");

            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String avg = resultSet.getString("avg");
                System.out.println("Курс \"" + courseName + "\", среднее значение продаж - " + avg);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
