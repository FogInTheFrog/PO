package bank;

import java.util.Collection;

public class BPP {
    private Konto[] konta;

    class niepoprawnyNumerKonta extends Exception {
    }

    public BPP(Konto[] konta) {
        this.konta = konta;
    }

    private Konto znajdźKontoONumerze(String numer) throws niepoprawnyNumerKonta {
        for (Konto konto : konta) {
            if (konto.nrKonta.equals(numer)) {
                return konto;
            }
        }
        throw new niepoprawnyNumerKonta();
    }

    private boolean czyMożnaWykonaćPrzelew(Konto kontoNadawcy, Konto kontoOdbiorcy,
                                           ZleceniePrzelewu zleceniePrzelewu) {
        String waluta = zleceniePrzelewu.getWaluta();
        int kwota = zleceniePrzelewu.getKwotaPrzelewu();
        return (kontoNadawcy.czyMogęWysłaćPrzelew(waluta, kwota) &&
                kontoOdbiorcy.czyMogęOtrzymaćPrzelew(waluta));
    }

    private void wykonajPrzelew(Konto kontoNadawcy, Konto kontoOdbiorcy,
                                ZleceniePrzelewu zleceniePrzelewu)
            throws Konto.niepoprawneZlecenie {
        String waluta = zleceniePrzelewu.getWaluta();
        int kwota = zleceniePrzelewu.getKwotaPrzelewu();

        kontoNadawcy.wypłać(kwota, waluta);
        kontoOdbiorcy.wpłać(kwota, waluta);
    }

    public void przetwórzZleceniePrzelewu(Collection<ZleceniePrzelewu> zlecenia) {
        for (ZleceniePrzelewu zlecenie : zlecenia) {

            try {
                Konto kontoNadawcy = znajdźKontoONumerze(zlecenie.getNrKontaNadawcy());
                Konto kontoOdbiorcy = znajdźKontoONumerze(zlecenie.getNrKontaOdbiorcy());

                if (czyMożnaWykonaćPrzelew(kontoNadawcy, kontoOdbiorcy, zlecenie)) {
                    wykonajPrzelew(kontoNadawcy, kontoOdbiorcy, zlecenie);
                }
            } catch (BPP.niepoprawnyNumerKonta niepoprawnyNumerKonta) {
                System.out.println(zlecenie.toString() + "nie powiodło się z" +
                        " powodu błędnego numeru konta.");
                return;
            } catch (Konto.niepoprawneZlecenie niepoprawneZlecenie) {
                System.out.println("program próbował wykonać niepoprawne zlecenie");
            }
        }
    }

    public void koniecMiesiaca() throws Konto.wzywajKomornika {
        for (Konto konto : konta)
            konto.obsłużKoniecMiesiąca();
    }
}
