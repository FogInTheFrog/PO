package cover;

import java.util.ArrayList;

public class Zbior extends Dane {
    private ArrayList<Skladnik> listaSkładników;
    private int numer;

    public Zbior(ArrayList<Skladnik> listaSkładników, int numer) {
        this.numer = numer;
        this.listaSkładników = listaSkładników;
    }

    public int getNumer() {
        return this.numer;
    }

    public String toString() {
        return listaSkładników.toString();
    }

    // listaOne i listaTwo to posortowane leksykograficznie listy,
    // każda ma unikalne elementy
    private ArrayList<Integer> połączListy(ArrayList<Integer> listaOne,
                                           ArrayList<Integer> listaTwo) {
        ArrayList<Integer> połączonaLista = new ArrayList<Integer>();
        int i = 0, j = 0;
        int listaOneSize = listaOne.size();
        int listaTwoSize = listaTwo.size();
        while (i < listaOneSize || j < listaTwoSize) {
            if (i == listaOneSize) {
                połączonaLista.add(listaTwo.get(j));
                j++;
            } else if (j == listaTwoSize) {
                połączonaLista.add(listaOne.get(i));
                i++;
            } else if (!listaOne.get(i).equals(listaTwo.get(j))) {
                if (listaOne.get(i) < listaTwo.get(j)) {
                    połączonaLista.add(listaOne.get(i));
                    i++;
                } else {
                    połączonaLista.add(listaTwo.get(j));
                    j++;
                }
            } else {
                połączonaLista.add(listaOne.get(i));
                i++;
                j++;
            }
        }
        return połączonaLista;
    }

    public ArrayList<Integer> jakiePolaPokryję(int zakres) {
        ArrayList<Integer> pokrytePola = new ArrayList<Integer>();
        for (Skladnik składnik : listaSkładników) {
            pokrytePola = połączListy(pokrytePola, składnik.jakiePolaPokryję(zakres));
        }
        return pokrytePola;
    }
}