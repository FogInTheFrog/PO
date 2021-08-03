package cover;

import java.util.ArrayList;

public class HeurystykaNaiwna extends Algorytm {
    public static ArrayList<Integer> znajdźPokrycie(int zakres,
                                                    ArrayList<Zbior> Zbiory) {
        boolean[] pokryte = new boolean[-zakres + 1];
        int ilePokrytych = 0;
        ArrayList<Integer> Odpowiedzi = new ArrayList<Integer>();

        for (Zbior zbior : Zbiory) {
            int numer = zbior.getNumer();
            ArrayList<Integer> coZbiórPokrywa = zbior.jakiePolaPokryję(zakres);
            int ileElementówPokryjeZbiór =
                    ileNowychPokryjeZbiór(coZbiórPokrywa, pokryte);

            if (ileElementówPokryjeZbiór > 0) {
                Odpowiedzi.add(numer);
                ilePokrytych += ileElementówPokryjeZbiór;
                pokryjZbiorem(coZbiórPokrywa, pokryte);
            }
        }

        if (ilePokrytych != -zakres) {
            Odpowiedzi.clear();
            Odpowiedzi.add(0);
        }
        return Odpowiedzi;
    }
}