# Aufgabe 3: Differentialrechnung (15 Punkte)

In dieser Aufgabe implementieren wir einen Ableitungsrechner für elementare Funktionen. Insbesondere lernen
wir das Entwurfsmuster Komposition kennen, das es uns ermöglicht nahezu beliebig komplexe Strukturen aus
vielen einfachen Basisklassen zusammenzusetzen.

## Architektur des Ableitungsrechners

Zentraler Dreh- und Angelpunkt des Ableitungsrechners ist das Interface Function, das eine beliebige
differenzierbare*, reellwertige Funktion darstellt. Jede Implementierung von Function definiert zum einen, welche
Funktion sie darstellt und zum anderen, wie man diesen speziellen Typus von Funktion ableitet.

*Uns genügt es, wenn die Funktion auf einem hinreichend großen Intervall differenzierbar ist. Beispielsweise ist
die Wurzelfunktion lediglich auf R differenzierbar, wovon wir uns aber nicht aufhalten lassen wollen und
Wurzelfunktionen trotzdem zulassen.

## Kompositum

Das Kompositum ist eines der bekanntesten Entwurfsmuster und wird in der Softwaretechnik Vorlesung nochmal
in besonderer Breite behandelt. Der Grundgedanke dieses Entwurfsmusters ist es, eine Abstraktionsschicht, in
diesem Fall ein Interface, zu schaffen, sodass sowohl einzelne als auch zusammengesetzte Objekte einer
gewissen Kategorie gleich behandelt werden können. Dafür implementiert sowohl jedes einzelne Objekt das
gemeinsame Interface, als auch diejenigen Klassen, die mehrere Objekte zusammenfassen.
Im konkreten Beispiel implementiert sowohl die Klasse Identity, die die Identitätsfunktion darstellt, das Interface
Function als auch die Klasse Sum, die die Summe mehrerer Funktionen modelliert, also selbst wiederum aus
Objekten zusammengesetzt ist, die das Interface Function implementieren. Damit ist es egal ob unser Programm
eine konkrete Funktion, oder die Summe mehrerer Funktionen erhält. Beide bieten die selbe Schnittstelle und
können genau gleich behandelt werden.

