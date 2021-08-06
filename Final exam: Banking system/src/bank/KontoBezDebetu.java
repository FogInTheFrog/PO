package bank;

public abstract class KontoBezDebetu extends Konto {
    protected String waluta;
    protected int saldo;

    public boolean czyMogęOtrzymaćPrzelew(String waluta){
        return (this.waluta.equals(waluta));
    }

    public void wpłać(int kwota, String waluta){
        if (this.waluta.equals(waluta))
            this.saldo += kwota;
        else throw new RuntimeException();
    }

    public KontoBezDebetu(String nrKonta, String właściciel,
                          String waluta, int saldo) {
        super(nrKonta, właściciel);
        this.waluta = waluta;
        this.saldo = saldo;
    }

}
