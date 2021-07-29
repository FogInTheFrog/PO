package com.company;

public class OszczędnyZOgranieczeniem extends Uśredniacz {
    public OszczędnyZOgranieczeniem(int budżet, String imię) {
        super(budżet, imię);
    }

    protected boolean sprawdźPreferencje(Przedmiot przedmiot) {
        if (super.czyToPierwszyPrzedmiot()) {
            super.zapamiętajNowyPrzedmiot(przedmiot);
            return false;
        }
        int średniaCena = super.dajŚredniąWartość();
        super.zapamiętajNowyPrzedmiot(przedmiot);
        return przedmiot.getCena() <= (0.9 * średniaCena);
    }
}
