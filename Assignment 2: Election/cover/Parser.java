package cover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

class Parser {

    static class NiepoprawnyFormatWejścia extends RuntimeException {
    }

    private Scanner odczytPliku;
    private int liczbaPodstawowychOkręgów;
    private int liczbaPartii;
    private int liczbaMożliwychDziałań;
    private int liczbaCechKażdegoKandydata;
    private int liczbaOkręgówDoScalenia;
    private int[] okręgiDoScaleniaZWyższymNumerem;

    Partia[] partie;
    String[] nazwyPartii;
    private int[] budżetyPartii;
    private char[] strategiePartii;

    private int[] liczbaWyborcówWOkręgu;

    private KomitetWyborczy[][] komitetyWyborcze;

    private OkręgWyborczy[] okręgiWyborcze;

    private final Pattern domyślnieOmijaneZnaki = Pattern.compile("\\p{javaWhitespace}+");

    private int[][] działania;

    private void zakończWczytywanieDanychZLinii() {
        odczytPliku.nextLine();
    }

    public Parser() throws FileNotFoundException {
        Scanner odczytNazwyPliku = new Scanner(System.in);
        String nazwaPliku = odczytNazwyPliku.nextLine();
        File plikWejściowy = new File(nazwaPliku);
        this.odczytPliku = new Scanner(plikWejściowy);
    }

    private void wczytajPodstawoweDaneOBajtocji() {
        this.liczbaPodstawowychOkręgów = odczytPliku.nextInt();
        this.liczbaPartii = odczytPliku.nextInt();
        this.liczbaMożliwychDziałań = odczytPliku.nextInt();
        this.liczbaCechKażdegoKandydata = odczytPliku.nextInt();
        this.komitetyWyborcze =
                new KomitetWyborczy[liczbaPodstawowychOkręgów][liczbaPartii];
        zakończWczytywanieDanychZLinii();
        okręgiWyborcze = new OkręgWyborczy[liczbaPodstawowychOkręgów];
    }

    private void wczytajParyOkręgówDoScalenia() {
        this.liczbaOkręgówDoScalenia = odczytPliku.nextInt();
        this.okręgiDoScaleniaZWyższymNumerem = new int[liczbaOkręgówDoScalenia];
        Pattern tymczasowoOmijaneZnaki =
                Pattern.compile("(\\s*[(])|(,)|([)]\\s*[(])|([)]\\s*)");
        odczytPliku.useDelimiter(tymczasowoOmijaneZnaki);

        for (int i = 0; i < liczbaOkręgówDoScalenia; i++) {
            int okręg1 = odczytPliku.nextInt();
            int okręg2 = odczytPliku.nextInt();
            if (okręg2 == okręg1 + 1)
                okręgiDoScaleniaZWyższymNumerem[i] = okręg1;
            else
                throw new NiepoprawnyFormatWejścia();
        }
        odczytPliku.useDelimiter(domyślnieOmijaneZnaki);
        zakończWczytywanieDanychZLinii();
    }

    private void wczytajNazwyPartii() {
        this.nazwyPartii = new String[liczbaPartii];
        for (int i = 0; i < liczbaPartii; i++) {
            String nazwaPartii = odczytPliku.next();
            nazwyPartii[i] = nazwaPartii;
        }
        zakończWczytywanieDanychZLinii();
    }

    private void wczytajBudżetyPartii() {
        this.budżetyPartii = new int[liczbaPartii];
        for (int i = 0; i < liczbaPartii; i++) {
            int budżet = odczytPliku.nextInt();
            this.budżetyPartii[i] = budżet;
        }
        zakończWczytywanieDanychZLinii();
    }

    private void wczytajStrategiePartiiOrazStwórzPartie() {
        this.strategiePartii = new char[liczbaPartii];
        this.partie = new Partia[liczbaPartii];

        for (int i = 0; i < liczbaPartii; i++) {
            String strategia = odczytPliku.next();
            switch (strategia) {
                case "R":
                    partie[i] = new PartiaZRozmachem(nazwyPartii[i],
                            budżetyPartii[i], 'R');
                    break;
                case "S":
                    partie[i] = new PartiaSkromna(nazwyPartii[i],
                            budżetyPartii[i], 'S');
                    break;
                case "W":
                    partie[i] = new PartiaBezPlanu(nazwyPartii[i],
                            budżetyPartii[i], 'W');
                    break;
                case "Z":
                    partie[i] = new PartiaZachłanna(nazwyPartii[i],
                            budżetyPartii[i], 'Z');
                    break;
                default:
                    throw new NiepoprawnyFormatWejścia();
            }
        }

        zakończWczytywanieDanychZLinii();
    }

    public Partia getPartia(int x) {
        return partie[x];
    }

    private void wczytajLiczbęWyborcówWOkręgach() {
        this.liczbaWyborcówWOkręgu = new int[liczbaPodstawowychOkręgów];
        for (int i = 0; i < liczbaPodstawowychOkręgów; i++) {
            int liczbaWyborców = odczytPliku.nextInt();
            this.liczbaWyborcówWOkręgu[i] = liczbaWyborców;
        }
        zakończWczytywanieDanychZLinii();
    }

    private Kandydat wczytajIZwróćKandydata() {
        String imię = odczytPliku.next();
        String nazwisko = odczytPliku.next();
        int nrOkręgu = odczytPliku.nextInt();
        String nazwaPartii = odczytPliku.next();
        int pozycjaNaLiście = odczytPliku.nextInt();
        int[] cechy = new int[liczbaCechKażdegoKandydata];
        for (int i = 0; i < liczbaCechKażdegoKandydata; i++) {
            cechy[i] = odczytPliku.nextInt();
        }
        zakończWczytywanieDanychZLinii();
        return new Kandydat(imię, nazwisko, nazwaPartii,
                nrOkręgu, pozycjaNaLiście, cechy);

    }

