package cover;

public class KomitetWyborczy {
    private final int nrOkręgu;
    private final String nazwaPartii;
    private Kandydat[] listaKandydatów;
    private int otrzymaneGłosy = 0;
    private int otrzymaneMandaty = 0;

    public Kandydat[] getListaKandydatów() {
        return listaKandydatów;
    }

    public KomitetWyborczy(int nrOkręgu, String nazwaPartii,
                           Kandydat[] listaKandydatów) {
        this.nrOkręgu = nrOkręgu;
        this.nazwaPartii = nazwaPartii;
        this.listaKandydatów = listaKandydatów;
    }

    private void połączListy(Kandydat[] drugaLista) {
        int wielkośćPołączonejListy = this.listaKandydatów.length +
                drugaLista.length;
        Kandydat[] połączonaLista = new Kandydat[wielkośćPołączonejListy];
        System.arraycopy(this.listaKandydatów, 0, połączonaLista, 0,
                this.listaKandydatów.length);
        System.arraycopy(drugaLista, 0, połączonaLista,
                this.listaKandydatów.length, drugaLista.length);
        this.listaKandydatów = połączonaLista;
    }

    public void połączKomitety(KomitetWyborczy komitetWyborczy) {
        połączListy(komitetWyborczy.listaKandydatów);
        this.otrzymaneGłosy += komitetWyborczy.otrzymaneGłosy;
        this.otrzymaneMandaty += komitetWyborczy.otrzymaneMandaty;
    }

    public void zaktualizujOtrzymaneGłosy() {
        this.otrzymaneGłosy = 0;
        for (Kandydat kandydat : listaKandydatów)
            this.otrzymaneGłosy += kandydat.getOtrzymaneGłosy();
    }

    public int getOtrzymaneGłosy() {
        return otrzymaneGłosy;
    }

    public Kandydat zwróćDaneKandydata(int pozycjaNaLiście) {
        return listaKandydatów[pozycjaNaLiście - 1];
    }

    public void otrzymajMandat() {
        this.otrzymaneMandaty += 1;
    }

    public int getOtrzymaneMandaty() {
        return otrzymaneMandaty;
    }

    public void zerujOtrzymaneMandaty() {
        this.otrzymaneMandaty = 0;
    }

    public String getNazwaPartii() {
        return nazwaPartii;
    }
}
