package com.company;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Pokemon p = new Pokemon(4,"Salameche",100,1);
        Pokemon p2 = new Pokemon(4,"Pikachu",100,1);

        Attaque a = new Attaque(1,"Flammes",10);
        Attaque a2 = new Attaque(2, "Coupe", 10);

        p.addAttaque(a);
        p.addAttaque(a2);

        p.TaperFortSur(p2,0);

        System.out.println(p2);

        DBManager d = new DBManager();
        d.connection();

        p.crier();

        // 1 - méthode getAllPokemon()

        ArrayList<Pokemon> liste = new ArrayList<Pokemon>();
        liste = d.getAllPokemon();

        for (int i = 0; i < 151 ; i++){
            System.out.println(liste.get(i).getId() + " : " + liste.get(i).getNom() );
        }

        // 2 - Méthode getPokemonById(int id)
        Pokemon pikachu = d.getPokemonById(25);
        System.out.println(pikachu.getId() + " : " + pikachu.getNom());

        // 3 - Intégrer les dresseurs (créer une classe en Java)
        // Dresseur d = new Dresseur();
        // d.setNom("Zab");
    }
}
