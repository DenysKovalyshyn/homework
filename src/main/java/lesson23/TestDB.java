package lesson23;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB extends BaseTest {

    @AfterMethod
    public void checkResult() throws SQLException {
        Statement sqlStatement = getConnection().createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("SELECT * FROM student");

        while(resultSet.next()) {
            System.out.printf("%s %s %s \n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
        }
    }

    @Test(priority = 1)
    public void addNewStudent() throws SQLException {
        Statement sqlStatement = getConnection().createStatement();
        int resultSet = sqlStatement.executeUpdate("INSERT INTO student(id, first_name, last_name) VALUES(4, 'Denys', 'Kovalyshyn')");
    }

    @Test(priority = 2)
    public void changeNewStudentLastName() throws SQLException{
        Statement sqlStatement = getConnection().createStatement();
        int resultSet = sqlStatement.executeUpdate("UPDATE student SET last_name = 'KovalyshynNEW' WHERE first_name = 'Denys'");
    }

    @Test(priority = 3)
    public void deleteNewStudent() throws SQLException{
        Statement sqlStatement = getConnection().createStatement();
        int resultSet = sqlStatement.executeUpdate("DELETE FROM student WHERE last_name='KovalyshynNEW'");
    }

    @Test(priority = 4)
    public void addStudentViaStatement() throws SQLException{
        String sqlPattern = "INSERT INTO student(id, first_name, last_name) VALUES(?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setInt(1, 4);
        preparedStatement.setString(2, "Julia");
        preparedStatement.setString(3, "Kostiurechko");
        int resultSet = preparedStatement.executeUpdate();
    }

    @Test(priority = 5)
    public void changeNewStudentLastNameViaStatement() throws SQLException{
        String sqlPattern = "UPDATE student SET last_name = ? WHERE first_name = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setString(1, "Kovalyshyn");
        preparedStatement.setString(2, "Julia");
        int resultSet = preparedStatement.executeUpdate();
    }

    @Test(priority = 6)
    public void deleteNewStudentViaStatement() throws SQLException{
        String sqlPattern = "DELETE FROM student WHERE first_name=? AND last_name= ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setString(1, "Julia");
        preparedStatement.setString(2, "Kovalyshyn");
        int resultSet = preparedStatement.executeUpdate();
    }
}
