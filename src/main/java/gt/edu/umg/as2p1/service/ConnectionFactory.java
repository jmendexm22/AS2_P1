package gt.edu.umg.as2p1.service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://192.185.4.65:3306/jbarilla_ingsoftware?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "jbarilla_estudia";
    public static final String PASS = "2Ui!OssHDQGv";

    public static Connection getConnection() {

        try {
            // DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        
    }

    /**
     *
     * Test Connection
     *
     */
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }

}
