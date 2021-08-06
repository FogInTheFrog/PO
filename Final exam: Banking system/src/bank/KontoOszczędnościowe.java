package bank;

public class KontoOszczędnościowe extends KontoBezDebetu {
    private float rocznaStopaProcentowa;

    public KontoOszczędnościowe(String nrKonta, String właściciel,
                                String waluta, int saldo,
                                float rocznaStopaProcentowa) {
        super(nrKonta, właściciel, waluta, saldo);
        this.rocznaStopaProcentowa = rocznaStopaProcentowa;
    }

    @Override
    public boolean czyMogęWysłaćPrzelew(String waluta, int kwota) {
        return false;
    }

    @Override
    public void wypłać(int kwota, String waluta) {
        throw new RuntimeException();
    }

    @Override
    public void obsłużKoniecMiesiąca() {
        saldo += saldo * rocznaStopaProcentowa / 1200;
    }
}
