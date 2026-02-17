# todomvc-java-selenium


## Kolejność / flow wywoływania klas (obiektów)

1. Startujemy z klasy z nazwa *Tests (single responsibility -> klasy z testami.)
2. Testy wołają klasy z pakietu *Steps (single responsibitlit -> te klasy definiuja kroki testu)
   a. Klasa PreconditionSteps* woła inne klasy *Steps (a nie PageObjecty)
3. Klasy *Steps (oprócz precondition) wołają klasy PageObject
4. Klasy PageObject odpowiadają za klikanie po web appce (singe responsibitlity -> klikanie)