package com.company;

public abstract class Uśredniacz extends Uczestnik {
    protected int ilePrzedmiotówWidziałem = 0;
    protected int sumarycznaWartośćPrzedmiotów = 0;

    protected boolean czyToPierwszyPrzedmiot() {
        return this.ilePrzedmiotówWidziałem == 0;
    }

    public Uśredniacz(int budżet, String imię) {
        super(budżet, imię);
    }

    protected int dajŚredniąWartość() {
        return sumarycznaWartośćPrzedmiotów / ilePrzedmiotówWidziałem;
    }

    protected void zapamiętajNowyPrzedmiot(Przedmiot przedmiot) {
        ilePrzedmiotówWidziałem++;
        sumarycznaWartośćPrzedmiotów += przedmiot.getCena();
    }
}
