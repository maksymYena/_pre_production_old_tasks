package com.epam.maksym_yena.java.lesson_18.task_11;


import java.sql.*;

public class ConnectorFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/doctor";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(
                    URL, "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("SUCCESFULLL");
        return connection;
    }





}


