package cover;

public class Wszechstronny extends Cechowy {
    private final int[] wartościBazoweWag;

    public Wszechstronny(String imię, String nazwisko,
                         int numerOkręguWyborczego,
                         int[] wartościBazoweWag) {
        super(imię, nazwisko, numerOkręguWyborczego, null);
        this.wartościBazoweWag = wartościBazoweWag;
    }

    public Wszechstronny(String imię, String nazwisko,
                         int numerOkręguWyborczego,
                         String przywiązaniePartyjne,
                         int[] wartościBazoweWag) {
        super(imię, nazwisko, numerOkręguWyborczego, przywiązaniePartyjne);
        this.wartościBazoweWag = wartościBazoweWag;
    }

    @Override
    boolean czyJestWyborcąWszyschstronnymBezpartyjnym() {
        return !czyJestPrzywiązanyPartyjnie();
    }

    @Override
    protected void zastosujDziałanie(int[] działanie) {
        if (czyJestWyborcąWszyschstronnymBezpartyjnym()) {
            for (int i = 0; i < wartościBazoweWag.length; i++) {
                int nowaWartość = Math.max(Math.min(wartościBazoweWag[i] +
                        działanie[i], 100), -100);
                wartościBazoweWag[i] = nowaWartość;
            }
        }
    }

    @Override
    protected int obliczWynikDlaKandydata(int[] cechyKandydata) {
        int wynikDlaKandydata = 0;
        for (int i = 0; i < wartościBazoweWag.length; i++) {
            wynikDlaKandydata += cechyKandydata[i] * wartościBazoweWag[i];
        }
        return wynikDlaKandydata;
    }
}
