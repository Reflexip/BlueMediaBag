Aplikacja symulująca Koszyk Zakupowy

Program działa w konsoli. 
Starałem się każdą klasę opisać tak by jego działanie było jasne dla osób trzecich. 

Program uruchamia metoda Main, która posiada tylko jedną instrukcję tworzącą obiekt klasy Display.

Opis klas:

Display - jest klasą główną. W konstruktorze przyjmuje dwa argumenty - obiekt klasy zawierający bazę produktów
oraz obiekt klasy Bag (koszyk). Posiada tylko jedną instrukcję a mianowicie wywołanie metody chooseProdukt,  która jest metodą główną 
zawierającą instrukcję sterującą do - while. Wewnątrz pętli do while
zastosowałem instrukcję sterującą if else, która porównuje wprowadzany przez użytkownika tekst i gdy spełnia on któryś warunek - 
wykonuje odpowiedni blok kodu. Po wpisaniu 'exit' program przerywa działanie, a wszystkie dane zostają utracone. Jeżeli użytkownik wpisze
cokolwiek - przypadkowy ciąg znaków - pętla po prostu powtórzy działanie ponieważ żaden z warunków nie został spełniony.
Klasa display posiada także metodę productsView która przyjmuje jako argument obiekt klasy zawierający bazę produktów. 
Zastosowałem pętle 'for each' dla wyświetlenia wszystkich produktów z bazy, ich opisów i cen.

BagDisplay - klasa która w konstruktorze przyjmuje jako argument obiekt klasy Bag. Instrukcja sterująca 'for each' wyświetla wszystkie produkty,
ich ilości oraz przelicza końcową należność za każdą pozycję. Klasa używa własnej metody showDetails do wyświetlenia ilości produktów oraz 
całkowitego kosztu zakupów.

BillPrinter - klasa która w konstruktorze przyjmuje jako argument obiekt klasy Bag. Posiada trzy metody odpowiadające odpowiednio za:
 - wyświetlenie daty i godziny wizyty
 - wyświetlenie zakupionych produktów oraz całkowitego kosztu
 - wyświetlenie pożegnania i zaproszenia do kolejnej wizyty
Klasa posiada prywatne pole decimalFormat do poprawnego wyświetlenia liczb typu double(poprawnego tj. dwa miejsca po przecinku).

ShopProductsBase - klasa posiada pole prywatne typu ArrayList<Product>. W konstruktorze inicjuje nową listę, po czym dodaje do niej produkty.
Ponieważ w większości przypadków dla bezpieczeństwa wszystkie pola klas powinny być prywatne, klasa posiada metodę dostępową która zwraca 
listę typu ArrayList.

Product - klasa posiada 3 wymagane pola. Dodatkowo zastosowałem pole 'amount' typu int które przedstawia ilość danego produktu w koszyku - 
liczba ta jest zwiększana o 1 dzięki postinkrementacji, w przypadku gdy produkt jest usuwany z koszyka wartość zmiennej zostaje zmniejszona o 1
poprzez dekrementację. W konstruktorze przyjmuje 3 argumenty typów - String, String, double - odpowiadające kolejno za - nazwę, opis produktu 
oraz jego cenę.  Wszystkie pola są prywatne wobec czego klasa posiada do nich metody dostępowe.

Bag - Klasa posiada 5 pól:
    shoppingBag     - typu ArrayList - lista produktów znajdujących się w koszyku.
    dateOfShopping  - typu DateTime z biblioteki JodaTime - do wyświetlenia daty i godziny zakupów
    totalCost       - typu double - do wyliczenia całkowitego kosztu koszyka
    productCounter  - typu int - do wyliczenia ilości produktów
    decimalFormat   - typu DecimalFormat - do sformatowania wartości typu double
Klasa bag zawiera 3 metody:
    addProduct - Przyjmuje jako argumenty - bazę produktów w postaci ArrayListy oraz wpisany przez użytkownika ciąg znaków w postaci łańcucha String. 
Dzięki pętli 'for each' metoda przeszukuje bazę produktów w celu znalezienia produktu o takiej samej nazwie jak wpisany ciąg znaków jeżeli nie znajdzie 
kończy działanie.
Jeżeli znajdzie taki produkt wykonuje metodę 'alreadyInBag' która sprawdza czy ten produkt już znajduje się w koszyku. Jeżeli nie to dodaje go do 
shoppingBag(typu ArrayList)oraz inkrementuje pole 'amout' produktu przy użyciu metody 'Product.addOne()', zwiększa totalCost dla koszyka i jego productCounter.
Jeżeli produkt jest już w koszyku, metoda nie dodaje produktu do listy (już tam jest) a jedynie inkrementuje jego pole 'amount' przy użyciu metody 
'Product.addOne()' i jak poprzednio zwiększa totalCost dla koszyka i jego productCounter.

    removeProduct - metoda działa podobnie jak metoda addProduct z tym że, jeżeli pole 'amount' produktu wskazuje wartość większą niż 1 to dekrementuje je,
jeżeli wskazuje na wartość równą 1 - usuwa produkt z koszyka i oczywiście odpowiednio w obu przypadkach zmieniejsza jego productCounter poprzez dekrementacje.

Jako narzędzie wejścia zastosowałem obiekt klasy Scanner z argumentem System.in.

W wielu miejscach dodałem blok try catch z metodą Thread.sleep aby aplikacja działała nieco wygodniej i żeby użytkownik na bierząco widział efekty wpisywanych przez
siebie komend.
Dodałem bibliotekę JodaTime dlatego że chciałem użyć czegoś open-source, po drugie jak to kiedyś powiedział W. Seliga "Nie męczmy naszych apek java.util.date'em"

Całość jest budowana przez Maven'a - na nim pracowaliśmy w szkole. Pomyślałem, że to zawsze coś więcej niż zwykły projekt więc czemu go nie zastosować.

Autor:
Dawid Mudlaff
