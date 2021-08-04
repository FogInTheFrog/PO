package cover;

import java.util.ArrayList;
import java.util.Random;

public abstract class Cechowy extends Wyborca {
    Cechowy(String imię, String nazwisko, int numerOkręguWyborczego,
            String przywiązaniePartyjne) {
        super(imię, nazwisko, numerOkręguWyborczego, przywiązaniePartyjne);
    }

    private boolean czyKandydatLepszyOdPoprzednich
            (int wartośćFaworyzowanejCechyPreferowanegoKandydata,
             int wartośćFaworyzowanejCechyKandydata) {

        return (wartośćFaworyzowanejCechyKandydata >
                wartośćFaworyzowanejCechyPreferowanegoKandydata);
    }

    private boolean czyKandydatNiegorszyOdPoprzednich
            (int wartośćFaworyzowanejCechyPreferowanegoKandydata,
             int wartośćFaworyzowanejCechyKandydata) {

        return (wartośćFaworyzowanejCechyKandydata >=
                wartośćFaworyzowanejCechyPreferowanegoKandydata);
    }

    private boolean czyToPierwszyKandydat(ArrayList<Kandydat>
                                                  preferowaniKandydaci) {
        return preferowaniKandydaci.isEmpty();
    }

    private Kandydat losujKandydata(ArrayList<Kandydat> preferowaniKandydaci) {
        if (preferowaniKandydaci.size() == 0) {
            System.out.println(this.toString());
            throw new RuntimeException();
        }
        Random random = new Random();
        int index = random.nextInt(preferowaniKandydaci.size());
        return preferowaniKandydaci.get(index);
    }

    private boolean czyInteresujeGoTaPartia(String nazwaPartii) {
        if (this.przywiązaniePartyjne == null)
            return true;
        else
            return nazwaPartii.equals(this.przywiązaniePartyjne);
    }

    protected abstract int obliczWynikDlaKandydata(int[] cechyKandydata);

    protected Kandydat wybierzKandydata(KartaWyborcza kartaWyborcza) {
        ArrayList<Kandydat> preferowaniKandydaci = new ArrayList<>();
        int wynikPreferowanegoKandydata = 0;
        for (KomitetWyborczy komitetWyborczy :
                kartaWyborcza.getListaKomitetówWyborczych()) {
            String nazwaPartii = komitetWyborczy.getNazwaPartii();

            if (czyInteresujeGoTaPartia(nazwaPartii)) {
                for (Kandydat kandydat : komitetWyborczy.getListaKandydatów()) {
                    int wynikKandydata =
                            obliczWynikDlaKandydata(kandydat.getCechy());

                    if (czyToPierwszyKandydat(preferowaniKandydaci)) {
                        wynikPreferowanegoKandydata =
                                wynikKandydata;
                        preferowaniKandydaci.add(kandydat);
                    } else if (czyKandydatNiegorszyOdPoprzednich(
                            wynikPreferowanegoKandydata,
                            wynikKandydata)) {

                        if (czyKandydatLepszyOdPoprzednich(
                                wynikPreferowanegoKandydata,
                                wynikKandydata)) {

                            wynikPreferowanegoKandydata = wynikKandydata;
                            preferowaniKandydaci.clear();
                        }

                        preferowaniKandydaci.add(kandydat);
                    }
                }
            }
        }
        return losujKandydata(preferowaniKandydaci);
    }
}
