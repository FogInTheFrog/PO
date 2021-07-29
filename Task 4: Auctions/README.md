### Treść zadania

W Wielkim Domu Aukcyjnym królestwa Bajtocji rozpoczyna się doroczna aukcja.

Na sprzedaż wystawione zostają przedmioty przywiezione z najdalszych zakątków świata. Każdy
przedmiot charakteryzuje się określonym rokiem produkcji oraz krajem pochodzenia, jest też opatrzony
ceną (wyrażoną dodatnią liczbą całkowitą), którą chce za niego otrzymać dom aukcyjny.

Licytator (osoba prowadząca aukcję) stosuje się do pradawnej procedury. Na początek ustawia
wszystkich uczestników w szereg zgodny z kolejnością przyjścia uczestnika na aukcję. Następnie sięga
po pierwszy przedmiot i proponuje go kolejnym uczestnikom. Jeżeli jakiś uczestnik zdecyduje się na
kupno przedmiotu, przemieszcza się na koniec szeregu. Jeżeli nikt nie zdecyduje się na kupno, przedmiot
nie zostaje sprzedany w tym roku, a kolejność w szeregu się nie zmienia. Licytator przeprowadza tę samą
procedurę dla wszystkich przedmiotów (ustawienie w szereg odbywa się jednak tylko raz). Przekazanie
przedmiotów uczestnikom odbywa się po zakończeniu aukcji i nie należy się nim przejmować.

Każdy uczestnik przybywa na aukcję z ograniczonym budżetem, wyrażonym dodatnią liczbą całkowitą.
Łączna cena przedmiotów, które kupi na aukcji nie może być większa od budżetu (każdy uczestnik
skrupulatnie tego pilnuje, prawo Bajtocji surowo karze bowiem za tego typu przewinienia). Aby chronić
swoje dane, posługuje się też (często bardzo fantazyjnym) pseudonimem.

Istnieje wiele rodzajów uczestników, różniących się tym, jaką strategię stosują przy decyzji o zakupie
zaproponowanych przedmiotów:
- Sentymentalny: tęskni za swoim rodzinnym krajem, kupuje tylko przedmioty pochodzące z tego
kraju,
- Oszczędny: nigdy nie kupuje pierwszego przedmiotu, jaki zostanie mu zaproponowany. Każdy
kolejny przedmiot kupuje tylko i wyłącznie wtedy, gdy jego cena jest niższa niż średnia cena
przedmiotów, które zostały mu wcześniej zaproponowane.
- BardzoOszczędny - kupuje produkty co najmniej 10% tańsze od średniej
- SentymentalnyZOgraniczeniem - kupuje maksymalnie n przedmiotów (n zadane w konstruktorze)

Możliwe są również inne strategie decyzji o kupnie.
### Zadanie:
1. Zaprojektuj i przedstaw w postaci schematu UML hierarchię klas pozwalającą przeprowadzić
aukcję opisaną w zadaniu. W klasach umieść odpowiednie atrybuty i metody, oznacz
dziedziczenie, abstrakcyjność i interfejsy. Opisz wszelkie stosowane skróty notacyjne.
Twoja hierarchia powinna zawierać klasę Licytator z metodą przeprowadź, przyjmującą tablicę
przedmiotów i tablicę uczestników w kolejności przyjścia na aukcję, zwracającą zaś tablicę tej
samej długości, co tablica przedmiotów, w której pod i­tym indeksem znajduje się uczestnik,
który kupił i­ty przedmiot, lub null jeżeli nikt nie zdecyował się na jego kupno. Sprzedaż
pojedynczego przedmiotu może mieć złożoność liniową względem liczby uczestników.

2. Zaimplementuj w Javie konstruktory i wszystkie metody dla wszystkich rodzajów uczestników
opisanych w zadaniu (jak również metody innych klas, z których korzystają).

3. Zaimplementuj w Javie metodę przeprowadź klasy Licytator o sygnaturze opisanej w punkcie
pierwszym, realizującą przebieg pojedynczej aukcji. Można przyjąć, że wszystkie argumenty są
poprawne i nie trzeba ich sprawdzać. Należy zaimplementować wszystkie niestandardowe
metody wywoływane w przeprowadź

4. Nie trzeba implementować procesu rozdawania, interesują nas jedynie uczestnicy aukcji. W main należy zaprezentować jak przyjmują (lub nie) zadany ciąg przedmiotów.

5. Przyjmijmy na potrzeby tego zadania że rozpatrujemy jedynie przedmioty z 4 z góry określonych krajów
