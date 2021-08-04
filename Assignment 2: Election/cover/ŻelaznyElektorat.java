package cover;

public abstract class ŻelaznyElektorat extends Wyborca {

    ŻelaznyElektorat(String imię, String nazwisko, int numberOkręguWyborczego,
                     String przywiązaniePartyjne) {
        super(imię, nazwisko, numberOkręguWyborczego, przywiązaniePartyjne);
    }

    private boolean czyToUlubionaPartia(KomitetWyborczy komitetWyborczy){
        return (komitetWyborczy.getNazwaPartii().equals(przywiązaniePartyjne));
    }

    private KomitetWyborczy szukajUlubionejPartii(KartaWyborcza kartaWyborcza){
        for (KomitetWyborczy
                komitetWyborczy : kartaWyborcza.getListaKomitetówWyborczych()){
            if (czyToUlubionaPartia(komitetWyborczy))
                return komitetWyborczy;
        }
        throw new RuntimeException();
    }

    protected Kandydat wybierzKandydata(KartaWyborcza kartaWyborcza){
        KomitetWyborczy ulubionyKomitet = szukajUlubionejPartii(kartaWyborcza);
        int liczbaKandydatów = ulubionyKomitet.getListaKandydatów().length;
        int nrKandydata = wybierzPozycjęNaLiście(liczbaKandydatów);
        return ulubionyKomitet.zwróćDaneKandydata(nrKandydata);
    }

    protected abstract int wybierzPozycjęNaLiście(int iluKandydatów);
}