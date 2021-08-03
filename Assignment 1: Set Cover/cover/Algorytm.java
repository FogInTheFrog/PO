package cover;

import java.util.ArrayList;

public abstract class Algorytm {
    protected static int ileNowychPokryjeZbiór(ArrayList<Integer> coZbiórPokrywa,
                                               boolean[] pokryte) {
        int ileNowychPokryjeZbiór = 0;
        for (int i : coZbiórPokrywa) {
            if (pokryte[i] == false) {
                ileNowychPokryjeZbiór++;
            }
        }
        return ileNowychPokryjeZbiór;
    }

    protected static void pokryjZbiorem(ArrayList<Integer> coZbiórPokrywa,
                                        boolean[] pokryte) {
        for (int i : coZbiórPokrywa) {
            pokryte[i] = true;
        }
    }
}