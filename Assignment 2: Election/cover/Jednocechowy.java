package cover;

public abstract class Jednocechowy extends Cechowy {
    private final int faworyzowanaCecha;
    private final int przelicznik;

    Jednocechowy(String imię, String nazwisko,
                 int numerOkręguWyborczego,
                 String przywiązaniePartyjne, int faworyzowanaCecha,
                 int przelicznik) {
        super(imię, nazwisko, numerOkręguWyborczego, przywiązaniePartyjne);
        this.faworyzowanaCecha = faworyzowanaCecha;
        this.przelicznik = przelicznik;
    }


    @Override
    protected int obliczWynikDlaKandydata(int[] cechyKandydata) {
        return cechyKandydata[faworyzowanaCecha - 1] * przelicznik;
    }
}