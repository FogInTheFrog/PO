package bank;

public class KontoBieżące extends KontoBezDebetu {
    public KontoBieżące(String nrKonta, String właściciel, String waluta, int saldo) {
        super(nrKonta, właściciel, waluta, saldo);
    }

    @Override
    public boolean czyMogęWysłaćPrzelew(String waluta, int kwota) {
        return (super.waluta.equals(waluta) && super.saldo >= kwota);
    }

    @Override
    public void wypłać(int kwota, String waluta) {
        if (czyMogęWysłaćPrzelew(waluta, kwota)){
            saldo -= kwota;
        }
        else
            throw new RuntimeException();
    }

    @Override
    public void obsłużKoniecMiesiąca() {

    }
}
