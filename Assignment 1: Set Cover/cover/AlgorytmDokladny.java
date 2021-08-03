package cover;

import java.util.ArrayList;

public class AlgorytmDokladny extends Algorytm {

    //zwraca prawdę, gdy istniejsze większy leksykograficznie wybór elementów
    private static boolean dajNowyZbiór(int[] zaznaczoneZbiory,
                                        int ileElementówMogęWybrać,
                                        int ileJestZbiorów) {
        if (zaznaczoneZbiory[ileElementówMogęWybrać - 1] < ileJestZbiorów) {
            zaznaczoneZbiory[ileElementówMogęWybrać - 1]++;
            return true;
        }
        for (int i = ileElementówMogęWybrać - 2; i >= 0; i--) {
            if (zaznaczoneZbiory[i] + ileElementówMogęWybrać - i <= ileJestZbiorów) {
                zaznaczoneZbiory[i]++;
                for (int j = i + 1; j < ileElementówMogęWybrać; j++) {
                    zaznaczoneZbiory[j] = zaznaczoneZbiory[j - 1] + 1;
                }
                return true;
            }
        }
        return false;
    }

    private static boolean czyPokryłemCałyZakres(int ilePokryłem, int zakres) {
        return ilePokryłem == -zakres;
    }

    private static int[] przygotujWybraneZbiory(int ileZbiorów) {
        int[] wybraneZbiory = new int[ileZbiorów];
        for (int i = 0; i < ileZbiorów; i++)
            wybraneZbiory[i] = i + 1;
        return wybraneZbiory;
    }

    public static ArrayList<Integer> znajdźPokrycie(int zakres,
                                                    ArrayList<Zbior> zbiory) {
        ArrayList<Integer> Odpowiedzi = new ArrayList<Integer>();

        int l = 1, p = zbiory.size();
        while (l <= p) {
            int mid = (l + p) / 2;
            int[] wybraneZbiory = przygotujWybraneZbiory(mid);
            boolean czyUdałoSięPokryć = false;
            do {
                int ilePokryłem = 0;
                boolean[] pokryte = new boolean[-zakres + 1];
                for (int nr : wybraneZbiory) {
                    ArrayList<Integer> coPokryjeZbiór =
                            zbiory.get(nr - 1).jakiePolaPokryję(zakres);
                    ilePokryłem += ileNowychPokryjeZbiór(coPokryjeZbiór, pokryte);
                    pokryjZbiorem(coPokryjeZbiór, pokryte);
                }
                if (czyPokryłemCałyZakres(ilePokryłem, zakres)) {
                    Odpowiedzi.clear();
                    for (int nr : wybraneZbiory) {
                        Odpowiedzi.add(nr);
                    }
                    czyUdałoSięPokryć = true;
                    break;
                }
            } while (AlgorytmDokladny.dajNowyZbiór(wybraneZbiory, mid, zbiory.size()));
            if (l == p) break;
            else if (czyUdałoSięPokryć) p = mid;
            else l = mid + 1;
        }
        if (Odpowiedzi.size() == 0) Odpowiedzi.add(0);
        return Odpowiedzi;
    }
}