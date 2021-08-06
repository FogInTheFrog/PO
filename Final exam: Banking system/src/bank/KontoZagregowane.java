package bank;

public class KontoZagregowane extends Konto {
    private Konto[] kontaPodstawowe;

    public KontoZagregowane(String nrKonta, String właściciel,
                            Konto[] kontaPodstawowe) {
        super(nrKonta, właściciel);
        this.kontaPodstawowe = kontaPodstawowe;
    }

    @Override
    public boolean czyMogęWysłaćPrzelew(String waluta, int kwota) {
        for (Konto konto : kontaPodstawowe){
            if (konto.czyMogęWysłaćPrzelew(waluta, kwota))
                    return true;
        }
        return false;
    }

    @Override
    public void wpłać(int kwota, String waluta) throws niepoprawneZlecenie {
        for (Konto konto : kontaPodstawowe){
            if (konto.czyMogęOtrzymaćPrzelew(waluta)){
                konto.wpłać(kwota, waluta);
                return;
            }
        }
        throw new niepoprawneZlecenie();
    }

    @Override
    public void wypłać(int kwota, String waluta) throws niepoprawneZlecenie {
        for (Konto konto : kontaPodstawowe) {
            if (konto.czyMogęWysłaćPrzelew(waluta, kwota)){
                konto.wypłać(kwota, waluta);
                return;
            }
        }
        throw new niepoprawneZlecenie();
    }

    @Override
    public boolean czyMogęOtrzymaćPrzelew(String waluta) {
        for (Konto konto : kontaPodstawowe){
            if (konto.czyMogęOtrzymaćPrzelew(waluta))
                return true;
        }
        return false;
    }

    @Override
    public void obsłużKoniecMiesiąca() throws wzywajKomornika {
        for (Konto konto : kontaPodstawowe){
            konto.obsłużKoniecMiesiąca();
        }
    }
}
