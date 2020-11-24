package com.company;

public class Dresseur {

    // attributs
    private int id;
    private String nom;

    //Constructeur
    public Dresseur(){
        this.id = 0;
        this.nom = "Unknown";
    }

    // Constructeur paramétré
    public Dresseur(int i, String n){
        this.id = i;
        this.nom = n;
    }

    // accesseur
    // getter

    public int getId() { return this.id; }
    public String getNom() { return this.nom; }

    // setter

    public void setId(int i) { this.id = i; }
    public void setNom(String n) { this.nom = n; }

    @Override
    public String toString(){
        String res = nom + "{id=" + id + "}";
        return res;
    }

}
