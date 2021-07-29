package com.company;

public class Main {

    public static void main(String[] args) {
	    Przedmiot p1 = new Przedmiot(2000, "bagietka", Kraj.Francja);
	    Przedmiot p2 = new Przedmiot(3500, "Popiersie Napoleona", Kraj.Francja);
	    Przedmiot p3 = new Przedmiot(2100, "Chorizzo", Kraj.Hiszpania);
	    Przedmiot p4 = new Przedmiot(3000, "Maska Gaudiego", Kraj.Hiszpania);
	    Przedmiot p5 = new Przedmiot(1488, "Akwarelowy Obraz", Kraj.Niemcy);
	    Przedmiot p6 = new Przedmiot(500000, "Audi", Kraj.Niemcy);
	    Przedmiot p7 = new Przedmiot(4000, "Ciężarek Pudziana", Kraj.Polska);
	    Przedmiot p8 = new Przedmiot(4000, "Narty Małysza", Kraj.Polska);

	    Uczestnik u1 = new SentymentalnyZOgraniczeniem(4567, "Maryla Rodowicz",
                Kraj.Polska, 1);
	    Uczestnik u2 = new Sentymentalny(500000, "Helga", Kraj.Niemcy);
	    Uczestnik u3 = new Oszczędny(9000, "Sergio");
	    Uczestnik u4 = new OszczędnyZOgranieczeniem(9999, "Muhammad");

	    Przedmiot[] listaPrzedmiotów = {p1, p2, p3, p4, p5, p6, p7, p8};
	    Uczestnik[] listaUczestników = {u1, u2, u3, u4};

	    Licytator.przeprowadź(listaPrzedmiotów, listaUczestników);
    }
}
