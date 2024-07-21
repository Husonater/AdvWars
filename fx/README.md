Dies ist die Projektarbeit von Jonas Thiel, Nico Nasuti, Lars Zeppenfeld, Vincent Radelj

Die Aufgabe war eine JavaFX Anwendung zu erstellen, die wie das Spiel Advance-Wars funktioniert.
->https://github.com/appenmaier/java_ti23/blob/main/description.md

Die Karten erstellung funktioniert ueber die Datei Karte.java, die einzelnen Schritte zum erstellen sind kommentiert.
Die Terrains sind definiert und mit Maus Click auf die Karte werden sie mit Koordinaten in dem Terminal ausgegeben 

Die Klass Troops ist die Superklasse von Air und Ground. Ground ist die Superklasse von allen Bodeneinheiten.
Air ist die Superklasse von allen Lufteinheiten.

Die Objekte werden auf die Karte platziert, die start Werte werden in der GUI mitgegeben. Symbole fuer die Truppen
sind nicht auf der Karte.


Idee von uns war es mithilfe dem erstellten  Grid/Array in der Klasse Karte die position mit einer getMethode abzurufen
und somit zu ermitteln ob eine Truppe auf dem Feld steht und wenn ja diese dan bewegen zu koenne.
-> Problem wir haben die Methode fuer das bestaetigen eines besetzten Feldes nicht umseten koenne, da JavaFX sehr unhandlich ist.