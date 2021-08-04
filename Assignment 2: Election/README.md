## Treść zadania [TLDR]

Napisz program, który przeprowadzi symulację przeprowadzenia procesu wyborczego:
formowania okręgów wyborczych, kampanii wyborczej, głosowania oraz przeliczania głosów
na mandaty. Ponieważ metoda przeliczania głosów na mandaty jest losowana przed
kampanią, więc chcemy zasymulować ten proces dla każdej z 3 wspomnianych metod.
Zaimplementuj również przynajmniej jedną dodatkową strategię partii, wczuwając się w rolę
jej stratega (możesz przyjąć, że masz pełną wiedzę o wagach cech wszystkich wyborców,
podziale na okręgi wyborcze i aktualnej (wybranej) metodzie przeliczania głosów na
mandaty w parlamencie).

# Wybory (pełna wersja)
W Bajtocji odbywają się wybory posłów do Bajtockiego Parlamentu. Bajtocja jest podzielona
na n podstawowych okręgów wyborczych o numerach 1,2,3,...,n. W każdym podstawowym
okręgu wyborczym znajduje się określona liczba wyborców, przyjmujemy, że zawsze jest
ona wielokrotnością 10. Okręgi wyborcze mogą być jednak łączone, przy czym Konstytucja
Bajtocji dopuszcza jedynie łączenie okręgów wyborczych o sąsiednich numerach (czyli
okręg o numerze 1 można połączyć z okręgiem o numerze 2, ale nie można połączyć z
okręgiem o numerze 3) i nie można iterować łączenia okręgów (tzn. każdy okręg może być
połączony z tylko jednym innym). W każdym okręgu wyborczym wybierana jest liczba
posłów do parlamentu równa n/10, gdzie n to liczba wyborców w danym okręgu
(uwzględniając już ewentualne połączenie). Przyjmujemy, że każda partia w danym okręgu
wystawia dokładnie tylu kandydatów, ile jest do obsadzenia mandatów, licząc na zdobycie
wszystkich mandatów, każdy kandydat jest wybierany tylko w 1 okręgu, a wyborcy w danym
okręgu mogą głosować tylko na kandydatów z danego okręgu.
Każdy kandydat do parlamentu ma imię, nazwisko, przynależność do danej partii politycznej
oraz okręgu wyborczego, numer na liście wyborczej partii w danym okręgu oraz pewną
liczbę cech, których wartości są całkowite i są w przedziale od -100 do 100.
Każdy wyborca w Bajtocji jest przykładnym obywatelem i zawsze korzysta z własnego prawa
do głosowania, oddając ważny głos na jednego z kandydatów. Wyborców możemy podzielić
na kilka typów w zależności od tego, czym kierują się przy podejmowaniu decyzji co do
wyboru kandydata:
1. Żelazny elektorat partyjny zawsze głosuje na losowego kandydata na liście danej
partii.
2. Żelazny elektorat kandydata zawsze głosuje na danego kandydata.
3. Minimalizujący jednocechowy wybiera tego spośród kandydatów wszystkich partii,
który ma najniższy poziom wybranej przez niego cechy (jeśli taką wartość ma więcej
niż 1 kandydat, to wybór kandydata jest losowy).
4. Maksymalizujący jednocechowy wybiera tego spośród kandydatów wszystkich partii,
który ma najwyższy poziom wybranej przez niego cechy (jeśli taką wartość ma więcej
niż 1 kandydat, to wybór kandydata jest losowy).
5. Wszechstronny liczy sumę ważoną cech dla każdego z kandydatów, przypisując
każdej z jego cech całkowite wagi (które zawsze powinny być z przedziału -100 do
100) ze swojego wektora wag, a następnie dokonuje wyboru maksymalizując sumę
ważoną.
6. Istnieją także wyborcy, którzy działają zgodnie z jedną ze strategii z punktów 3,4,5,
ale przy dokonywaniu wyboru ograniczają się do jednej partii.
Każdy wyborca oddaje głos na dokładnie 1 kandydata (z własnego okręgu wyborczego) i
głosy wszystkich wyborców z danego okręgu wyborczego są następnie sumowane i
zamieniane na mandaty. Konstytucja Bajtocji zawiera oryginalny zapis, że metoda zamiany
głosów na mandaty jest losowana przed rozpoczęciem kampanii wyborczej.

