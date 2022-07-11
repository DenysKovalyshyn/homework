package lesson23;
import org.testng.annotations.AfterSuite;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseTest {
    public static final String dbAdderss = "jdbc:postgresql://rd.cfvw8lxtimwu.eu-central-1.rds.amazonaws.com:5432/kovalyshyn";
    public static final String dbUser = "kovalyshyn";
    public static final String dbPassword = "kovalyshyn!5";

    protected Connection getConnection() throws SQLException {
        return DBConnection.getInstance(dbAdderss, dbUser, dbPassword).getConnection();
    }

    @AfterSuite
    public void tearDown() {
        try {
            DBConnection.closeConnection();
        } catch (SQLException e) {
//            log.error("Failed to close connection {}", e.getMessage());
        }
    }
}