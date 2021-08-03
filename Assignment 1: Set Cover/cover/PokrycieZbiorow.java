package cover;

import java.util.ArrayList;

public class PokrycieZbiorow {
    private static boolean isZbiór(Dane dane) {
        return dane.getClass() == Zbior.class;
    }

    private static boolean isZapytanie(Dane dane) {
        return dane.getClass() == Zapytanie.class;
    }

    private static ArrayList<Integer> rozpoznajAlgorytm(int d, int u,
                                                        ArrayList<Zbior> zbiory) {
        ArrayList<Integer> odpowiedzi = new ArrayList<Integer>();

        if (d == 1) {
            odpowiedzi = AlgorytmDokladny.znajdźPokrycie(u, zbiory);
        } else if (d == 2) {
            odpowiedzi = HeurystykaZachlanna.znajdźPokrycie(u, zbiory);
        } else if (d == 3) {
            odpowiedzi = HeurystykaNaiwna.znajdźPokrycie(u, zbiory);
        }
        return odpowiedzi;
    }

    private static void wypiszOdpowiedzi(ArrayList<Integer> odpowiedzi) {
        for (int j = 0; j < odpowiedzi.size(); j++) {
            if (j == 0) System.out.print(odpowiedzi.get(j));
            else System.out.print(" " + odpowiedzi.get(j));
        }
        System.out.println();
    }

    public static void Pokryj() {
        ArrayList<Zbior> zbiory = new ArrayList<Zbior>();
        Parser parser = new Parser();
        parser.wczytajDane();
        ArrayList<Dane> listaDanych = parser.zwróćDane();

        for (Dane i : listaDanych) {
            if (isZbiór(i)) {
                zbiory.add((Zbior) i);
            } else if (isZapytanie(i)) {
                int u = ((Zapytanie) i).getU();
                int d = ((Zapytanie) i).getD();

                ArrayList<Integer> odpowiedzi = rozpoznajAlgorytm(d, u, zbiory);
                wypiszOdpowiedzi(odpowiedzi);
            }
        }
    }
}