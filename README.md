# Bingo Game (Java Swing)

Ein einfaches Bingo-Spiel mit grafischer Benutzeroberfläche (GUI), entwickelt in **Java** mit **Swing**.  
Das Spiel zeigt ein 5x5-Bingo-Feld, zieht automatisch zufällige Zahlen und überprüft, ob der Spieler ein Bingo erreicht hat.

---

##  Funktionen

-  **Grafische Oberfläche** mit Hintergrundbild (`bingo_bg.png`)
-  **Automatische Zufallsziehung** von Bingo-Zahlen (1–75)
-  **Interaktive Buttons**: Klick auf Zahlen, um sie zu markieren
-  **Timer**: Alle 5 Sekunden wird eine neue Zahl gezogen
-  **Bingo-Erkennung**: Vertikal, horizontal und diagonal
-  **Benachrichtigung** per `JOptionPane`, ob der Spieler gewonnen oder verloren hat

---

##  Klassenstruktur

### 1. `Main.java`
Startpunkt der Anwendung.  
Erzeugt ein Fenster (`JFrame`) und fügt die `Karte`-Komponente hinzu.

### 2. `Karte.java`
Die Hauptklasse des Spiels – erbt von JPanel und enthält:
- Spiellogik
- Benutzeroberfläche
- Timer für die Zahlenziehung
- Bingo-Prüfung
