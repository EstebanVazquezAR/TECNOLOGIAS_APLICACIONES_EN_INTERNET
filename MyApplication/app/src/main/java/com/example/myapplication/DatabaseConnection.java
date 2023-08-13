package com.example.myapplication;

import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String TAG = "DatabaseConnection";

    private static final String DB_URL = "jdbc:jtds:sqlserver://angelescuela.database.windows.net/angelescuela";
    private static final String USER = "angelsa1";
    private static final String PASSWORD = "oxOWrOk3yPYjDmL5";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Log.d(TAG, "Connected to database");
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "ClassNotFoundException: " + e.getMessage());
        } catch (SQLException e) {
            Log.e(TAG, "SQLException: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                Log.d(TAG, "Connection closed");
            } catch (SQLException e) {
                Log.e(TAG, "SQLException: " + e.getMessage());
            }
        }
    }
}
