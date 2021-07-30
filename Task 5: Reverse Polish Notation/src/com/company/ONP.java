package com.company;

import com.company.IStack.PustyStos;
import com.company.IStack.PełnyStos;

public class ONP {
    public class ZaMaloOperatorow extends Exception {
    }

    public class ZaDuzoOperatorow extends Exception {
    }

    public class TooComplexExpresionException extends Exception {
    }

    public class UnknownSymbolException extends Exception {
    }


    public int oblicz(String[] sekwencja) throws UnknownSymbolException,
            ZaDuzoOperatorow, ZaMaloOperatorow, TooComplexExpresionException,
            ArithmeticException {
        MyStack stos = new MyStack();

        for (String wyrażenie : sekwencja) {
            try {
                switch (wyrażenie) {
                    case "+": {
                        int prawy = stos.pobierz();
                        int lewy = stos.pobierz();
                        stos.wstaw(lewy + prawy);
                        break;
                    }
                    case "*": {
                        int prawy = stos.pobierz();
                        int lewy = stos.pobierz();
                        stos.wstaw(lewy * prawy);
                        break;
                    }
                    case "-": {
                        int prawy = stos.pobierz();
                        int lewy = stos.pobierz();
                        stos.wstaw(lewy - prawy);
                        break;
                    }
                    case ":": {
                        int prawy = stos.pobierz();
                        int lewy = stos.pobierz();
                        stos.wstaw(lewy / prawy);
                        break;
                    }
                    default: {
                        int x = Integer.parseInt(wyrażenie);
                        stos.wstaw(x);
                    }
                }
            } catch (PustyStos e) {
                throw new ZaDuzoOperatorow();
            } catch (PełnyStos e) {
                throw new TooComplexExpresionException();
            } catch (NumberFormatException e) {
                throw new UnknownSymbolException();
            } catch (ArithmeticException e) {
                throw new ArithmeticException();
            }
        }
        int wynik;
        try {
            wynik = stos.pobierz();
        } catch (PustyStos e) {
            throw new ZaDuzoOperatorow();
        }
        if (!stos.pusty())
            throw new ZaMaloOperatorow();
        return wynik;
    }
}
