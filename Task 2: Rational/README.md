### Treść zadania:
Proszę zaimplementować klasę dla liczb wymiernych. Klasa powinna nazywać się Rational i mieć następujące metody:
1. statyczne metody 
    - zero() : Rational
    - one() : Rational
które zwracają zero i jedynkę.
2. metody arytmetyczne 
    - add(Rational x) : Rational,
    - subtract(Rational x) : Rational,
    - multiply(Rational x) : Rational, 
    - divide(Rational x) : Rational, 
    - opposite() : Rational, 
    - inverse() : Rational, 
które wykonują odpowiednie operacje arytmetyczne: dodawanie, odejmowanie, mnożenie, dzielenie, branie liczby przeciwnej oraz odwrotności. Każda operacja ma zwracać wynik jako nowy obiekt.
3. akcesory:
    - sign() : int,
    - numerator() : int,
    - denominator() : int,
które zwracają odpowiednio znak (-1, 0 lub +1), licznik, i mianownik danej liczby, w postaci nieskracalnej (ze względnie pierwszym licznikiem i mianownikiem).
4. metoda:
    - compareTo(Rational x) : int
    która zwraca -1, 0 lub +1 w zależności czy (this) jest mniejsze, równe, czy większe od x.
5. metoda:
    - toString() : String,
    która zwraca string z reprezentacją liczby w postaci nieskracalnej w formacie "\[znak\](licznik)/(mianownik)", np. "-1/2", "2/3", "-101/10", "0/1".
6. konstruktory:
    - Rational(int n), tworzący n/1
    - Rational(int p, int q), tworzący p/q (dla dowolnych p i q, być może ujemnych).

Zwróć uwagę, żeby określić jak najmniejszy zbiór krytycznych metod potrzebny do zaimplementowania całej funkcjonalności, tzn. implementuj niektóre metody przy użyciu złożeń innych. 
Dzielenie przez zero należy zignorować (tzn. pozwolić na odpalanie się standardowych wyjątków arytmetycznych).

Proszę też napisać metodę MainClass.main, w której będzie kilka prostych testów sprawdzających, że funkcjonalność działa.
