package cover;

public class MetodaDHondta extends MetodyDzieleniowe {
    @Override
    protected int getKolejnyDzielnik(KomitetWyborczy komitetWyborczy) {
        return komitetWyborczy.getOtrzymaneMandaty() + 1;
    }
}