package bank;

public class ZleceniePrzelewu {
    private int kwotaPrzelewu;
    private String nrKontaOdbiorcy;
    private String nrKontaNadawcy;
    private String waluta;

    public ZleceniePrzelewu(int kwotaPrzelewu, String nrKontaOdbiorcy,
                            String nrKontaNadawcy, String waluta) {
        this.kwotaPrzelewu = kwotaPrzelewu;
        this.nrKontaOdbiorcy = nrKontaOdbiorcy;
        this.nrKontaNadawcy = nrKontaNadawcy;
        this.waluta = waluta;
    }

    @Override
    public String toString() {
        return "ZleceniePrzelewu{" +
                "kwotaPrzelewu=" + kwotaPrzelewu +
                ", nrKontaOdbiorcy='" + nrKontaOdbiorcy + '\'' +
                ", nrKontaNadawcy='" + nrKontaNadawcy + '\'' +
                ", waluta='" + waluta + '\'' +
                '}';
    }

    public int getKwotaPrzelewu() {
        return kwotaPrzelewu;
    }

    public String getNrKontaOdbiorcy() {
        return nrKontaOdbiorcy;
    }

    public String getNrKontaNadawcy() {
        return nrKontaNadawcy;
    }

    public String getWaluta() {
        return waluta;
    }
}
