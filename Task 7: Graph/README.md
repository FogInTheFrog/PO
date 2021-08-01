### Treść zadania

Zaimplementować graf o wierzchołkach typu generycznego. 

Strukturę trzymamy w:
- Map<T, Set<T>> (mapowanie wierzchołek -> sąsiedzi)

Implementacja powinna umożliwiać dodawanie nowych wierzchołków i krawędzi, oraz zawierać metody:
- DFSiter(T pierwszy_wierzcholek)
- BFSiter(T pierwszy_wierzcholek) 

zwracający odpowiednie iteratory. Kod tworzący te iteratory powinien być uwspólniony tak bardzo jak to możliwe.

W klasie Main zaimplementujcie minimalny przykład użycia powyższych metod.
