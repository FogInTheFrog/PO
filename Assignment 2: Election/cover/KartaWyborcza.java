package cover;

class KartaWyborcza {
    private final int numerOkręgu;
    private final KomitetWyborczy[] listaKomitetówWyborczych;

    public KartaWyborcza(int numerOkręgu,
                         KomitetWyborczy[] listaKomitetówWyborczych) {
        this.numerOkręgu = numerOkręgu;
        this.listaKomitetówWyborczych = listaKomitetówWyborczych;
    }

    public KomitetWyborczy[] getListaKomitetówWyborczych() {
        return listaKomitetówWyborczych;
    }
}
