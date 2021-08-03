package cover;

import java.util.ArrayList;

public class Nieskonczony extends Skladnik {
    private int a, b;

    public Nieskonczony(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public ArrayList<Integer> jakiePolaPokryję(int zakres) {
        ArrayList<Integer> pokrywanePola = new ArrayList<Integer>();
        for (int i = this.a; i <= -zakres; i -= this.b) {
            pokrywanePola.add(i);
        }
        return pokrywanePola;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public String toString() {
        return "Nieskończony " + a + " " + b;
    }
}