    private void wczytajKandydatówDoKomitetów() {
        for (int i = 0; i < liczbaPodstawowychOkręgów; i++) {
            for (int j = 0; j < liczbaPartii; j++) {
                int liczbaKandydatówWOkręgu = liczbaWyborcówWOkręgu[i] / 10;
                Kandydat[] kandydaci = new Kandydat[liczbaKandydatówWOkręgu];

                for (int z = 0; z < liczbaKandydatówWOkręgu; z++) {
                    kandydaci[z] = wczytajIZwróćKandydata();
                }
                KomitetWyborczy komitet = new KomitetWyborczy(i + 1,
                        nazwyPartii[j], kandydaci);
                komitetyWyborcze[i][j] = komitet;
            }
        }
    }

    private Wyborca wczytajWyborcę() {
        String imię = odczytPliku.next();
        String nazwisko = odczytPliku.next();
        int nrOkręgu = odczytPliku.nextInt();
        int typWyborcy = odczytPliku.nextInt();
        Wyborca nowyWyborca;
        if (typWyborcy == 1 || typWyborcy == 2) {
            String nazwaPartii = odczytPliku.next();
            if (typWyborcy == 2) {
                int indeksKandydata = odczytPliku.nextInt();
                nowyWyborca = new ŻelaznyElektoratKandydata(imię, nazwisko,
                        nrOkręgu, nazwaPartii, indeksKandydata);
            } else {
                nowyWyborca = new ŻelaznyElektoratPartyjny(imię, nazwisko,
                        nrOkręgu, nazwaPartii);
            }
        } else if (typWyborcy == 5 || typWyborcy == 8) {
            int[] wagiCech = new int[liczbaCechKażdegoKandydata];
            for (int i = 0; i < liczbaCechKażdegoKandydata; i++) {
                int waga = odczytPliku.nextInt();
                wagiCech[i] = waga;
            }

            if (typWyborcy == 8) {
                String nazwaPartii = odczytPliku.next();
                nowyWyborca = new Wszechstronny(imię, nazwisko, nrOkręgu,
                        nazwaPartii, wagiCech);
            } else {
                nowyWyborca = new Wszechstronny(imię, nazwisko, nrOkręgu,
                        wagiCech);
            }
        } else if (3 <= typWyborcy && typWyborcy <= 7) {
            int preferowanaCecha = odczytPliku.nextInt();
            if (typWyborcy >= 6) {
                String preferowanaPartia = odczytPliku.next();
                if (typWyborcy == 6)
                    nowyWyborca = new JednocechowyMinimalizujący(imię, nazwisko,
                            nrOkręgu, preferowanaPartia,
                            preferowanaCecha);
                else
                    nowyWyborca = new JednocechowyMaksymalizujący(imię,
                            nazwisko, nrOkręgu, preferowanaPartia,
                            preferowanaCecha);
            } else {
                if (typWyborcy == 3)
                    nowyWyborca = new JednocechowyMinimalizujący(imię, nazwisko,
                            nrOkręgu, preferowanaCecha);
                else
                    nowyWyborca = new JednocechowyMaksymalizujący(imię,
                            nazwisko, nrOkręgu, preferowanaCecha);
            }
        } else
            throw new RuntimeException();
        return nowyWyborca;
    }

    private void wczytajWyborcówIStwórzPodstawoweOkręgi() {
        for (int i = 0; i < liczbaPodstawowychOkręgów; i++) {
            Wyborca[] wyborcy = new Wyborca[liczbaWyborcówWOkręgu[i]];
            for (int j = 0; j < liczbaWyborcówWOkręgu[i]; j++) {
                wyborcy[j] = wczytajWyborcę();
            }
            okręgiWyborcze[i] = new OkręgWyborczy(i + 1, liczbaWyborcówWOkręgu[i],
                    komitetyWyborcze[i], wyborcy);
        }
        zakończWczytywanieDanychZLinii();
    }

    private void wczytajMożliweDziałania() {
        this.działania =
                new int[liczbaMożliwychDziałań][liczbaCechKażdegoKandydata];
        for (int i = 0; i < liczbaMożliwychDziałań; i++) {
            for (int j = 0; j < liczbaCechKażdegoKandydata; j++) {
                int waga = odczytPliku.nextInt();
                this.działania[i][j] = waga;
            }
        }
    }


    public void parsujPlikWejściowy() {
        wczytajPodstawoweDaneOBajtocji();
        wczytajParyOkręgówDoScalenia();
        wczytajNazwyPartii();
        wczytajBudżetyPartii();
        wczytajStrategiePartiiOrazStwórzPartie();
        wczytajLiczbęWyborcówWOkręgach();
        wczytajKandydatówDoKomitetów();
        wczytajWyborcówIStwórzPodstawoweOkręgi();
        wczytajMożliweDziałania();
    }

    public int getLiczbaPodstawowychOkręgów() {
        return liczbaPodstawowychOkręgów;
    }

    public int getLiczbaPartii() {
        return liczbaPartii;
    }

    public int getLiczbaOkręgówDoScalenia() {
        return liczbaOkręgówDoScalenia;
    }

    public int[] getOkręgiDoScaleniaZWyższymNumerem() {
        return okręgiDoScaleniaZWyższymNumerem;
    }

    public OkręgWyborczy getOkręgWyborczy(int indeks) {
        return okręgiWyborcze[indeks];
    }

    public int[][] getDziałania() {
        return działania;
    }
}
