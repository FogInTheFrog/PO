package com.company;

public class Rational implements Algebraic<Rational>{
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

    public int getLicznik() {
        return this.licznik;
    }

    public int getMianownik() {
        return this.mianownik;
    }

    @Override
    public String toString() {
        return "Rational{" +
                "licznik=" + licznik +
                ", mianownik=" + mianownik +
                '}';
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

}
