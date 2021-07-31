package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<AlgebraicInteger> example1 = new ArrayList<>();
        example1.add(new AlgebraicInteger(1));
        example1.add(new AlgebraicInteger(2));
        example1.add(new AlgebraicInteger(3));
        ArrayList<AlgebraicInteger> example2 = new ArrayList<>();
        example2.add(new AlgebraicInteger(5));
        example2.add(new AlgebraicInteger(4));
        example2.add(new AlgebraicInteger(3));
        Wektor<AlgebraicInteger> w1 = new Wektor<AlgebraicInteger>(example1);
        Wektor<AlgebraicInteger> w2 = new Wektor<AlgebraicInteger>(example2);
        System.out.println(w1.add(w2));
        System.out.println(w1.multiply(w2));

    }
}
