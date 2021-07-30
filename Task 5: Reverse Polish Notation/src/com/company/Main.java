package com.company;

public class Main {

    public static void main(String[] args) {
        ONP onp = new ONP();
        try {

            int wynik1 = onp.oblicz(new String[]{"2", "13", "*", "+"}); // za duzo operatorow
            int wynik2 = onp.oblicz(new String[]{"2", "3", "4", "*"}); // za malo operatorow
            int wynik3 = onp.oblicz(new String[]{"1", "a", "*"}); // unknown symbol
            int n = 201;
            String[] napis = new String[n];
            for (int i = 0; i < n; i++){
                if (i <= n/2) napis[i] = "2";
                else napis[i] = "+";
            }
            int wynik4 = onp.oblicz(napis); //przepełnienie stosu
            int wynik5 = onp.oblicz(new String[]{"1", "0", ":"}); //dzielenie przez zero
            int wynik = onp.oblicz(new String[]{"4", "7", "2", "+", "*"});
            System.out.println("Jest git, wynik to: " + wynik);
        }
        catch (ONP.ZaDuzoOperatorow e){
            System.out.println("Za dużo operatorów");
        }
        catch (ONP.TooComplexExpresionException e){
            System.out.println("Coś złego");
        }
        catch (ONP.ZaMaloOperatorow e){
            System.out.println("Za mało operatorów");
        }
        catch (ONP.UnknownSymbolException e) {
            System.out.println("Nieznany symbol");
        }
        catch (ArithmeticException e) {
            System.out.println("Nie dziel przez zero ok?");
        }
    }
}
