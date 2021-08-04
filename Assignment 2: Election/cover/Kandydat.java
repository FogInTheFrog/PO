package cover;

import java.util.Arrays;

public class Kandydat {
    private final String imię;
    private final String nazwisko;
    private final String przynależnośćPartyjna;
    private final int nrOkręgu;
    private final int nrNaLiście;
    private final int[] cechy;
    private int otrzymaneGłosy = 0;

    public Kandydat(String imię, String nazwisko, String przynależnośćPartyjna,
                    int nrOkręgu, int nrNaLiście, int[] cechy) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.przynależnośćPartyjna = przynależnośćPartyjna;
        this.nrOkręgu = nrOkręgu;
        this.nrNaLiście = nrNaLiście;
        this.cechy = cechy;
    }

    @Override
    public String toString() {
        return "Kandydat{" +
                "imię='" + imię + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", przynależnośćPartyjna='" + przynależnośćPartyjna + '\'' +
                ", nrOkręgu=" + nrOkręgu +
                ", nrNaLiście=" + nrNaLiście +
                ", cechy=" + Arrays.toString(cechy) +
                ", otrzymaneGłosy=" + otrzymaneGłosy +
                '}';
    }

    public int[] getCechy() {
        return cechy;
    }

    public int getOtrzymaneGłosy() {
        return otrzymaneGłosy;
    }

    public String getPrzynależnośćPartyjna() {
        return przynależnośćPartyjna;
    }

    public int getNrNaLiście() {
        return nrNaLiście;
    }

    public String getImię() {
        return imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void zagłosuj() {
        otrzymaneGłosy++;
    }
}
