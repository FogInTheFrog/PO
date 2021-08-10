import java.util.Random;


abstract class Wirus{
    public abstract void mutuj(int ileMiesięcy);
    public abstract KwasNukleinowy zwrocKwasNukleinowy();
}

class Szczepionka {
    private KwasNukleinowy przeciwciała;
    public Szczepionka(KwasNukleinowy przeciwciała){
        this.przeciwciała = przeciwciała;
    }
    public boolean czyPokonaWirusa(Wirus wirus){
        KwasNukleinowy kwasNukleinowy2 = wirus.zwrocKwasNukleinowy();
        int długość2 = kwasNukleinowy2.getDługość();
        char[] ciąg2 = kwasNukleinowy2.getNukleotydy();
        char[] ciąg1 = przeciwciała.getNukleotydy();
        int długość1 = przeciwciała.getDługość();
        boolean czyPokona = false;
        for (int i = 0; i < długość2 - długość1 + 1; i++){
            for (int j = 0; j < długość1; j++){
                if (ciąg1[j] != ciąg2[i])
                    break;
                else if (j == długość1 - 1)
                    czyPokona = true;
            }
        }
        return czyPokona;
    }
}

class KwasNukleinowy {
    private int długość;
    private char[] nukleotydy
    public KwasNukleinowy(char[] nukleotydy, int długość){
        this.nukleotydy = nukleotydy;
        this.długość = długość;
    }

    public void zamienMiejscami(int index1, int index2) {
        char pomocniczy = this.nukleotydy[index1];
        this.nukleotydy[index1] = this.nukleotydy[index2];
        this.nukleotydy[index2] = pomocniczy;
    }

    public void zamienNaInny(int ktory, char naJaki){
        this.nukleotydy[ktory] = naJaki;
    }

    public char[] getNukleotydy(){
        return this.nukleotydy;
    }

    public int getDługość(){
        return this.długość
    }
}

class Specyficzny extends Wirus{
    private KwasNukleinowy kwasNukleinowy;
    private int liczbaMutacjiWMiesiącu;
    private int[] specyficzneNukleotydy;
    private char[] mutująceNukleotydy;
    public Specyficzny(KwasNukleinowy kwasNukleinowy,
                       int liczbaMutacjiWMiesiącu,
                       int[] specyficzneNukleotydy,
                       int[] mutująceNukleotydy){
        this.kwasNukleinowy = kwasNukleinowy;
        this.liczbaMutacjiWMiesiącu = liczbaMutacjiWMiesiącu;
        this.specyficzneNukleotydy = specyficzneNukleotydy;
        this.mutująceNukleotydy = mutująceNukleotydy;
    }

    public void mutuj(int ileMiesięcy){
        for (int i = 0; i < ileMiesięcy; i++){
            for (int j = 0; j < ileMiesięcy; j++){
                Random losuj = new Random();
                int indexSpecyficznyNukleotyd =
                        losuj.nextInt(specyficzneNukleotydy.length());
                int specyficznyNukleotyd =
                        specyficzneNukleotydy[indexSpecyficznyNukleotyd];
                int indexMutującyNukleotyd =
                        losuj.nextInt(mutującyNukleotyd.length);
                char zmutujęNa = mutująceNukleotydy[indexMutującyNukleotyd];
                kwasNukleinowy.zamienNaInny(specyficznyNukleotyd, zmutujęNa);
            }
        }
    }
    public KwasNukleinowy zwrocKwasNukleinowy(){
        return kwasNukleinowy;
    }
}

class Dziwny extends Wirus{
    private KwasNukleinowy kwasNukleinowy;
    private int liczbaMutacjiWMiesiącu;
    public Dziwny(KwasNukleinowy kwasNukleinowy, int liczbaMutacjiWMiesiącu) {
        this.kwasNukleinowy = kwasNukleinowy;
        this.liczbaMutacjiWMiesiącu = liczbaMutacjiWMiesiącu;
    }

    public void mutuj(int ileMiesięcy){
        for (int i = 0; i < ileMiesięcy; i++) {
            for (int j = 0; j < liczbaMutacjiWMiesiącu; j++) {
                Random losuj = new Random();
                int index1 = losuj.nextInt(kwasNukleinowy.getDługość());
                int index2 = losuj.nextInt(kwasNukleinowy.getDługość());
                while (index1 == index2) {
                    index2 = losuj.nextInt(kwasNukleinowy.getDługość());
                }
                this.kwasNukleinowy.zamienMiejscami(index1, index2);
            }
        }
    }

    public KwasNukleinowy zwrocKwasNukleinowy(){
        return kwasNukleinowy;
    }
}
