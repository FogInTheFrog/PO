package cover;

import java.util.ArrayList;

public class Element extends Skladnik {
    private int a;

    public Element(int a) {
        this.a = a;
    }

    public ArrayList<Integer> jakiePolaPokryję(int zakres) {
        ArrayList<Integer> pokrywanePola = new ArrayList<Integer>();

        if (this.a <= -zakres) {
            pokrywanePola.add(this.a);
        }
        return pokrywanePola;
    }

    public String toString() {
        return "Element " + a;
    }

}
