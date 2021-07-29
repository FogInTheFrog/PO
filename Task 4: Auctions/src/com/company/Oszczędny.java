package com.company;

public class Oszczędny extends Uśredniacz {

    public Oszczędny(int budżet, String imię) {
        super(budżet, imię);
    }

    protected boolean sprawdźPreferencje(Przedmiot przedmiot) {
        if (super.czyToPierwszyPrzedmiot()) {
            super.zapamiętajNowyPrzedmiot(przedmiot);
            return false;
        }
        int średniaCena = super.dajŚredniąWartość();
        super.zapamiętajNowyPrzedmiot(przedmiot);
        return przedmiot.getCena() < średniaCena;
    }
}
