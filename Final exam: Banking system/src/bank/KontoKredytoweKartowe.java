package bank;

public class KontoKredytoweKartowe extends KontoKredytowe{
    private int saldo;
    private int limitKredytowy;

    public KontoKredytoweKartowe(String nrKonta, String właściciel, String waluta,
                                 Konto stowarzyszoneKonto, int saldo,
                                 int limitKredytowy) {
        super(nrKonta, właściciel, waluta, stowarzyszoneKonto);
        this.saldo = saldo;
        this.limitKredytowy = limitKredytowy;
    }

    @Override
    public boolean czyMogęWysłaćPrzelew(String waluta, int kwota) {
        return (this.waluta.equals(waluta) &&
                (saldo *(-1) + kwota <= limitKredytowy));
    }

    public void wypłać(int kwota, String waluta){
        if (czyMogęWysłaćPrzelew(waluta, kwota)){
            saldo -= kwota;
        }
        else
            throw new RuntimeException();
    }

    @Override
    public void obsłużKoniecMiesiąca() throws wzywajKomornika {
        int debet = saldo * (-1);
        if (stowarzyszoneKonto.czyMogęWysłaćPrzelew(this.waluta, debet)){
            stowarzyszoneKonto.wypłać(debet, this.waluta);
            this.saldo = 0;
        }
        else {
            throw new wzywajKomornika();
        }
    }
}
