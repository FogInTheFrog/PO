### Treść zadania
Zaimplementuj bardzo uproszczony proces rozdawania skarbów krasnoludom przez Bilba. Użyj podstawowej tablicy (array można o niej przeczytać np tu https://www.geeksforgeeks.org/arrays-in-java/) w javie do trzymania krasnoludów i skarbów.

### Opis klas
* Bilbo
    * Metoda rozdziel_skarby(krasnoludy, skarby) - bardzo prosta, kolejno skarby rozdawane są krasnoludom, które nie mają żadnych limitów na ilość skarbów.
* Krasnolud
    * Array skarbów
* Skarb
    * Atrybut wartość
    * Metoda toString() zwracająca coś w stylu “Skarb o wartości x”

* MainClass
    * Tworzy Bilba krasnoludy i skarby, woła bilbo.rozdziel_skarby(krasnoludy, skarby), wypisuje skarby dla każdego krasnoluda. (użyć Arrays.toString(skarby) z java.utils.Arrays)

Powyżej zaprezentowany jest niepełny zbiór metod które powinny się pojawić, np. Krasnoludy mogą wymagać jeszcze publicznych metod.

Uwaga Krasnolud nie powinien mieć gettera get_skarby(), to daje niepotrzebnie duży dostęp do atrybutów (java daje referencję do tablicy skarby, przez którą można zmodyfikować jej pola), zamiast tego  powinny mieć metodę wypiszSkarby lub toString. Ogólnie geterów do obiektów modyfikowalnych jak tablice, należy unikać.
