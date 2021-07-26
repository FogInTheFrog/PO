class Rational {
    private int licznik;
    private int mianownik;

    public int NWD (int a, int b) {
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

    public Rational (int n) {
        this.licznik = n;
        this.mianownik = 1;
    }

    public Rational (int p, int q) {
        this.licznik = p;
        this.mianownik = q;
        skracaj();
    }

    static Rational zero() {
        return new Rational(0, 1);
    }

    static Rational jeden() {
        return new Rational(1, 1);
    }

    public int getLicznik() {
        return this.licznik;
    }

    public int getMianownik() {
        return this.mianownik;
    }

    public Rational inverse() {
        return new Rational(this.mianownik, this.licznik);
    }

    public Rational opposite() {
        return new Rational(this.licznik * (-1), this.mianownik);
    }

    public Rational add(Rational x) {
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

        licznikCopy = licznikCopy * (mianownikNowy/mianownikCopy);
        p = p * (mianownikNowy/mianownikCopy);
        return new Rational(licznikCopy + p, mianownikNowy);
    }

    public Rational substract(Rational x) {
        return this.add(x.opposite());
    }

    public Rational multiply(Rational x) {
        int licznikcopy = this.licznik;
        int mianownikcopy = this.mianownik;
        int p = x.getLicznik();
        int q = x.getMianownik();
        int nwdLicznikq = NWD(this.licznik, q);
        int nwdMianownikp = NWD(this.mianownik, p);

        licznikcopy /= nwdLicznikq;
        q /= nwdLicznikq;
        mianownikcopy /= nwdMianownikp;
        p /= nwdMianownikp;

        return new Rational(licznikcopy * p, mianownikcopy * q);
    }

    public Rational divide(Rational x) {
        return this.multiply(x.inverse());
    }

    public int sign() {
        int sigLicznik = 0;
        int sigMianownik = 0;
        if (sigLicznik < 0)
            sigLicznik = -1;
        if (sigLicznik > 0)
            sigLicznik = 1;
        if (sigMianownik < 0)
            sigMianownik = -1;
        if (sigMianownik > 0)
            sigMianownik = 1;
        return sigLicznik * sigMianownik;
    }

    public int numerator() {
        return this.licznik;
    }

    public int denominator() {
        return this.mianownik;
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

public class Main {
    public static void main(String[] args) {
        System.out.println(agrs[0], args[1], args[2])
        Rational a = new Rational(3, -9);
        Rational b = new Rational(-8, 3);
        Rational c = a.add(b);
        Rational d = a.substract(b);
        Rational e = a.multiply(b);
        Rational f = a.divide(b);
        System.out.println(Rational.jeden().toString());
        System.out.println(Rational.zero().toString());
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());
        System.out.println(a.sign());
        System.out.println(a.numerator());
        System.out.println(a.denominator());
    }
}
