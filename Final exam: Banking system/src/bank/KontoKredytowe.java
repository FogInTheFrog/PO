package bank;

public abstract class KontoKredytowe extends Konto {
    protected String waluta;
    protected Konto stowarzyszoneKonto;

    public KontoKredytowe(String nrKonta, String właściciel,
                          String waluta, Konto stowarzyszoneKonto) {
        super(nrKonta, właściciel);
        this.waluta = waluta;
        this.stowarzyszoneKonto = stowarzyszoneKonto;
    }

    @Override
    public void wpłać(int kwota, String waluta) {
        throw new RuntimeException();
    }

    @Override
    public boolean czyMogęOtrzymaćPrzelew(String waluta) {
        return false;
    }
}
