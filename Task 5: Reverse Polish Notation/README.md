### Zadanie ONP

Zadanie polega na implementacji napisaniu klasy ONP która wylicza wartość wyrażeń zapisanych w Odwrotnej Notacji Polskiej (np. "23+4*"  -> 20) przy pomocy stosu (który należy zaimplementować jako oddzielną klasę)

Stos w powinien rzucać wyjątki EmptyException i OverflowException (maksymalny rozmiar stosu to 100).

ONP.oblicz() powinno łapać te wyjątki i rzucać TooComplexExpresionException (gdy przepełnimy stos), TooManyOperatorsException ToFewOperatorsException, UnknownSymbolException (w przypadku niepoprawnych danych wejściowych).

MainClass ma zaprezentować obliczenie ONP na prawidłowych i błędnych danych (w przypadku błędnych łapać wyjątek i wypisywać komunikat na stdout)

Ograniczamy się do integerów, operacji dodawania i mnożenia. Wejściem do ONP oblicz jest tablica / ArrayLista Stringów np. {"2", "3", "+", "4", "*"}
