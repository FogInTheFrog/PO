package com.company;

public class SentymentalnyZOgraniczeniem extends Sentymentalny {
    private int limitPrzedmiotów;
    private int ileKupiłem = 0;

    public SentymentalnyZOgraniczeniem(int budżet, String imię,
                                       Kraj krajPochodzenia,
                                       int limitPrzedmiotów) {
        super(budżet, imię, krajPochodzenia);
        this.limitPrzedmiotów = limitPrzedmiotów;
    }

    @Override
    protected boolean sprawdźPreferencje(Przedmiot przedmiot) {
        if (ileKupiłem < limitPrzedmiotów)
            return super.sprawdźPreferencje(przedmiot);
        return false;
    }
}