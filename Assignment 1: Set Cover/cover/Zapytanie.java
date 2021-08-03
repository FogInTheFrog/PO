package cover;

public class Zapytanie extends Dane {
    private int u, d;

    public Zapytanie(int u, int d) {
        this.u = u;
        this.d = d;
    }

    public int getU() {
        return u;
    }

    public int getD() {
        return d;
    }

    public String toString() {
        return "Zapytanie " + u + " " + d;
    }
}
