package com.company;

public class Main {

    public static void main(String[] args) {
        Pokemon p = new Pokemon(4,"Salameche",100,1);
        Pokemon p2 = new Pokemon(4,"Pikachu",100,1);

        Attaque a = new Attaque(1,"Flammes",10);
        Attaque a2 = new Attaque(2, "Coupe", 10);

        p.addAttaque(a);
        p.addAttaque(a2);

        p.TaperFortSur(p2,0);

        System.out.println(p2);

        p.crier();
    }
}
