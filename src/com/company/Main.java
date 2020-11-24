package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Pokemon p = new Pokemon(4,"Salameche",100,1);
        // Pokemon p2 = new Pokemon(4,"Pikachu",100,1);

        // Attaque a = new Attaque(1,"Flammes",10);
        // Attaque a2 = new Attaque(2, "Coupe", 10);

        // p.addAttaque(a);
        // p.addAttaque(a2);

        // p.TaperFortSur(p2,0);

        // System.out.println(p2);

        DBManager db = new DBManager();
        db.connection();

        //p.crier();

        // 1 - méthode getAllPokemon()

        ArrayList<Pokemon> liste = new ArrayList<Pokemon>();
        liste = db.getAllPokemon();

        for (int i = 0; i < 151 ; i++){
            System.out.println(liste.get(i).getId() + " : " + liste.get(i).getNom() );
        }

        // 2 - Méthode getPokemonById(int id)
        Pokemon pikachu = db.getPokemonById(25);
        System.out.println(pikachu.getId() + " : " + pikachu.getNom());

        // 3 - Intégrer les dresseurs (créer une classe en Java)


        // 4 - Ecrire la fonction getPokemonDetenus (Dresseur r)

        System.out.println("Dresseur quel est ton nom ?");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        Dresseur d1 = db.getDresseurByName(n);

        System.out.println("Voici tes pokémons "+ n);
        ArrayList<Pokemon> tab = db.getPokemonDetenus(d1);
        for (Pokemon p : tab){
           System.out.println(p.getNom() + " lvl " + p.getNiveau());
        }
    }
}
