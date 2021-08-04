package cover;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

abstract class MetodaLiczeniaGłosów {
    protected abstract Pair<Rational, KomitetWyborczy> stwórzParęRational
            (KomitetWyborczy komitet, OkręgWyborczy okręgWyborczy);

    private void inicjalizujKolejkę
            (PriorityQueue<Pair<Rational, KomitetWyborczy>> kolejkaDoKoryta,
             OkręgWyborczy okręgWyborczy) {
        KomitetWyborczy[] komitetyWyborcze =
                okręgWyborczy.getListaKomitetówWyborczych();

        for (KomitetWyborczy komitet : komitetyWyborcze) {
            kolejkaDoKoryta.add(stwórzParęRational(komitet, okręgWyborczy));
        }
    }

    public void przydzielMandaty(OkręgWyborczy okręgWyborczy) {
        KomitetWyborczy[] komitetyWyborcze =
                okręgWyborczy.getListaKomitetówWyborczych();

        aktualizujOtrzymaneGłosyKomitetów(komitetyWyborcze);
        obsługujRozdzielanieMandatów(okręgWyborczy);
    }

    protected abstract void opcjonalnieUzupełnijKolejkę(
            PriorityQueue<Pair<Rational, KomitetWyborczy>> kolejkaDoKoryta,
            OkręgWyborczy okręgWyborczy, KomitetWyborczy komitetWyborczy);

    private void obsługujRozdzielanieMandatów(OkręgWyborczy okręgWyborczy) {
        int mandatyDoPrzydzieleniaWKolejce =
                ileMandatówDoPrzydzielenia(okręgWyborczy);
        PriorityQueue<Pair<Rational, KomitetWyborczy>> kolejkaDoKoryta =
                new PriorityQueue<>(1,
                        new RationalComparator());

        inicjalizujKolejkę(kolejkaDoKoryta, okręgWyborczy);

        while (mandatyDoPrzydzieleniaWKolejce > 0) {
            ArrayList<KomitetWyborczy> listaRemisującychKomitetów =
                    new ArrayList<>();
            Pair<Rational, KomitetWyborczy> faworyt =
                    kolejkaDoKoryta.poll();
            listaRemisującychKomitetów.add(
                    faworyt.getValue());
            Rational wartośćRemisująca = faworyt.getKey();

            while (!kolejkaDoKoryta.isEmpty()) {
                if (kolejkaDoKoryta.peek().getKey().isEqual(wartośćRemisująca)) {
                    Pair<Rational, KomitetWyborczy> faworytRemisujący =
                            kolejkaDoKoryta.poll();
                    listaRemisującychKomitetów.add(faworytRemisujący.getValue());
                } else {
                    break;
                }
            }

            if (listaRemisującychKomitetów.size() <=
                    mandatyDoPrzydzieleniaWKolejce) {
                for (KomitetWyborczy komitet : listaRemisującychKomitetów) {
                    komitet.otrzymajMandat();
                    opcjonalnieUzupełnijKolejkę(kolejkaDoKoryta, okręgWyborczy,
                            komitet);
                    mandatyDoPrzydzieleniaWKolejce--;
                }
            } else {
                while (mandatyDoPrzydzieleniaWKolejce > 0) {
                    KomitetWyborczy wylosowanyKomitet =
                            losujKomitet(listaRemisującychKomitetów);
                    wylosowanyKomitet.otrzymajMandat();
                    listaRemisującychKomitetów.remove(wylosowanyKomitet);
                    mandatyDoPrzydzieleniaWKolejce--;
                }
            }
        }
    }

    protected abstract int ileMandatówDoPrzydzielenia
            (OkręgWyborczy okręgWyborczy);

    private KomitetWyborczy losujKomitet(ArrayList<KomitetWyborczy>
                                                 listaKomitetówRemisujących) {
        Random losuj = new Random();
        int wylosowanyIndeks = losuj.nextInt(listaKomitetówRemisujących.size());
        return listaKomitetówRemisujących.get(wylosowanyIndeks);
    }

    private void aktualizujOtrzymaneGłosyKomitetów(
            KomitetWyborczy[] listaKomitetówWyborczych) {
        for (KomitetWyborczy komitetWyborczy : listaKomitetówWyborczych)
            komitetWyborczy.zaktualizujOtrzymaneGłosy();
    }

}
