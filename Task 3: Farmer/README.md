### Treść zadania

Zadanie polega na implementacji prostego systemu symulującego rolnika gospodarującego swoim ogrodem warzywnym w czasie rzeczywistym. Rolnik ma do dyspozycji ogród, który ma k miejsc na warzywa (parametr konstruktora). W każdym z tych miejsc rolnik może posadzić warzywo. Istnieją różne rodzaje warzyw: pomidory, ogórki, ziemniaki, rzodkiewki, itp. Posadzenie każdego warzywo kosztuje pewną kwotę pieniędzy (zależnie od rodzaju warzywa), oraz każde warzywo ma swoją funkcję wartości w zależności od czasu posadzenia. Przykładowo dla ziemniaka może być to funkcja skokowa --- ziemniak dojrzewa 10 sekund podczas których wart jest 0, a potem jest wart 5 PLN. Z kolei pomidor jest na początku wart 0 przez 10 sekund, potem jego cena rośnie liniowo do 10 PLN przez 5 sekund, a potem przez 5 sekund maleje liniowo do 0 (kiedy to pomidor gnije i jest już wart 0). Warzywo powinno mieć metodę pozwalającą ocenić jego obecną wartość, zaś rolnik może się pytać o obecne wartości warzyw poprzez ogród. 

 

W każdym momencie rolnik może zebrać warzywo z danego miejsca w ogrodzie. Wtedy to wartość warzywa ustala się na obecną ocenę jego wartości, zaś miejsce zajmowane przez warzywo opróżnia się tak, że można tam posadzić coś nowego. Zauważ, że rolnik nie zna konkretnie funkcji oceny danego warzywa, a jedynie może pytać konkretne instancje o obecną wartość.

 

Docelowo chcielibyśmy napisać metodę rolnika simulate(Garden g, int time), która w (początkowo pustym) ogrodzie symuluje jeden sezon sadowniczy trwający time sekund. Podczas tego czasu rolnik ma sadzić i zbierać warzywa z ogrodu według wybranej przez siebie strategii. Rolnik powinien na bieżąco informować o swoich działaniach (przykładowo, wypisywanie na ekran "Zebrałem ziemniaka! Wartość: 5 PLN"), a na koniec wypisać raport z sezonu: listę zebranych warzyw oraz sumaryczne kwoty przychodów (z zebranych warzyw) i kosztów (na sadzenie roślin). Zaimplementuj dwie strategie rolnika:

  - PracownikPGR: regularnie co dziesięć sekund zbiera wszystko z ogrody nie zważając na obecne wartości i sadzi wszędzie losowo wybrane warzywo.

  - Gospodarz: co sekundę przegląda stan wszystkich posadzonych warzyw, i jeśli wartość warzywa zmalała od ostatniego sprawdzenia, to zbiera to warzywo i sadzi nowe, losowo wybrane.


Zaimplementuj ten system tak, by móc w metodzie main w rolniku przetestować kilka różnych przebiegów metody simulate dla różnych ogrodów i różnych strategii rolnika. Zacznij oczywiście od zaprojektowania hierarchii klas dla tego systemu. Zaimplementuj tak ze 3 przykładowe warzywa spośród których rolnik może wybierać. Wszelkie nieścisłości w powyższym opisie interpretuj według swojego uznania.


Przydatne rzeczy, których powinieneś się samodzielnie nauczyć z internetu do wykonania tego zadania:
  - generowanie liczb losowych: klasa Random
  - sprawdzanie obecnego czasu systemowego : System.currentTimeMillis()
  - czekanie odpowiednią liczbę milisekund : Thread.sleep()
  - rozszerzalna lista (do zebranych warzyw) : klasa ArrayList<E>
