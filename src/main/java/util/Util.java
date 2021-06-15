package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final String URL="jdbc:mysql://localhost:3306/test";
    private final String USERNAME="root";
    private final String PASSWORD="root";

    Driver driver;
    Connection connection=null;

    public Util() {
        driver=getDriver();
        regisrtyFriver(driver);
    }

    private Driver getDriver() {
        Driver drive;
       try {
           driver = new com.mysql.cj.jdbc.Driver();;
       } catch (SQLException e) {
           System.out.println("Driver not found");
       }
       return driver;
    }

    private void regisrtyFriver(Driver driver) {
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Драйвер не зарегистрирован");
        }
    }

    public Connection getConnection() {
        try {
            connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Cant create Connection");
        }
        return connection;
    }


    // реализуйте настройку соеденения с БД
}
