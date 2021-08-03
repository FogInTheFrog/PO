package cover;

import java.util.ArrayList;

public class Skonczony extends Skladnik {
    private int a, b, c;

    public Skonczony(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ArrayList<Integer> jakiePolaPokryję(int zakres) {
        int range = Math.max(this.c, zakres);
        ArrayList<Integer> pokrywanePola = new ArrayList<Integer>();

        for (int i = this.a; i <= -range; i -= this.b) {
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

    public int getC() {
        return c;
    }

    public String toString() {
        return "Skończony " + a + " " + b + " " + c;
    }
}