package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DBManager {

    private String URL = "jdbc:mysql://127.0.0.1/Java_Pokemon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String LOGIN = "benjamin";
    private String PASSWORD = "x1XnnrQfLeqmvhCT";
    private Connection connection;
    private Statement stmt;

    public void DBManger(){
        this.connection();
    }

    public boolean connection() {
        System.out.println("Connection au systeme...");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ou est MysQL JDBC DRIVER?");
            e.printStackTrace();
            return false;
        }

        this.connection = null;
        try {
           Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erreur connection!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
