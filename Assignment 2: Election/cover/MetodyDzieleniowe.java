package cover;

import javafx.util.Pair;

import java.util.PriorityQueue;

public abstract class MetodyDzieleniowe extends MetodaLiczeniaGłosów {
    protected abstract int getKolejnyDzielnik(KomitetWyborczy komitetWyborczy);

    protected Pair<Rational, KomitetWyborczy> stwórzParęRational
            (KomitetWyborczy komitetWyborczy, OkręgWyborczy okręgWyborczy) {
        Rational r = new Rational(komitetWyborczy.getOtrzymaneGłosy(),
                getKolejnyDzielnik(komitetWyborczy));
        return new Pair<>(r, komitetWyborczy);
    }

    @Override
    protected void opcjonalnieUzupełnijKolejkę(
            PriorityQueue<Pair<Rational, KomitetWyborczy>> kolejkaDoKoryta,
            OkręgWyborczy okręgWyborczy, KomitetWyborczy komitetWyborczy) {
        kolejkaDoKoryta.add(stwórzParęRational(komitetWyborczy, okręgWyborczy));
    }

    @Override
    protected int ileMandatówDoPrzydzielenia(OkręgWyborczy okręgWyborczy) {
        return okręgWyborczy.getLiczbaWyborców() / 10;
    }
}
