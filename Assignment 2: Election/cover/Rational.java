package cover;

public class Rational {
    private int licznik;
    private int mianownik;

    private int NWD(int a, int b) {
        int pom;
        if (a < 0) {
            a *= -1;
        }
        if (b < 0) {
            b *= -1;
        }

        while (b != 0) {
            pom = b;
            b = a % b;
            a = pom;
        }

        return a;
    }

    private void skracaj() {
        int nwd = NWD(this.licznik, this.mianownik);
        this.licznik /= nwd;
        this.mianownik /= nwd;
    }

    public Rational(int p, int q) {
        this.licznik = p;
        this.mianownik = q;
        skracaj();
    }

    private int getLicznik() {
        return this.licznik;
    }

    private int getMianownik() {
        return this.mianownik;
    }


    private Rational opposite() {
        return new Rational(this.licznik * (-1), this.mianownik);
    }

    public boolean isEqual(Rational x) {
        return (this.compareTo(x) == 0);
    }

    private Rational add(Rational x) {
        int licznikCopy = this.licznik;
        int mianownikCopy = this.mianownik;
        int p = x.getLicznik();
        int q = x.getMianownik();

        if (q < 0) {
            q *= -1;
            p *= -1;
        }
        if (mianownikCopy < 0) {
            mianownikCopy *= -1;
            licznikCopy *= -1;
        }

        int nwd = NWD(mianownikCopy, q);
        int mianownikNowy = (mianownikCopy / nwd) * q;

        licznikCopy = licznikCopy * (mianownikNowy / mianownikCopy);
        p = p * (mianownikNowy / mianownikCopy);
        return new Rational(licznikCopy + p, mianownikNowy);
    }

    public Rational substract(Rational x) {
        return this.add(x.opposite());
    }

    private int sign() {
        int sigLicznik = 0;
        int sigMianownik = 0;
        if (this.licznik < 0)
            sigLicznik = -1;
        if (this.licznik > 0)
            sigLicznik = 1;
        if (this.mianownik < 0)
            sigMianownik = -1;
        if (this.mianownik > 0)
            sigMianownik = 1;
        return sigLicznik * sigMianownik;
    }

    public int compareTo(Rational x) {
        Rational c = this.substract(x);
        return c.sign();
    }

    public String toString() {
        if (this.mianownik < 0) {
            this.mianownik *= -1;
            this.licznik *= -1;
        }
        return (this.licznik + "/" + this.mianownik);
    }
}