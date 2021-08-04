package cover;

class JednocechowyMaksymalizujący extends Jednocechowy {
    private static final int przelicznik = 1;

    public JednocechowyMaksymalizujący(String imię, String nazwisko,
                                       int numberOkręguWyborczego,
                                       int faworyzowanaCecha) {
        super(imię, nazwisko, numberOkręguWyborczego, null,
                faworyzowanaCecha, przelicznik);
    }

    public JednocechowyMaksymalizujący(String imię, String nazwisko,
                                       int numberOkręguWyborczego,
                                       String przywiązaniePartyjne,
                                       int faworyzowanaCecha) {
        super(imię, nazwisko, numberOkręguWyborczego, przywiązaniePartyjne,
                faworyzowanaCecha, przelicznik);
    }
}
