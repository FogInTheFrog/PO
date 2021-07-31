### Treść zadania Wektor

Zaimplementować wektor (w sensie algebry liniowej) o generycznym typie elementów, na którym można wykonywać operacje iloczynu skalarnego i sumy (zwracającej wektor tego samego rozmiaru - "pointwise addition")

Chcielibyśmy móc używać go do operacji między innymi na int'ach i liczbach wymiernych. Obie opcje powinny być zaprezentowane w MainClass.

Problem: nie możemy używać operatorów '+', '*' do liczb wymiernych.

Rozwiązanie: implementacja interfejsu Algebraiczne zawierająca metody mnóż(other) i dodaj(other). Standardowe typy (u nas Integer) musimy opakować we własną klasę realizującą interface Algebraiczne.

Uwaga: Iloczyn skalarny i dodawanie Wektorów o różnej długości powinno rzucać błąd RóżnaDługośćWektorów (może dziedziczyć po RuntimeException) wypisujący długości podanych wektorów.

W MainClass powinna być też demonstracja działania wyjątku RóżnaDługośćWektorów, nie przerywająca programu (przy pomocy klauzuli try catch)
