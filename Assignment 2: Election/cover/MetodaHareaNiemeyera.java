package cover;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class MetodaHareaNiemeyera extends MetodaLiczeniaGłosów {

    private int ilePewnychMandatów(KomitetWyborczy komitetWyborczy,
                                   int sumaOddanychGłosówWOkręgu,
                                   int liczbaMandatówDoPrzydzielenia) {
        return (komitetWyborczy.getOtrzymaneGłosy() *
                liczbaMandatówDoPrzydzielenia) / sumaOddanychGłosówWOkręgu;
    }

    @Override
    protected Pair<Rational, KomitetWyborczy> stwórzParęRational
            (KomitetWyborczy komitet, OkręgWyborczy okręgWyborczy) {
        Rational r1 = new Rational(komitet.getOtrzymaneGłosy() *
                okręgWyborczy.getLiczbaWyborców() / 10,
                okręgWyborczy.getLiczbaWyborców());
        Rational r2 = new Rational(ilePewnychMandatów(komitet,
                okręgWyborczy.getLiczbaWyborców() / 10,
                okręgWyborczy.getLiczbaWyborców()), 1);
        return new Pair<>(r1.substract(r2), komitet);
    }

    @Override
    protected void opcjonalnieUzupełnijKolejkę(
            PriorityQueue<Pair<Rational, KomitetWyborczy>> kolejkaDoKoryta,
            OkręgWyborczy okręgWyborczy, KomitetWyborczy komitetWyborczy) {
    }

    private void przydzielPewneMandaty(KomitetWyborczy komitetWyborczy,
                                       int sumaOddanychGłosówWOkręgu,
                                       int liczbaMandatówDoPrzydzielenia) {
        int ile = ilePewnychMandatów(komitetWyborczy, sumaOddanychGłosówWOkręgu,
                liczbaMandatówDoPrzydzielenia);
        for (int i = 0; i < ile; i++)
            komitetWyborczy.otrzymajMandat();
    }

    @Override
    protected int ileMandatówDoPrzydzielenia(OkręgWyborczy okręgWyborczy) {
        int mandatyDoPrzydzieleniaWOkręgu =
                okręgWyborczy.getLiczbaWyborców() / 10;
        int przydzielonePewneMandaty = 0;
        KomitetWyborczy[] komitetyWyborcze =
                okręgWyborczy.getListaKomitetówWyborczych();

        for (KomitetWyborczy komitetWyborczy : komitetyWyborcze) {
            przydzielPewneMandaty(komitetWyborczy,
                    okręgWyborczy.getLiczbaWyborców(),
                    mandatyDoPrzydzieleniaWOkręgu);

            przydzielonePewneMandaty += ilePewnychMandatów(komitetWyborczy,
                    okręgWyborczy.getLiczbaWyborców(),
                    mandatyDoPrzydzieleniaWOkręgu);
        }
        return mandatyDoPrzydzieleniaWOkręgu - przydzielonePewneMandaty;
    }
}
