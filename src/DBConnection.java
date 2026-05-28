import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/detailsdb";
            String user = "root";
            String password = "gurulatha";

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected");

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
