package com.company;

public class Licytator {
    private static int dajIndeksKolejnego(int komuTerazProponuję,
                                          int iluUczestników) {
        return ((komuTerazProponuję + 1) % iluUczestników);
    }

    private static boolean czyKtośKupił(int j,
                                        int iluUczestników) {
        return j < iluUczestników;
    }

    public static Uczestnik[] przeprowadź(Przedmiot[] przedmioty,
                                          Uczestnik[] uczestnicy) {
        int ilePrzedmiotów = przedmioty.length;
        int iluUczestników = uczestnicy.length;
        int komuTerazProponuję = 0;
        Uczestnik[] Odpowiedzi = new Uczestnik[ilePrzedmiotów];

        for (int i = 0; i < ilePrzedmiotów; i++) {
            Przedmiot przedmiot = przedmioty[i];
            int j;

            for (j = 0; j < iluUczestników; j++) {
                if (uczestnicy[komuTerazProponuję].czyKupić(przedmiot)) {
                    uczestnicy[komuTerazProponuję].kup(przedmiot);
                    Odpowiedzi[i] = uczestnicy[komuTerazProponuję];
                    komuTerazProponuję = dajIndeksKolejnego(komuTerazProponuję,
                            iluUczestników);
                    break;
                }
                komuTerazProponuję = dajIndeksKolejnego(komuTerazProponuję,
                        iluUczestników);
            }
            if (!czyKtośKupił(j, iluUczestników)) {
                Odpowiedzi[i] = null;
            }
        }
        return Odpowiedzi;
    }
}
