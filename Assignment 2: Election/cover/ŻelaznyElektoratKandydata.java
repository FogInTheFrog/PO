package cover;

public class ŻelaznyElektoratKandydata extends ŻelaznyElektorat {

    private final int nrKandydata;

    public ŻelaznyElektoratKandydata(String imię, String nazwisko,
                                     int numberOkręguWyborczego,
                                     String przywiązaniePartyjne,
                                     int nrKandydata) {
        super(imię, nazwisko, numberOkręguWyborczego, przywiązaniePartyjne);
        this.nrKandydata = nrKandydata;
    }

    protected int wybierzPozycjęNaLiście(int iluKandydatów) {
        if (nrKandydata <= iluKandydatów && nrKandydata > 0)
            return nrKandydata;
        throw new RuntimeException();
    }
}