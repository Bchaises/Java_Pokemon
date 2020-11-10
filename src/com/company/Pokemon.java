package com.company;

import java.util.Random;

public class Pokemon {

    // attributs
    private int id;
    private String nom;
    private int pointDeVie;
    private int niveau;

    // Constructeur par défaut
    public Pokemon(){
        this.id = 0;
        this.nom = "Unknown";
        this.pointDeVie = -1;
        this.niveau = -1;
    }

    // constructeur
    public Pokemon(int i, String n, int p, int niv){
        this.id = i;
        this.nom = n;
        this.pointDeVie = p;
        this.niveau = niv;
    }

    // getter
    public int getId(){ return this.id; }
    public String getNom(){ return this.nom; }
    public int getPointDeVie() { return this.pointDeVie; }
    public int getNiveaua() { return this.niveau; }

    // setter
    public void setId(int i) { this.id = i; }
    public void setNom(String n) { this.nom = n; }
    public void setPointDeVie(int p) { this.pointDeVie = p; }
    public void setNiveau(int niv) { this.niveau = niv; }

    @Override
    public String toString() {
        String res = nom + "{id=" + id + ", nom=" + nom + ", niveau=" + niveau + ", pointDeVie=" + pointDeVie+"}";
        return res;
    }

    public void crier() {
        System.out.println("Coucou je suis "+this.nom);
    }

    public boolean addAttaque(Attaque a){

        Random rnd = new Random();
        if (rnd.nextInt(100)>2){
            int degats = a.getDegats();

            if (rnd.nextInt(16)>15){
                System.out.println("Attaque critique");
                degats *= 2;
            }
            setPointDeVie(getPointDeVie() - degats);
            return true;
        }
        System.out.println("Attaque raté");
        return false;

    }
}
