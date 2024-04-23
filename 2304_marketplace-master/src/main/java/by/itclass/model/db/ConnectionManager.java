package by.itclass.model.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionManager {
    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/2304_marketplace";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    private static Connection cn;

    @SneakyThrows
    public static void init() {
        Class.forName(DRIVER_NAME);
    }

    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(cn) || cn.isClosed()) {
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return cn;
    }
}

