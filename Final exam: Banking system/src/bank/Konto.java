package bank;

public abstract class Konto {
    protected String nrKonta;
    protected String właściciel;

    class wzywajKomornika extends Exception{}
    class niepoprawneZlecenie extends Exception{}

    public Konto(String nrKonta, String właściciel) {
        this.nrKonta = nrKonta;
        this.właściciel = właściciel;
    }

    public abstract void wpłać(int kwota, String waluta) throws niepoprawneZlecenie;
    public abstract void wypłać(int kwota, String waluta) throws niepoprawneZlecenie;
    public abstract boolean czyMogęOtrzymaćPrzelew(String waluta);
    public abstract boolean czyMogęWysłaćPrzelew(String waluta, int kwota);
    public abstract void obsłużKoniecMiesiąca()
            throws KontoKredytoweKartowe.wzywajKomornika;
}
