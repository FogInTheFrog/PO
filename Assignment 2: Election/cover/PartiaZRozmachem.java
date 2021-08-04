package cover;

public class PartiaZRozmachem extends Partia {
    public PartiaZRozmachem(String nazwa, int budżet, char strategia) {
        super(nazwa, budżet, strategia);
    }

    @Override
    public boolean wybierzDziałanieIWykonaj(int[][] działania, OkręgWyborczy[]
            okręgiWyborcze) {
        int faworytI = 0, faworytJ = 0, faworytKoszt = -1;
        for (int i = 0; i < działania.length; i++) {
            for (int j = 0; j < okręgiWyborcze.length; j++) {
                if (czyMogęWykonaćDziałanie(działania[i], okręgiWyborcze[j])) {
                    int koszt = obliczKosztDziałania(działania[i],
                            okręgiWyborcze[j]);
                    if (faworytKoszt < koszt) {
                        faworytI = i;
                        faworytJ = j;
                        faworytKoszt = koszt;
                    }
                }
            }
        }
        if (faworytKoszt > 0) {
            budżet -= faworytKoszt;
            wykonajDziałanie(działania[faworytI], okręgiWyborcze[faworytJ]);
            return true;
        }
        return false;
    }
}
