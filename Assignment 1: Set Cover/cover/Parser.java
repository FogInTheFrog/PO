package cover;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private int ileZbiorów;
    private ArrayList<Dane> listaDanych;
    private Scanner scanner;

    public Parser() {
        this.listaDanych = new ArrayList<Dane>();
        this.ileZbiorów = 0;
        this.scanner = new Scanner(System.in);
    }

    private boolean czyNoweZapytanie(int a, int x) {
        return a == 0 && x < 0;
    }

    private boolean czyDrugiElementZapytania(int a, int x) {
        return a < 0 && x > 0;
    }

    private boolean czyPusty(int a, int b, int c) {
        return a == 0 && b == 0 && c == 0;
    }

    private boolean czyKoniecZbioru(int x) {
        return x == 0;
    }

    private Skladnik rozpoznajSkładnik(int a, int b, int c) {
        if (a > 0 && b == 0 && c == 0) {
            return new Element(a);
        } else if (a > 0 && b < 0 && c == 0) {
            return new Nieskonczony(a, b);
        } else if (a > 0 && b < 0 && c < 0) {
            return new Skonczony(a, b, c);
        } else {
            System.out.println("Niepoprawne dane");
            return new Skonczony(a, b, c);
        }
    }

    private boolean czyNowySkładnik(int a, int x) {
        return x > 0 && a >= 0;
    }

    private void dodajZbiórDoListyDanych
            (ArrayList<Skladnik> składnikiDoDodania) {
        this.listaDanych.add(new Zbior(składnikiDoDodania, ileZbiorów));
    }

    private boolean czyDrugiElementZbioru(int a, int b, int c, int x) {
        return a > 0 && b == 0 && c == 0 && x < 0;
    }

    private boolean czyTrzeciElementZbioru(int a, int b, int c, int x) {
        return a > 0 && b < 0 && c == 0 && x < 0;
    }

    public void wczytajDane() {
        int a = 0, b = 0, c = 0;
        ArrayList<Skladnik> składnikiDoDodania = new ArrayList<Skladnik>();
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            if (czyKoniecZbioru(x)) {
                ileZbiorów++;

                if (!czyPusty(a, b, c)) {
                    składnikiDoDodania.add(rozpoznajSkładnik(a, b, c));
                    a = 0;
                    b = 0;
                    c = 0;
                }
                dodajZbiórDoListyDanych((ArrayList<Skladnik>) składnikiDoDodania.clone());
                składnikiDoDodania.clear();
            } else if (czyNoweZapytanie(a, x)) {
                a = x;
            } else if (czyNowySkładnik(a, x)) {
                if (!czyPusty(a, b, c)) {
                    składnikiDoDodania.add(rozpoznajSkładnik(a, b, c));
                    b = 0;
                    c = 0;
                }
                a = x;
            } else if (czyDrugiElementZapytania(a, x)) {
                listaDanych.add(new Zapytanie(a, x));
                a = 0;
                b = 0;
            } else if (czyDrugiElementZbioru(a, b, c, x)) {
                b = x;
            } else if (czyTrzeciElementZbioru(a, b, c, x)) {
                c = x;
            } else {
                throw new IllegalArgumentException("Coś poszło nie tak");
            }
        }
        if (!czyPusty(a, b, c)) {
            if (a < 0) {
                throw new IllegalArgumentException("Coś poszło nie tak");
            }
            składnikiDoDodania.add(rozpoznajSkładnik(a, b, c));
        }
        if (!składnikiDoDodania.isEmpty()) {
            dodajZbiórDoListyDanych(składnikiDoDodania);
        }
        składnikiDoDodania.clear();
    }

    public ArrayList<Dane> zwróćDane() {
        return this.listaDanych;
    }
}