Dopuszcza się
3 metody zamiany głosów na mandaty:
● Metoda D'Hondta
● Metoda Sainte-Laguë
● Metoda Hare’a-Niemeyera
W przypadku remisów w liczbie głosów można przyjąć, że losujemy, która partia/kandydata
(z tą samą liczbą głosów) powinna otrzymać mandat.
Przed wyborami odbywa się kampania wyborcza, na którą każda z partii ma określony
budżet (każda partia może mieć inny budżet). Losowanie metody głosowania oraz
formowanie okręgów wyborczych odbywa się jeszcze przed kampanią wyborczą, dzięki
czemu partie mogą lepiej dostosować swoją strategię działań w trakcie kampanii. Partie
polityczne prowadzą bardzo zaawansowane badania socjologiczne dlatego doskonale znają
preferencje wyborcze każdego z wyborców oraz wiedzą w jakim jest okręgu wyborczym. Za
pieniądze z budżetu partie mogą podejmować działania oddziałujące na wyborców, każde z
działań ma swoją cenę oraz opis, który jest reprezentowany jako wektor opisujący jak
zmieniają się wagi cech. Każde działanie może zwiększyć lub zmniejszyć wagę każdej
cechy u każdego z wyborców o wartość całkowitą z określonego przedziału od -z do z (nie
przekraczając jednak minimalnych i maksymalnych wartości wag), te liczby są właśnie na
pozycjach w wektorze opisującym zmianę wag i mogą być różne dla różnych cech. Istotne
jest to, że za jednym razem partia może wykonać działanie tylko w jednym (wybranym przez
siebie) okręgu wyborczym. Koszt jaki partia musi ponieść za dane działanie jest równy sumie
wartości bezwzględnych wektora zmiany wag * liczba wszystkich wyborców w danym okręgu
wyborczym (można przyjąć, że w danych wejściowych nie będzie działań o zerowym
koszcie). Partie wykonują działania tak długo, jak długo pozwala im na to budżet (tzn. jeśli
jest jeszcze działanie, które dana partia może wykonać, to jest ono wykonywane) i mogą
mieć różne strategie, np.:
● są partie działające “z rozmachem”, które zawsze wybierają najdroższe możliwe
działanie (na które pozwala im budżet)
● są partie działające “skromnie”, które zawsze wybierają najtańsze możliwe działanie
● są partie działające “zachłannie”, starają się wybierać takie działanie, które w
największym stopniu zwiększy sumę sum ważonych cech swoich kandydatów w
danym okręgu wyborczym
Można przyjąć dowolną kolejność wykonywania działań przez partie (np. na przemian lub
losowo).
Napisz program, który przeprowadzi symulację przeprowadzenia procesu wyborczego:
formowania okręgów wyborczych, kampanii wyborczej, głosowania oraz przeliczania głosów
na mandaty. Ponieważ metoda przeliczania głosów na mandaty jest losowana przed
kampanią, więc chcemy zasymulować ten proces dla każdej z 3 wspomnianych metod.
Zaimplementuj również przynajmniej jedną dodatkową strategię partii, wczuwając się w rolę
jej stratega (możesz przyjąć, że masz pełną wiedzę o wagach cech wszystkich wyborców,
podziale na okręgi wyborcze i aktualnej (wybranej) metodzie przeliczania głosów na
mandaty w parlamencie).
Należy przyjąć, że program symulujący przeprowadzenie procesu wyborczego wczytuje
wszystkie parametry z plików wejściowych (i ścieżka do pliku wejściowego jest jedynym
argumentem programu). Format pliku wejściowego:
● pierwszy wiersz zawiera cztery liczby oddzielone spacją, są to kolejno:
○ n - liczba podstawowych okręgów wyborczych (ze zbioru {5,6, …, 100})
○ p - liczba partii (ze zbioru {1,2,...,20})
○ d - liczba możliwych działań (ze zbioru {1,2,3,...,15})
○ c - liczba cech kandydatów (ze zbioru {5,6,7,...,100})
● drugi wiersz zawiera liczbę par podstawowych okręgów wyborczych, które należy
scalić (jest to liczba ze zbioru {0,1,....,⌊n/2⌋}), a następnie (po spacji) tyle właśnie par
postaci (o,o+1), gdzie o i o+1 to identyfikatory okręgów (liczby ze zbioru {1,2,3,....,n}),
ponieważ scalanie nie jest iterowane, więc dany okręg może wystąpić co najwyżej w
1 parze (pojedyncza para jest reprezentowana jako napis, np. “(o,o+1)”, a pary są
oddzielone spacją)
● trzeci wiersz zawiera p nazw partii (przyjmujemy, że nazwa partii jest zawsze jednym
wyrazem, a nazwy są oddzielone spacją)
● czwarty wiersz zawiera p liczb b1, b2, …, bp, określających budżety poszczególnych
partii, mogą być to dowolne dodatnie liczby całkowite (mieszczące się w granicy
zakresu Integer), kolejność jest taka sama jak w wierszu powyżej
● piąty wiersz składa się z p znaków (oddzielonych spacjami) ze zbioru {‘’R’,’S’,’W’,’Z’},
odpowiadających strategiom poszczególnych partii (kolejność jest taka sama jak w
wierszu powyżej):
○ ‘R’ - partia działa “z rozmachem”
○ ‘S’ - partia działa “skromnie”
○ ‘W’ - partia korzysta z dodatkowej strategii zaimplementowanej przez Ciebie
○ ‘Z’ - partia działa “zachłannie”
● szósty wiersz zawiera n liczb postaci 10k (gdzie k może być liczbą ze zbioru
{1,2,3,....,100}) - są to liczby wyborców w każdym podstawowym okręgu wyborczym
(w rzeczywistości okręgi wyborcze są większe, ale możemy przyjąć, że nasz 1
wirtualny wyborca odpowiada dużej liczbie rzeczywistych wyborców)
● w kolejnych wierszach są opisy poszczególnych kandydatów, każdy kandydat jest w
osobnym wierszu, kandydaci są pogrupowani okręgami (zgodnie z ich rosnącymi
numerami), w ramach okręgu partiami (kolejność partii taka sama jak podana
wcześniej), a w ramach partii występują w pliku zgodnie z rosnącą pozycją na liście.
Każdy wiersz ma postać: imię nazwisko numer_okręgu nazwa_partii
pozycja_na_liscie w1 w2 … wc
, gdzie w1 w2 … wc
to wartości cech (liczby całkowite z
przedziału [-100, 100]). nazwa_partii musi być jedną z nazw podanych wcześniej,
numer okręgu musi być liczbą całkowitą ze zbioru {1,2,...,n}, pozycja_na_liscie jest
liczbą całkowitą ze zbioru {1,2,...,liczba_wyborców_w_okręgu / 10}.
● kolejne wiersze zawierają opis wyborców, jeden wiersz zawiera opis jednego
wyborcy, najpierw wypisani są wszyscy wyborcy z okręgu 1, potem wszyscy wyborcy
z okręgu 2, itd. Każdy wiersz zawiera imię, nazwisko, numer podstawowego okręgu
wyborczego oraz typ wyborcy, który jest reprezentowany jako liczba:
○ 1 - Żelazny elektorat partyjny
○ 2 - Żelazny elektorat kandydata
○ 3 - Minimalizujący jednocechowy wybierający spośród wszystkich partii
○ 4 - Maksymalizujący jednocechowy wybierający spośród wszystkich partii
○ 5 - Wszechstronny wybierający spośród wszystkich partii
○ 6 - Minimalizujący jednocechowy wybierający spośród jednej partii
○ 7 - Maksymalizujący jednocechowy wybierający spośród jednej partii
○ 8 - Wszechstronny wybierający spośród jednej partii
Dodatkowo, w przypadku wyborców typu 1 i 2 w tym samym wierszu mamy jeszcze
(po spacji) nazwę partii, a w przypadku wyborców typu 2 dodatkowo jeszcze pozycję
kandydata na liście partii (ponieważ kandydaci mogą mieć takie samo imię i
nazwisko, więc to partia i pozycja na liście w okręgu jednoznacznie identyfikuje
kandydata). W przypadku wyborców typu 5 i 8 mamy za to wartości bazowe wag,
które dany wyborca przypisuje poszczególnym cechom kandydatów: w1, w2, …, wc
(dla każdego wyborcy kolejność wartości wag jest taka sama). Wszystkie te wartości
są oddzielone pojedynczą spacją i powinny być ze zbioru: {-100,-99,…,0,...,99,100}.
W przypadku wyborców typu 8 na końcu (po wagach) powinna być jeszcze nazwa
partii. W przypadku wyborców typu 3,4,6,7 po typie jest natomiast (po spacji) jedna
liczba ze zbioru {1,2,...,c}, określająca która wartość cechy kandydatów powinna być
maksymalizowana/minimalizowana, a w przypadku wyborców typu 6 i 7 potem jest
jeszcze (po spacji) nazwa partii.
● w kolejnych d wierszach jest opis możliwych działań, każdy wiersz zawiera c liczb
całkowitych (oddzielonych spacją) ze zbioru {-10,-9,....,0,...,9,10} określających jak
zmieniają się wartości każdej spośród c wag poszczególnych cech kandydatów w
okręgu wyborczym, w którym zastosowano dane działanie (kolejność wartości wag
odpowiada kolejności cech w przypadku kandydatów).
Można przyjąć poprawność danych wejściowych.
W wyniku dla każdej z 3 metod przeliczania głosów na mandaty program powinien wypisać
w kolejnych wierszach:
● nazwę metody przeliczania głosów
● dla każdego okręgu wyborczego (podstawowego lub scalonego - można przyjąć
dowolnie):
○ nr okręgu wyborczego (w przypadku scalonego okręgu można podać 2
numery)
○ imię i nazwisko wyborcy, imię i nazwisko kandydata, na którego głosował (po
1 wierszu na wyborcę)
○ imię i nazwisko kandydata, jego partię i numer na liście oraz łączną liczbę
głosów na niego (po 1 wierszu na kandydata)
○ ciąg par (nazwa partii, liczba mandatów z danego okręgu)
● łącznie (dla wszystkich okręgów): ciąg par (nazwa partii, liczba mandatów ze
wszystkich okręgów)
