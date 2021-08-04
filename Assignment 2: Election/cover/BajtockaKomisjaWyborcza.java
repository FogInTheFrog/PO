package cover;

class BajtockaKomisjaWyborcza {
    private final Parser parser;
    private OkręgWyborczy[] okręgiWyborczePoScaleniu;

    public BajtockaKomisjaWyborcza(Parser parser) {
        this.parser = parser;
    }

    private void zbierzDaneOBajtocji() {
        parser.parsujPlikWejściowy();
    }

    private boolean czyMuszęScalićTenOkręg(int numerOkręgu) {
        for (int nr : parser.getOkręgiDoScaleniaZWyższymNumerem()) {
            if (nr == numerOkręgu)
                return true;
        }
        return false;
    }

    private int ileOkręgówPoScaleniu() {
        int ileDoScalenia = parser.getLiczbaOkręgówDoScalenia();
        int ilePodstawowych = parser.getLiczbaPodstawowychOkręgów();
        return ilePodstawowych - ileDoScalenia;
    }

    private void uformujOkręgiWyborcze() {
        int liczbaOkręgówPoScaleniu = ileOkręgówPoScaleniu();
        this.okręgiWyborczePoScaleniu =
                new OkręgWyborczy[liczbaOkręgówPoScaleniu];
        int indeksKolejnegoOkręgu = 0;
        for (int i = 0; i < parser.getLiczbaPodstawowychOkręgów(); i++) {
            okręgiWyborczePoScaleniu[indeksKolejnegoOkręgu] =
                    parser.getOkręgWyborczy(i);
            if (czyMuszęScalićTenOkręg(i + 1)) {
                OkręgWyborczy o2 = parser.getOkręgWyborczy(i + 1);
                okręgiWyborczePoScaleniu[indeksKolejnegoOkręgu].połączOkręgi(o2);
                i++;
            }
            indeksKolejnegoOkręgu++;
        }
    }

    private void kampaniaWyborcza() {
        int[][] działania = parser.getDziałania();
        for (int i = 0; i < parser.getLiczbaPartii(); i++) {
            Partia partia = parser.getPartia(i);
            while (partia.wybierzDziałanieIWykonaj(działania,
                    okręgiWyborczePoScaleniu)) {
            }
        }
    }

    private void przeprowadźGłosowanie() {
        for (OkręgWyborczy okręgWyborczy : okręgiWyborczePoScaleniu) {
            okręgWyborczy.przeprowadźGłosowanie();
        }
    }

    private void odbierzPrzydzieloneMandaty() {
        for (Partia partia : parser.partie)
            partia.zerujOtrzymaneMandatyWOstatnimGłosowaniu();
        for (OkręgWyborczy okręgWyborczy : okręgiWyborczePoScaleniu) {
            KomitetWyborczy[] komitetyWyborcze =
                    okręgWyborczy.getListaKomitetówWyborczych();
            for (KomitetWyborczy komitetWyborczy : komitetyWyborcze) {
                komitetWyborczy.zerujOtrzymaneMandaty();
            }
        }
    }

    private void przydzielMandaty(MetodaLiczeniaGłosów metodaLiczeniaGłosów) {
        odbierzPrzydzieloneMandaty();

        for (OkręgWyborczy okręgWyborczy : okręgiWyborczePoScaleniu) {
            metodaLiczeniaGłosów.przydzielMandaty(okręgWyborczy);
            for (int i = 0; i < parser.getLiczbaPartii(); i++) {
                KomitetWyborczy komitetWyborczy =
                        okręgWyborczy.zwróćKomitetONazwie(parser.nazwyPartii[i]);
                parser.partie[i].otrzymajMandaty(
                        komitetWyborczy.getOtrzymaneMandaty());
            }
        }
    }

        public void przeliczIWypisz(MetodaLiczeniaGłosów metodaLiczeniaGłosów) {
        przydzielMandaty(metodaLiczeniaGłosów);
        wypiszWynikiWyborów(metodaLiczeniaGłosów);
    }

    private void wypiszDaneWyborców(Wyborca[] wyborcy) {
        for (Wyborca wyborca : wyborcy) {
            Kandydat kandydat = wyborca.getNaKogoGłosował();
            System.out.println(wyborca.imię + " " + wyborca.nazwisko
                    + " " + kandydat.getImię() + " " + kandydat.getNazwisko());
        }
    }

    private void wypiszDaneKandydatów(Kandydat[] kandydaci) {
        for (Kandydat kandydat : kandydaci) {
            System.out.println(kandydat.getImię() + " " +
                    kandydat.getNazwisko() + " " +
                    kandydat.getPrzynależnośćPartyjna() + " " +
                    kandydat.getNrNaLiście() + " " +
                    kandydat.getOtrzymaneGłosy());
        }
    }

    private void wypiszWynikiWyborów(MetodaLiczeniaGłosów metodaLiczeniaGłosów) {
        System.out.println(metodaLiczeniaGłosów.getClass().getSimpleName());
        for (OkręgWyborczy okręgWyborczy : okręgiWyborczePoScaleniu) {
            System.out.println(okręgWyborczy.zwróćNumeryOkręgu());

            wypiszDaneWyborców(okręgWyborczy.getListaWyborców());
            KomitetWyborczy[] komitetyWyborcze =
                    okręgWyborczy.getListaKomitetówWyborczych();
            for (KomitetWyborczy komitetWyborczy : komitetyWyborcze)
                wypiszDaneKandydatów(komitetWyborczy.getListaKandydatów());

            for (KomitetWyborczy komitetWyborczy : komitetyWyborcze)
                System.out.println(komitetWyborczy.getNazwaPartii() + " " +
                        komitetWyborczy.getOtrzymaneMandaty());
        }
        for (Partia partia : parser.partie) {
            System.out.println(partia.nazwa + " " +
                    partia.getOtrzymaneMandatyWOstatnimGłosowaniu());
        }
    }

    public void przygotujIPrzeprowadźGłosowanie() {
        zbierzDaneOBajtocji();
        uformujOkręgiWyborcze();
        kampaniaWyborcza();
        przeprowadźGłosowanie();
    }
}
