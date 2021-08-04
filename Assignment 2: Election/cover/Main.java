package cover;

import java.io.FileNotFoundException;

class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    Parser parser = new Parser();
	    BajtockaKomisjaWyborcza bajtockaKomisjaWyborcza
				= new BajtockaKomisjaWyborcza(parser);
	    bajtockaKomisjaWyborcza.przygotujIPrzeprowadźGłosowanie();
	    bajtockaKomisjaWyborcza.przeliczIWypisz(new MetodaDHondta());
	    bajtockaKomisjaWyborcza.przeliczIWypisz(new MetodaSainteLaguea());
	    bajtockaKomisjaWyborcza.przeliczIWypisz(new MetodaHareaNiemeyera());

    }
}
