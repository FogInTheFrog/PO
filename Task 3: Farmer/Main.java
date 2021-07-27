import java.util.Random;
import java.lang.Thread;

class Garden {
    private int size;
    private Vegetable myVegetables[];

    public Garden(int k) {
        this.size = k;
        this.myVegetables = new Vegetable[k];
        for (int i = 0; i < k; i++) {
            this.myVegetables[i] = new Grass(i);
        }
    }

    public int getSize() {
        return this.size;
    }

    private boolean isGrass(Vegetable veg) {
        if (veg.getClass() == Grass.class)
            return true;
        return false;
    }

    public void plant(Vegetable veg, int position) {
        if (position < 0 && position >= this.size) {
            System.out.println("To nie jest moja działka");
        } else if (isGrass(myVegetables[position])) {
            this.myVegetables[position] = veg;
            System.out.println("Na polu " + position + " posadzony został " + veg.getClass().getSimpleName());
        } else {
            System.out.println("Pole zajęte");
        }
    }

    public Vegetable collect(int position) {
        Vegetable veg = myVegetables[position];
        myVegetables[position] = new Grass(0);
        return veg;
    }

    public int getVegetableValue(int position, int time) {
        Vegetable veg = myVegetables[position];
        return veg.currentValue(time);
    }
}

abstract class Vegetable {
    protected final int plantingTime;
    protected final int cost;

    public Vegetable(int plantingTime, int cost) {
        this.plantingTime = plantingTime;
        this.cost = cost;
    }

    public abstract int currentValue(int time);

    public int getCost(){
        return cost;
    }
}

class Tomato extends Vegetable {
    public static final int cost = 2;

    public Tomato (int time) {
        super(time, cost);
    }

    public int currentValue(int time) {
        int length = time - this.plantingTime;
        if (length < 10)
            return 0;
        else if (length < 15)
            return (length - 9) * 2;
        else if (length < 20)
            return 10 - (length - 14) * 2;
        else
            return 0;
    }
}

class Potato extends Vegetable {
    public static final int cost = 1;

    public Potato(int time) {
        super(time, cost);
    }

    public int currentValue(int time) {
        int length = time - this.plantingTime;
        if (length >= 14)
            return 0;
        else if (length < 10)
            return 0;
        else
            return 5;
    }
}

class Pumpkin extends Vegetable {
    private int maximumValue;
    private int plantingTime;
    public static final int cost = 25;
    Random generator = new Random();

    public Pumpkin(int time) {
        super(time, cost);
        maximumValue = generator.nextInt(1190);
    }

    public int currentValue(int time) {
        int length = time - this.plantingTime;
        if (length < 0) return 0;
        return Math.min(maximumValue, length * 3);
    }
}

class Grass extends Vegetable {
    public static final int cost = 0;
    public Grass(int time) {
        super(time, cost);
    }

    public int currentValue(int time) {
        return 0;
    }
}

abstract class Rolnik {
    private void shoutCollect(Vegetable veg, int time) {
        System.out.println("Zebrałem " + veg.getClass().getSimpleName()
                + " o wartości: " + veg.currentValue(time) + "PLN");
    }

    private void shoutPlant(Vegetable veg) {
        System.out.println("Posadziłem " + veg.getClass().getSimpleName() +
                ". Zapłaciłem za sadzonkę " + veg.getCost() + "PLN.");
    }

    private void summmary(int przychód, int koszty) {
        System.out.println("=== KONIEC SEZONU SADOWNICZEGO ===");
        System.out.println("Łączny przychód w tym sezonie to "
                + przychód + "PLN.");
        System.out.println("Łączne koszty w tym sezonie to "
                + koszty + "PLN.");
        System.out.println("Końcowy balans to " + (przychód - koszty)
                + "PLN.");
    }

    protected abstract boolean strategia(Garden g, int position, int time);

    public void simulate(Garden g, int time) {
        int przychód = 0;
        int koszty = 0;
        int size = g.getSize();
        for (int i = 0; i < time; i++) {
            System.out.println("=== DZIEŃ " + i + " ===");
            for (int j = 0; j < size; j++) {
                if (strategia(g, j, i)) {
                    Vegetable veg = g.collect(j);
                    shoutCollect(veg, i);
                    przychód += veg.currentValue(i);
                    Random randomizer = new Random();
                    int vegetable_type = randomizer.nextInt(3);
                    if (vegetable_type == 0)
                        veg = new Pumpkin(i);
                    else if (vegetable_type == 1)
                        veg = new Tomato(i);
                    else if (vegetable_type == 2)
                        veg = new Potato(i);
                    else
                        veg = new Grass(i);
                    g.plant(veg, j);
                    shoutPlant(veg);
                    koszty += veg.cost;
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        for (int j = 0; j < size; j++) {
            Vegetable veg = g.collect(j);
            shoutCollect(veg, time);
            przychód += veg.currentValue(time);
        }
        summmary(przychód, koszty);
    }
}

class PracownikPGR extends Rolnik {
    public PracownikPGR() {};

    protected boolean strategia(Garden g, int position, int time) {
        if (time % 10 == 0) return true;
        return false;
    }
}

class Gospodarz extends Rolnik {
    public Gospodarz() {};

    protected boolean strategia(Garden g, int position, int time){
        if (time == 0 || g.getVegetableValue(position, time - 1)
                > g.getVegetableValue(position, time)) return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        PracownikPGR c = new PracownikPGR();
        Rolnik d = new Gospodarz();
        Garden g = new Garden(7);
        c.simulate(g, 36);
        d.simulate(g, 36);
    }
}
