package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private String URL = "jdbc:mysql://127.0.0.1/Java_Pokemon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String LOGIN = "Benjamin";
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
           this.connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erreur connection!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Pokemon> getAllPokemon() throws SQLException{
        ArrayList<Pokemon> res = new ArrayList<>();
        try{
            this.stmt = this.connection.createStatement();
            String query = "SELECT * FROM pokemon";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id_pok");
                String nom = rs.getString("nom_pok");
                Pokemon p = new Pokemon(id, nom);
                res.add(p);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if (stmt != null){
                this.stmt.close();
            }
        }
        return res;
    }

    public Pokemon getPokemonById(int id) throws SQLException{
        Pokemon p = new Pokemon();
        try{
            this.stmt = this.connection.createStatement();
            String query = "SELECT * FROM pokemon where id_pok = " + id;
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            String nom = rs.getString("nom_pok");
            p = new Pokemon(id, nom);

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if (stmt != null){
                this.stmt.close();
            }
        }
        return p;
    }

}
