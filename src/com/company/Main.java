package com.company;

public class Main {

    public static void main(String[] args) {
        Pokemon p = new Pokemon(4,"Salameche",100,1);
        System.out.println(p);

        Attaque a = new Attaque(1,"Flammes",100);
        System.out.println(a);



        p.addAttaque(a);
        System.out.println(p);
        System.out.println(a);

        p.crier();
    }
}
