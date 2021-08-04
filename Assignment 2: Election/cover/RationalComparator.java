package cover;

import javafx.util.Pair;

import java.util.Comparator;

class RationalComparator implements Comparator<Pair<Rational, KomitetWyborczy>> {
    @Override
    public int compare(Pair<Rational, KomitetWyborczy> p1,
                       Pair<Rational, KomitetWyborczy> p2) {
        Rational r1 = p1.getKey();
        Rational r2 = p2.getKey();
        return r2.compareTo(r1);
    }
}