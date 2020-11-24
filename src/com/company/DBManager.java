package com.company;

import javax.xml.transform.Result;
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

    public Dresseur getDresseurByName(String n) throws SQLException{
        Dresseur d = new Dresseur();
        try{
            this.stmt = this.connection.createStatement();
            String query = "SELECT * FROM dresseur WHERE nom_dress=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,n);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            int id = rs.getInt("id_dress");
            d = new Dresseur(id, n);

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if (stmt != null){
                this.stmt.close();
            }
        }
        return d;
    }

    public ArrayList<Pokemon> getPokemonDetenus(Dresseur d) throws SQLException{
        ArrayList<Pokemon> res = new ArrayList<>();
        try{
            this.stmt = this.connection.createStatement();
            String query = "SELECT Pokemon.id_pok, Pokemon.nom_pok, lvl_pok FROM dresseur, Pokemon, detientPokemon " +
                           "WHERE Pokemon.id_pok = detientPokemon.id_pok " +
                           "AND detientPokemon.id_dress = dresseur.id_dress " +
                           "AND Dresseur.id_dress=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,d.getId() );

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id_pok");
                String nom = rs.getString("nom_pok");
                int niveau = rs.getInt("lvl_pok");

                Pokemon p = new Pokemon (id,nom,100,niveau);
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

}
