### Wprowadzenie
Podstawowym składnikiem wirusów jest kwas nukleinowy (RNA lub DNA). Dla uproszczenia
przyjmijmy, że jest to ciąg składający się z 4 typów nukleotydów: A,C,G,T. Różne wirusy
mogą mieć kwasy nukleinowe różnej długości (kolejność nukleotydów też ma znaczenie).
Gdy wirus infekuje organizm, układ odpornościowy wytwarza przeciwciała. Przyjmijmy, że
każde przeciwciało jest w stanie zniszczyć wirusa, jeśli jego kwas nukleinowy zawiera
określony ciąg nukleotydów (dzięki temu przeciwciało jest w stanie “zidentyfikować” wirusa,
wejść w reakcję ze zidentyfikowaną częścią jego kwasu nukleinowego i zniszczyć w ten
sposób strukturę wirusa). Układ odpornościowy jest w stanie produkować nowe przeciwciała,
aby zniszczyć nowe typy napotkanych wirusów, ale “dostosowanie się” do danego wirusa
zajmuje mu trochę czasu. Jest to jeden z powodów stosowania szczepień.
Szczepionka jest preparatem biologicznym imitującym naturalną infekcję celem
doprowadzenia do wyprodukowania przez organizm przeciwciał, które będą w stanie
poradzić sobie z prawdziwym wirusem. Szczepionki tworzy się “przeciwko” konkretnym
białkom (spójnym ciągom nukleotydów), więc można przyjąć, że tworząc szczepionkę znamy
dokładnie spójny ciąg nukleotydów, przeciwko któremu będzie ona skuteczna. Możemy
przyjąć, że dla danej szczepionki każdy organizm reaguje tak samo i wytwarza zawsze
dokładnie takie same przeciwciała “atakujące” zawsze ten sam spójny ciąg nukleotydów co
w szczepionce.
Niestety wirusy mogą mutować (ich nukleotydy mogą zmieniać się np. w trakcie infekowania
komórki nosiciela i kopiowania kwasu nukleinowego), tworząc różne szczepy, co utrudnia
tworzenie skutecznych szczepionek. Wirusy mogą mutować na różne sposoby. Są np.
wirusy “dziwne”, w których mutacja polega na zamianie miejscami nukleotydów z 2 losowych
pozycji w kwasie nukleinowym. Są też wirusy “specyficzne”, w przypadku których
pojedyncza mutacja to zmiana losowego nukleotydu w ciągu na nukleotyd innego typu, przy
czym mutować mogą tylko nukleotydy na określonych pozycjach w ciągu (dla uproszczenia
przyjmijmy, że indeksy tych pozycji nie zmieniają się pomimo mutacji), zaś nukleotyd po
mutacji może być tylko określonego typu, który należy do specyficznego dla danego wirusa
podzbioru (co najmniej 2-elementowego) nukleotydów {A,C,G,T}.
Wirusy mogą mutować z różną częstotliwością. Przyjmijmy, że każdy wirus ma określoną
liczbę mutacji w miesiącu i jest to zawsze liczba całkowita (i przyjmijmy dla uproszczenia, że
jest ona stała dla danego wirusa, bez względu na zachodzące mutacje). Mutacje mogą być
niedeterministyczne (a ewolucja wirusa może zależeć od wielu czynników), więc w praktyce
trudno jest przewidzieć jak dokładnie będzie ewoluował dany wirus, ale możemy spróbować
to zasymulować!
### Zadanie
Napisz kod w Javie, który zasymuluje mutacje danego wirusa przez określoną liczbę
miesięcy oraz sprawdzi, czy przeciwciała wytworzone dzięki podaniu zadanej szczepionki na
starcie symulacji, będą skuteczne również po tym czasie i obronią organizm przed
zmutowanym wirusem, którego otrzymamy na końcu symulacji. Ponieważ mutacje są
niedeterministyczne, więc symulujemy jeden z wielu możliwych scenariuszy mutacji i
chcemy sprawdzić, czy wirus, jaki otrzymamy na końcu, będzie odporny na przeciwciało
wytworzone na początku symulacji (wynik powtórzenia tego eksperymentu może być inny).
Zaimplementuj wszystkie potrzebne klasy.
