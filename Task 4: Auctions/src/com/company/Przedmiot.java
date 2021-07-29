package com.company;

public class Przedmiot {
    private int cena;
    private String nazwa;
    private Kraj krajPochodzenia;

    public Kraj getKrajPochodzenia() {
        return krajPochodzenia;
    }

    public Przedmiot(int cena, String nazwa, Kraj krajPochodzenia) {
        this.cena = cena;
        this.nazwa = nazwa;
        this.krajPochodzenia = krajPochodzenia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getCena() {
        return cena;
    }
}