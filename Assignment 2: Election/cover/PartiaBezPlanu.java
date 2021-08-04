package cover;

public class PartiaBezPlanu extends Partia {
    public PartiaBezPlanu(String nazwa, int budżet, char strategia) {
        super(nazwa, budżet, strategia);
    }

    @Override
    public boolean wybierzDziałanieIWykonaj(int[][] działania,
                                            OkręgWyborczy[] okręgiWyborcze) {
        for (int[] działanie : działania) {
            for (OkręgWyborczy okręgWyborczy : okręgiWyborcze) {
                if (czyMogęWykonaćDziałanie(działanie, okręgWyborczy)) {
                    budżet -= obliczKosztDziałania(działanie, okręgWyborczy);
                    wykonajDziałanie(działanie, okręgWyborczy);
                    return true;
                }
            }
        }
        return false;
    }
}
