package cover;

public class PartiaZachłanna extends Partia {
    public PartiaZachłanna(String nazwa, int budżet, char strategia) {
        super(nazwa, budżet, strategia);
    }

    //Działania nie wpływają na kandydatów, tylko na wyborców
    @Override
    public boolean wybierzDziałanieIWykonaj(int[][] działania, OkręgWyborczy[]
            okręgiWyborcze) {
        for (int[] działanie : działania) {
            for (OkręgWyborczy okręgWyborczy : okręgiWyborcze) {
                if (czyMogęWykonaćDziałanie(działanie, okręgWyborczy)) {
                    int koszt = obliczKosztDziałania(działanie,
                            okręgWyborczy);
                    budżet -= koszt;
                    wykonajDziałanie(działanie, okręgWyborczy);
                    return true;
                }
            }
        }
        return false;
    }
}
