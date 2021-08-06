package bank;

public class KontoKredytoweRatalne extends KontoKredytowe {
    private float roczneOprocentowanie;
    private int liczbaRat;
    private int spłaconeRaty;
    private int początkowaKwotaPożyczki;
    private int pozostałoDoSpłaty;

    public KontoKredytoweRatalne(String nrKonta, String właściciel, String waluta,
                                 Konto stowarzyszoneKonto, float roczneOprocentowanie,
                                 int liczbaRat, int początkowaKwotaPożyczki) {
        super(nrKonta, właściciel, waluta, stowarzyszoneKonto);
        this.roczneOprocentowanie = roczneOprocentowanie;
        this.liczbaRat = liczbaRat;
        this.początkowaKwotaPożyczki = początkowaKwotaPożyczki;
        this.spłaconeRaty = 0;
        this.pozostałoDoSpłaty = początkowaKwotaPożyczki;
    }

    @Override
    public void wypłać(int kwota, String waluta) {
        throw new RuntimeException();
    }

    private int obliczKolejnąRatę(){
        return (int) (początkowaKwotaPożyczki / liczbaRat + pozostałoDoSpłaty *
                        roczneOprocentowanie / 12);
    }

    @Override
    public void obsłużKoniecMiesiąca() throws wzywajKomornika {
        int ileDoZapłaty = obliczKolejnąRatę();
        if (stowarzyszoneKonto.czyMogęWysłaćPrzelew(this.waluta, ileDoZapłaty)){
            stowarzyszoneKonto.wypłać(ileDoZapłaty, waluta);
            this.spłaconeRaty++;
            this.pozostałoDoSpłaty = początkowaKwotaPożyczki *
                    (liczbaRat - spłaconeRaty) / liczbaRat;
        }
        else {
            throw new wzywajKomornika();
        }
    }

    @Override
    public boolean czyMogęWysłaćPrzelew(String waluta, int kwota) {
        return false;
    }
}
