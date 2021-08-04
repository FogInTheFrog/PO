package cover;

import java.util.Arrays;

public class OkręgWyborczy {
    private final int nrOkręgu;
    private int liczbaWyborców;
    private boolean czyPołączonyZInnymOkręgiem = false;
    private final KomitetWyborczy[] listaKomitetówWyborczych;
    private Wyborca[] listaWyborców;

    public OkręgWyborczy(int nrOkręgu, int liczbaWyborców,
                         KomitetWyborczy[] listaKomitetówWyborczych,
                         Wyborca[] listaWyborców) {
        this.nrOkręgu = nrOkręgu;
        this.liczbaWyborców = liczbaWyborców;
        this.listaKomitetówWyborczych = listaKomitetówWyborczych;
        this.listaWyborców = listaWyborców;
    }

    private void połączKomitety(KomitetWyborczy[] drugaListaKomitetów) {
        for (int i = 0; i < listaKomitetówWyborczych.length; i++) {
            KomitetWyborczy drugiKomitet = drugaListaKomitetów[i];
            listaKomitetówWyborczych[i].połączKomitety(drugiKomitet);
        }
    }

    private void połączWyborców(Wyborca[] drugaLista) {
        int wielkośćPołączonejListy = this.listaWyborców.length +
                drugaLista.length;
        Wyborca[] połączonaLista = new Wyborca[wielkośćPołączonejListy];
        System.arraycopy(this.listaWyborców, 0, połączonaLista, 0,
                this.listaWyborców.length);
        System.arraycopy(drugaLista, 0, połączonaLista,
                this.listaWyborców.length, drugaLista.length);
        this.listaWyborców = połączonaLista;
    }

    @Override
    public String toString() {
        return "OkręgWyborczy{" +
                "nrOkręgu=" + nrOkręgu +
                ", liczbaWyborców=" + liczbaWyborców +
                ", czyPołączonyZInnymOkręgiem=" + czyPołączonyZInnymOkręgiem +
                ", listaKomitetówWyborczych=" +
                Arrays.toString(listaKomitetówWyborczych) +
                ", listaWyborców=" + Arrays.toString(listaWyborców) +
                '}';
    }

    public String zwróćNumeryOkręgu() {
        if (czyPołączonyZInnymOkręgiem)
            return ((nrOkręgu) + " " + (nrOkręgu + 1));
        return String.valueOf(nrOkręgu);
    }

    public void połączOkręgi(OkręgWyborczy okręgWyborczy) {
        this.liczbaWyborców += okręgWyborczy.liczbaWyborców;
        this.czyPołączonyZInnymOkręgiem = true;
        połączKomitety(okręgWyborczy.listaKomitetówWyborczych);
        połączWyborców(okręgWyborczy.listaWyborców);
    }

    public KomitetWyborczy[] getListaKomitetówWyborczych() {
        return listaKomitetówWyborczych;
    }

    public int getLiczbaWyborców() {
        return liczbaWyborców;
    }

    public Wyborca[] getListaWyborców() {
        return listaWyborców;
    }

    public KomitetWyborczy zwróćKomitetONazwie(String nazwaPartii) {
        for (KomitetWyborczy komitet : listaKomitetówWyborczych) {
            if (komitet.getNazwaPartii().equals(nazwaPartii))
                return komitet;
        }
        throw new RuntimeException();
    }

    private KartaWyborcza generujKartęWyborcząDlaOkręgu() {
        return new KartaWyborcza(this.nrOkręgu,
                this.listaKomitetówWyborczych);
    }

    public void przeprowadźGłosowanie() {
        KartaWyborcza kartaWyborcza = generujKartęWyborcząDlaOkręgu();
        for (int i = 0; i < liczbaWyborców; i++) {
            listaWyborców[i].głosuj(kartaWyborcza);
        }
    }
}