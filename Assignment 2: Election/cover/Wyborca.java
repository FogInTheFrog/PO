package cover;

public abstract class Wyborca {
    final String imię;
    final String nazwisko;
    private final int numerOkręguWyborczego;
    private boolean czyOddałGłos = false;
    private Kandydat naKogoGłosował = null;
    final String przywiązaniePartyjne;


    boolean czyJestWyborcąWszyschstronnymBezpartyjnym() {
        return false;
    }

    void zastosujDziałanie(int[] działanie) {
        throw new RuntimeException();
    }

    protected abstract Kandydat wybierzKandydata(KartaWyborcza kartaWyborcza);

    public void głosuj(KartaWyborcza kartaWyborcza) {
        if (czyOddałGłos) {
            System.out.println("Już głosował");
            throw new RuntimeException();
        }
        czyOddałGłos = true;
        Kandydat wybranyKandydat = wybierzKandydata(kartaWyborcza);
        naKogoGłosował = wybranyKandydat;
        wybranyKandydat.zagłosuj();
    }

    Wyborca(String imię, String nazwisko, int numerOkręguWyborczego,
            String przywiązaniePartyjne) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.numerOkręguWyborczego = numerOkręguWyborczego;
        this.przywiązaniePartyjne = przywiązaniePartyjne;
    }

    public Kandydat getNaKogoGłosował() {
        return naKogoGłosował;
    }

    boolean czyJestPrzywiązanyPartyjnie() {
        return this.przywiązaniePartyjne == null;
    }

    @Override
    public String toString() {
        return "Wyborca{" +
                "imię='" + imię + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numerOkręguWyborczego=" + numerOkręguWyborczego +
                ", czyOddałGłos=" + czyOddałGłos +
                ", naKogoGłosował=" + naKogoGłosował +
                ", przywiązaniePartyjne='" + przywiązaniePartyjne + '\'' +
                '}';
    }
}