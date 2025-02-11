import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

        private static final String JDBCURL = "jdbc:postgresql://localhost:5432/JohnDeereRFID";
        private static final String USERNAME = "JohnDeereAdmin";
        private static final String PASSWORD = "RFIDr0ckz#701!";

        private static Connection connection;

        public static Connection getConnection() {
            if (connection == null) {
                setConnection();
            }
            return connection;
        }

        private static void setConnection() {
            try {
                // load the driver
                //DriverManager.registerDriver(new Driver());
                Class.forName("org.postgresql.Driver");
                // connect to the database
                connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
                System.out.println("Connected");
            } catch (ClassNotFoundException e) {
                System.out.println("Cannot load the driver");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Got a SQL exception.");
                e.printStackTrace();
            }
        }
    }
