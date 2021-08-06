### Otwarcie Pierwszego Banku Bajtocji
W ubiegłym roku w Bajtocji otwarto Pierwszy Bank Bajtocji (PBB). Od początku jego istnienia każdy obywatel Bajtocji mógł sobie w nim założyć dwa rodzaje kont do przechowywania środków finansowych: bieżące i oszczędnościowe oraz dwa rodzaje kont kredytowych: konto kartowe oraz konto ratalne. Każde konto ma swój numer oraz pozwala na wpłaty i wypłaty, ale nie zawsze. Po pierwsze waluta konta musi zgadzać się z walutą, w której chcemy zrobić wpłatę bądź wypłatę: PBB nie prowadzi wymiany walut, za to prowadzi wszystkie rodzaje kont w dowolnych walutach. Po drugie różne konta mają ograniczenia dotyczące wpłat i wypłat:
- konto bieżące pozwala na dowolne wpłaty, ale wypłaty tylko do wysokości salda,
- konto oszczędnościowe też pozwala na wpłaty, ale nie pozwala na wypłaty (jedynym sposobem wypłaty środków jest likwidacja konta),
- konto kartowe nie pozwala na wpłaty, a pozwala na wypłaty do wysokości limitu kredytowego
(ustalanego przy otwieraniu konta),
• konto ratalne nie pozwala ani na wpłaty, ani na wypłaty (wypłata była jedna, przy otwieraniu konta, o spłacaniu rat będzie mowa poniżej).

Oprócz bieżących wpłat i wypłat pod koniec miesiąca bank wykonuje następujące operacje:
- dla konta ratalnego kwota kolejnej raty pobierana jest z konta bieżącego, stowarzyszonego z nim w chwili otwierania konta,
- dla konta kartowego, całość salda (ujemnego) z danego miesiąca jest pobierana ze stowarzyszonego
z nim konta bieżącego,
- do konta oszczędnościowego dodawane są odsetki,
- z konta bieżącego pobierane są środki do obsługi stowarzyszonych z nim kont kredytowych.

Jak widać z powyższego opisu, PBB działa trochę inaczej niż normalne banki. Kolejna różnica polega na tym, że comiesięczne odsetki dla konta oszczędnościowego liczy się od całej kwoty zgromadzonej na nim w ostatnim dniu miesiąca, mnożąc tę kwotę przez 1/12 rocznej stopy procentowej, ustalonej dla konta przy jego otwarciu. Wysokość miesięcznej raty dla konta ratalnego jest zmienna, gdyż jest sumą stałej raty kapitałowej oraz zmiennej raty odsetkowej. Rata kapitałowa to iloraz początkowej kwoty pożyczki i liczby rat, a rata odsetkowa to kapitał pozostały do spłaty razy 1/12 rocznego oprocentowania rat. Roczne oprocentowanie oraz liczba rat zostały ustalone przy otwieraniu konta ratalnego.
#### Konto zagregowane
W bieżącym roku w ofercie PBB pojawił się nowy innowacyjny produkt: konto zagregowane. Umożliwia ono połączenie pod jednym numerem konta kilku kont prowadzonych w różnych walutach (dla każdej waluty co najwyżej jedno konto), aby (potencjalnie) umożliwić wpłaty i wypłaty we wszystkich walutach dostępnych na którymkolwiek z połączonych kont.
#### Polecenie
Zaprojektuj hierarchię klas, wraz z koniecznymi atrybutami, metodami i konstruktorami, modelującymi podane konta bankowe, dostępne w Pierwszym Banku Bajtocji oraz klasy potrzebne do działania całego banku w zakresie operacji na koniec miesiąca oraz tworzenia i obsługi zleceń następujących rodzajów:
- otwieranie i zamykanie kont;
- wpłaty i wypłaty gotówkowe;
- przelewy.

Zaimplementuj klasy modelujące konta bankowe oraz tę część pozostałych klas, która jest potrzebna do implementacji działania banku w zakresie obsługi zleceń przelewów oraz operacji na koniec miesiąca.
W szczególności klasa reprezentująca bank powinna posiadać implementacje metod: 
- public void przetworzZleceniaPrzelewu(Collection<ZleceniePrzelewu> zlecenia)
- public void koniecMiesiaca()

Uwaga! Dla uproszczenia zadania, w projektowaniu i implementacji można całkowicie pominąć kwestię weryfikacji tożsamości klientów i sprawdzania ich uprawnień: wszędzie gdzie powinno wystąpić określenie “osoby”, można użyć po prostu typu String. Podobnie, do reprezentowania walut oraz numerów konta również można użyć klasy String. Do reprezentowania kwot można użyć liczb całkowitych.
Przy implementacji przelewu należy zapewnić transakcyjność (być może rozszerzając lub dokładając jakąś funkcjonalność kont), aby przelew nie mógł być wykonany “w połowie”, tj. pieniądze pojawiają się na koncie docelowym, mimo iż konto źródłowe odmawia wypłaty, lub odwrotnie, środki znikają z konta źródłowego, gdy konto docelowe odmawia zgody na ich wpłatę. Zarówno odmowa wypłaty przez konto źródłowe, jak i wpłaty przez konto docelowe, powinny skutkować niepowodzeniem wykonania zlecenia, ale saldo obu kont powinno pozostać niezmienione. Podobnie, operacja końca miesiąca nie powinna zmniejszać środków pozostałych do spłaty, jeśli nie da się ich pobrać z konta stowarzyszonego.
Należy przy tym rozróżnić niemożność wykonania operacji ze zwykłych powodów, takie jak opisane tutaj, od anomalii w działaniu banku (np. nieprawidłowy numer konta), co powinno być sygnalizowane przez odpowiedni wyjątek.
Metoda przetworzZleceniaPrzelewu powinna starać się kolejno wykonać wszystkie zlecone przelewy. Analogicznie, metoda koniecMiesiaca powinna starać się wykonać operację końca miesiąca na wszystkich kontach. Niemożność wykonania jakiejś operacji np. z braku środków, a nawet z powodu awarii, nie powinna przerywać wykonywania operacji kolejnych.
Obie metody powinny wypisać na standardowe wyjście podsumowanie efektów swojej pracy:
- wszystkie zlecenia/konta, dla których operacja się nie powiodła ze zwykłych powodów,
- wszystkie zlecenia/konta, dla których operacja się nie powiodła z powodu awarii,
- stan wszystkich kont po wykonaniu operacji.
