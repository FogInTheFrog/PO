package com.company;

public class Sentymentalny extends Uczestnik {
    private Kraj krajPochodzenia;

    public Sentymentalny(int budżet, String imię, Kraj krajPochodzenia) {
        super(budżet, imię);
        this.krajPochodzenia = krajPochodzenia;
    }

    @Override
    protected boolean sprawdźPreferencje(Przedmiot przedmiot) {
        return przedmiot.getKrajPochodzenia() == krajPochodzenia;
    }
}