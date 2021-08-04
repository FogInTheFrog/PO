package cover;

import java.util.Random;

public class ŻelaznyElektoratPartyjny extends ŻelaznyElektorat {

    public ŻelaznyElektoratPartyjny(String imię, String nazwisko,
                                    int numberOkręguWyborczego,
                                    String przywiązaniePartyjne) {
        super(imię, nazwisko, numberOkręguWyborczego, przywiązaniePartyjne);
    }

    private int losujPozycję(int iluKandydatów) {
        Random random = new Random();
        int pozycjaNaLiście = random.nextInt(iluKandydatów);
        return pozycjaNaLiście + 1;
    }

    @Override
    protected int wybierzPozycjęNaLiście(int iluKandydatów) {
        return losujPozycję(iluKandydatów);
    }

}