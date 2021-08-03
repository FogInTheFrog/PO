package cover;

import java.util.ArrayList;
import java.util.Collections;

public class HeurystykaZachlanna extends Algorytm {
    public static ArrayList<Integer> znajdźPokrycie(int zakres,
                                                    ArrayList<Zbior> Zbiory) {
        boolean[] pokryte = new boolean[1 - zakres];
        int ilePokrytych = 0;
        ArrayList<Integer> Odpowiedzi = new ArrayList<Integer>();

        while (ilePokrytych < -zakres) {
            int ileNajwięcejMogęPokryć = 0, indeksTegoZbioru = 0;
            ArrayList<Integer> pokrywaneElementy = new ArrayList<Integer>();
            for (Zbior zbior : Zbiory) {
                ArrayList<Integer> coZbiórPokrywa = zbior.jakiePolaPokryję(zakres);
                int ileZbiórPokrywa =
                        ileNowychPokryjeZbiór(coZbiórPokrywa, pokryte);
                if (ileZbiórPokrywa > ileNajwięcejMogęPokryć) {
                    ileNajwięcejMogęPokryć = ileZbiórPokrywa;
                    indeksTegoZbioru = zbior.getNumer();
                    pokrywaneElementy = coZbiórPokrywa;
                }
            }
            if (ileNajwięcejMogęPokryć == 0) {
                Odpowiedzi.clear();
                Odpowiedzi.add(0);
                break;
            } else {
                Odpowiedzi.add(indeksTegoZbioru);
                pokryjZbiorem(pokrywaneElementy, pokryte);
                ilePokrytych += ileNajwięcejMogęPokryć;
            }
        }
        Collections.sort(Odpowiedzi);
        return Odpowiedzi;
    }
}