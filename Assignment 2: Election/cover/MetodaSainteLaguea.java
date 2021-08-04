package cover;

public class MetodaSainteLaguea extends MetodyDzieleniowe {

    @Override
    protected int getKolejnyDzielnik(KomitetWyborczy komitetWyborczy) {
        return komitetWyborczy.getOtrzymaneMandaty() * 2 + 1;
    }
}
