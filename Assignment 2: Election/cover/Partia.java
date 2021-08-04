package cover;

public abstract class Partia {
    final String nazwa;
    int budżet;
    private final char strategia;
    private int otrzymaneMandatyWOstatnimGłosowaniu;

    Partia(String nazwa, int budżet, char strategia) {
        this.nazwa = nazwa;
        this.budżet = budżet;
        this.strategia = strategia;
    }

    int obliczKosztDziałania(int[] działanie,
                             OkręgWyborczy okręgWyborczy) {
        int koszt = 0;
        int liczbaWyborców = okręgWyborczy.getLiczbaWyborców();
        for (int waga : działanie)
            koszt += Math.abs(waga);
        return koszt * liczbaWyborców;
    }

    void wykonajDziałanie(int[] działanie, OkręgWyborczy okręgWyborczy) {
        if (czyMogęWykonaćDziałanie(działanie, okręgWyborczy)) {
            Wyborca[] wyborcy = okręgWyborczy.getListaWyborców();
            for (Wyborca wyborca : wyborcy) {
                if (wyborca.czyJestWyborcąWszyschstronnymBezpartyjnym())
                    wyborca.zastosujDziałanie(działanie);
            }
        }
    }

    boolean czyMogęWykonaćDziałanie(int[] działanie,
                                    OkręgWyborczy okręgWyborczy) {
        int koszt = obliczKosztDziałania(działanie, okręgWyborczy);
        return (koszt <= budżet && koszt > 0);
    }

    public abstract boolean wybierzDziałanieIWykonaj
            (int[][] działania, OkręgWyborczy[] okręgiWyborcze);

    void zerujOtrzymaneMandatyWOstatnimGłosowaniu() {
        this.otrzymaneMandatyWOstatnimGłosowaniu = 0;
    }

    public void otrzymajMandaty(int ile) {
        this.otrzymaneMandatyWOstatnimGłosowaniu += ile;
    }

    public int getOtrzymaneMandatyWOstatnimGłosowaniu() {
        return otrzymaneMandatyWOstatnimGłosowaniu;
    }
}