Mehr Hintergrundinfos zum Kompositum Entwurfsmuster liefert der entsprechende Wikipedia-Artikel
(https://de.wikipedia.org/wiki/Kompositum_(Entwurfsmuster)).

## Unveränderbarkeit

Eine weitere Programmierstrategie, die sich als effizient und Fehler vermeidend erwiesen hat, ist die der
_immutable Objects_ , also der unveränderlichen Objekte. So sollten alle Klassen, bei denen es nicht unbedingt
notwendig ist, so aufgebaut sein, dass sich die in Ihnen gekapselten Daten nach der Erstellung eines Objekts nicht
mehr ändern können. Ein schönes Beispiel dafür ist die Klasse String.

Um diese Unveränderbarkeit zu gewährleisten, sollen alle Felder aller Klassen, die für diese Aufgabe
implementiert werden, als **private final** deklariert sein.

## Implementierung

Zuerst erstellen wir das Interface Function, das das gemeinsame Verhalten aller Funktionen modelliert. Daraufhin
werden wir einige Basisfunktionen implementieren, aus denen sich dann komplexere Formeln zusammensetzen
lassen. Zuletzt implementieren wir mit dem Newton-Verfahren zum finden von Nullstellen einen Anwendungsfall
für unseren Ableitungsrechner und zeigen anhand einiger Beispiele, dass er funktioniert.

```
+
```

Wenn nichts näher angegeben ist, dann ist der Konstruktor der jeweiligen Klasse immer der Standardkonstruktor
nach dem Schema Klasse().

### Das Interface Function

Erstellen Sie im Paket de.uniwue.gdp.diffcalc das Interface Function. Es soll genau die folgenden zwei
Methoden umfassen:

```
double evaluate(double x);: rechnet den Funktionswert an der Stelle x aus.
Function derive();: gibt die erste Ableitung der Funktion zurück.
```
### Basisfunktionen

Implementieren Sie die im Folgenden beschriebenen Klassen im Paket de.uniwue.gdp.diffcalc. **base**. Jede
dieser Klassen soll das Interface Function implementieren.

#### Constant.java

Die konstante Funktion - Erstellen Sie die Klasse Constant mit folgendem Konstruktor:

```
public Constant(double value): Erstellt eine neue konstante Funktion mit dem angegebenen Wert.
```
Für die konstante Funktion _f_ mit dem Wert _n_ gilt:

```
f(x) = n
f'(x) = 0
```
#### Identity.java

Die Identitätsfunktion - Erstellen Sie die Klasse Identity.

Für die Identitätsfunktion _f_ gilt:

```
f(x) = x
f'(x) = 1
```
#### Sum.java

Die Summenfunktion - Erstellen Sie die Klasse Sum mit folgendem Konstruktor:

```
public Sum(Function summand1, Function summand2): Erstellt eine neue Summe aus den
angegebenen Summanden.
```
Für die Summe _f_ der Summanden _g_ und _h_ gilt:

```
f(x) = g(x) + h(x)
f'(x) = g'(x) + h'(x)
```
#### Power.java

Die Potenzfunktion - Erstellen Sie die Klasser Power mit folgendem Konstruktor:

```
public Power(double exponent): Erstellt eine neue Potenzfunktion mit dem angegebenen Exponenten.
```
Für die Potenzfunktion _f_ mit dem Exponenten _k_ gilt:

```
f(x) = x
f'(x) = k * x
```
```
k
k-
```

#### Factor.java

Der konstante Vorfaktor - Erstellen Sie die Klasse Factor mit folgendem Konstruktor:

```
public Factor(double factor, Function function): Erstellt eine neue Vorfaktor-Funktion mit dem
angegebenen Faktor und der angegebenen Funktion.
```
Für die Vorfaktor-Funktion _f_ mit dem Faktor _n_ und der Funktion _h_ gilt:

```
f(x) = n * h(x)
f'(x) = n * h'(x)
```
#### Product.java

Die Produktfunktion - Erstellen Sie die Klasse Product mit folgendem Konstruktor:

```
public Product(Function factor1, Function factor2): Erstellt eine neue Produktfunktion mit den
angegebenen Faktoren.
```
Für das Produkt _f_ der Faktoren _g_ und _h_ gilt:

```
f(x) = g(x) * h(x)
f'(x) = g(x) * h'(x) + g'(x) * h(x)
```
Die entsprechende Ableitungsregel dürfte Ihnen als Produktregel bekannt sein.

#### Reciprocal.java

Die Reziprokenfunktion („eins durch ...“) - Erstellen Sie die Klasse Reciprocal mit folgendem Konstruktor:

```
public Reciprocal(Function function): Erstellt eine neue Reziprokenfunktion der angegebenen
Funktion.
```
Für die Reziprokenfunktion _f_ der Funktion _h_ gilt:

#### Sine.java

Die Sinusfunktion - Erstellen Sie die Klasse Sine.

Für den Sinus _f_ gilt:

```
f(x) = sin(x)
f'(x) = cos(x)
```
#### Cosine.java

Die Cosinusfunktion - Erstellen Sie die Klasse Cosine.

Für den Cosinus _f_ gilt:

```
f(x) = cos(x)
f'(x) = -sin(x)
```
#### Tangent.java

Die Tangensfunktion - Erstellen Sie die Klasse Tangent.


Für den Tangens _f_ gilt:

```
f(x) = tan(x)
```
#### Exponential.java

Die Exponentialfunktion - Erstellen Sie die Klasse Exponential.

Für die Exponentialfunktion _f_ gilt:

```
f(x) = e
f'(x) = e
```
#### Logarithm.java

Die Logarithmusfunktion - Erstellen Sie die Klasse Logarithm.

Für die Logarithmusfunktion _f_ gilt:

```
f(x) = ln(x)
f'(x) = 1/x
```
#### Composition.java

Die Verkettungsfunktion - Erstellen Sie die Klasse Composition mit folgendem Konstruktor:

```
public Composition(Function outer, Function inner): Erstellt eine neue Verkettungsfunktion aus
den beiden angegebenen Funktionen.
```
Für die Verkettungsfunktion _f_ aus der äußeren Funktion _g_ und der inneren Funktion _h_ gilt:

```
f(x) = g(h(x))
f'(x) = g'(h(x)) * h'(x)
```
Die entsprechende Ableitungsregel dürfte Ihnen als Kettenregel bekannt sein.

### Beispielfunktionen

Zum Testen Ihrer Implementierung erstellen wir einige aufwendigere Funktionsterme.

Erstellen Sie im Paket de.uniwue.gdp.diffcalc die Klasse Examples und mindestens die folgenden drei
Methoden:

```
public Function example1(): gibt die Funktion x³ - 2x + 2 aus.
public Function example2(): gibt die Funktion aus.
public Function example3(): gibt die Funktion aus.
```
### Newton-Verfahren

Das Newton-Verfahren (https://de.wikipedia.org/wiki/Newton-Verfahren) wird zur numerischen Annäherung von
Nullstellen und Schnittpunkten, bzw. allgemein zur Lösung nichtlinearer Gleichungen verwendet.

```
x
x
```

Führt man für einen hinreichend guten Startwert _x_ die Iterationsformel

oft genug aus, so konvergiert diese gegen eine Nullstelle der Funktion _f_.
Den Schnittpunkt zweier Funktionen _g_ und _h_ erhält man entsprechend, indem man die Nullstelle der Funktion _g - h_
findet.

Erstellen Sie im Paket de.uniwue.gdp.diffcalc die Klasse Newton mit den Methoden:

```
public double zero(Function function, double x0): führt das Newton-Verfahren für die gegebene
Funktion und den gegebenen Startwert durch und gibt den x-Wert der gefundenen Nullstelle zurück.
public double intersection(Function f, Function g, double x0): führt das Newton-Verfahren für
die gegebenen Funktionen und den gegebenen Startwert durch und gibt den x-Wert des Schnittpunkts
zurück.
```
Da das Newton-Verfahren nicht zu einem exakten Ergebnis kommt und je nach Startwert nicht oder nicht mit
einem sinnvollen Ergebnis terminiert sollen sie die Berechnung unter bestimmten Umständen abbrechen.
Ist für ein _x_ der Funktionswert _f(x)_ betragsmäßig kleiner als 10 , dürfen Sie _x_ als Nullstelle betrachten.
Findet der Algorithmus nach 2 Iterationsschritten keine solche Nullstelle oder ist der Funktionswert _f(x)_ bzw.
_f'(x)_ nicht bestimmbar (beispielsweise die Wurzel einer negativen Zahl), dürfen Sie den Algorithmus abbrechen
und ein beliebiges Ergebnis ausgeben.

Die Beispielfunktionen aus dem vorherigen Aufgabenteil haben alle eindeutige Nullstellen, die mit dem Newton-
Verfahren gefunden werden können. Allerdings gibt es in allen drei Fällen Startwerte, für die das Verfahren zu
keinem Ergebnis kommt.

Beispiel: Die unter Beispielfunktionen definierte Funktion _x³ - 2x + 2_ hat eine Nullstelle bei _x_ ≈ -1.769292. Für
negative Startwerte sollte diese auch immer gefunden werden. Für die Startwerte 0 oder 1 hingegen wird das
Newton-Verfahren in eine Endlosschleife laufen und immer zwischen genau diesen beiden Werten schwanken.

## Testen

Testen Sie Ihre Klassen ausführlich!

Erstellen Sie mindestens für jede Klasse einen Testfall, der eine entsprechende Funktion baut und jeweils an
verschiedenen Stellen auswertet. Vergleichen Sie die ausgegebenen Werte (z.B. mit WolframAlpha
(http://www.wolframalpha.com/)). Testen Sie daraufhin die Ableitung der Funktion auf die gleiche Weise.

Testen Sie insbesondere mehrere verschachtelte Funktionen.

## PABS Tests

Die Fehlermeldung eines PABS Tests könnte zum Beispiel so aussehen:
java.lang.AssertionError: [Testing f'' with f(x) = tan(x²). Functions differed at x =
0.805286]
Expecting:
<-3.0406769367041577>
to be close to:
<9.337822377150792>

```
0
```
```
n n -9 n
```
(^16) _n
n_


PABS 3.7 - University of Würzburg - Impressum (https://www.uni-wuerzburg.de/sonstiges/impressum/) -
Datenschutz (https://www.uni-wuerzburg.de/sonstiges/datenschutz/)

Getestet wurde die zweite Ableitung (f'') der Funktion _f(x) = tan(x²)_. Für den Test wurde die Funktion _f_ aus den von
Ihnen implementierten Basisklassen aufgebaut und dann zweimal abgeleitet. Daraufhin wurde für _x_ der Wert
0,805286 eingesetzt und der Funktionswert mit einem Referenzergebnis verglichen. Der Funktionswert, den die
getestete Implementierung lieferte (-3.0406769367041577), weicht dabei zu sehr vom Referenzwert
(9.337822377150792) ab, weshalb der Test in diesem Beispiel fehlschlägt.

## Bewertung

In dieser Aufgabe können Sie auch durch unvollständige oder fehlerhafte Abgaben Punkte erlangen. Die
Punktzahl richtet sich dabei nach den bestandenen Unit-Tests. PABS wird Ihrere Abgabe als `accepted`
markieren, egal wie viele PABS Tests Sie bestanden haben. Lassen Sie sich von einer grün markierten Aufgabe
also nicht in die Irre führen.

# Viel Spaß!


