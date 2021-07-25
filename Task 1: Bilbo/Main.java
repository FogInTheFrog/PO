import java.util.Arrays;

class Skarb {
    private int wartosc;
    
    public Skarb (int wartosc) {
        this.wartosc = wartosc;
    }
    
    public String toString() {
        return ("Skarb o wartości " + this.wartosc);
    }
}

class Krasnolud {
    private Skarb mojeSkarby[];
    private int ileMam = 0;
    
    public Krasnolud (int ileSkarbówMogę) {
        this.mojeSkarby = new Skarb[ileSkarbówMogę];
    }
    
    public void dodajSkarb(Skarb skarb) {
        this.mojeSkarby[this.ileMam] = skarb;
        this.ileMam++;
    }
    
    public void wypiszSkarby() {
        System.out.println ("Mam " + this.ileMam + " skarbów:");
        System.out.println (Arrays.toString(this.mojeSkarby));
    }
}

class Bilbo {
    public void rozdziel_skarby(int krasnoludy, Skarb[] skarby) {
        Krasnolud[] tablicaKrasnoludów = new Krasnolud[krasnoludy];
        
        for (int i = 0; i < skarby.length; i++) {
            if (i < krasnoludy) {
                int ileSkarbow = (skarby.length/krasnoludy);
                if (krasnoludy * ileSkarbow + i < skarby.length) ileSkarbow++;
                
                tablicaKrasnoludów[(i % krasnoludy)] = new Krasnolud(ileSkarbow);
            }
            tablicaKrasnoludów[(i % krasnoludy)].dodajSkarb(skarby[i]);
        }
        
        for (int i = 0; i < krasnoludy; i++) {
            tablicaKrasnoludów[i].wypiszSkarby();
        }
    }
}
 
public class Main {
    public static void main(String[] args) {
        Bilbo bilbo = new Bilbo();
        Skarb[] skarby = new Skarb[10];
        
        for (int i = 0; i < 10; i++) {
            skarby[i] = new Skarb( 3 * i);
        }
        
        bilbo.rozdziel_skarby(3, skarby);
    }
}
