package com.company;

public abstract class Uczestnik {
    protected int budżet;
    protected int wydanyHajs = 0;
    protected String imię;

    public Uczestnik(int budżet, String imię) {
        this.budżet = budżet;
        this.imię = imię;
    }

    protected abstract boolean sprawdźPreferencje(Przedmiot przedmiot);

    public boolean czyKupić(Przedmiot przedmiot) {
        boolean preferencja = sprawdźPreferencje(przedmiot);
        return preferencja &&
                ((this.budżet - this.wydanyHajs) >= przedmiot.getCena());
    }

    public void kup(Przedmiot przedmiot) {
        this.wydanyHajs += przedmiot.getCena();
        ryknij(przedmiot);
    }

    protected void ryknij(Przedmiot przedmiot) {
        System.out.println("Jestem " + this.imię + ". Kupiłem "
                + przedmiot.getNazwa() + " za " + przedmiot.getCena());
    }
}
