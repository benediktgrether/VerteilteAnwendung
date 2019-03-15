# Verteilte Anwendung

## Entwicklungsumgebung Eclipse Java Web Tools Platform 
[Entwicklungsumgebung Java Web Tools](https://www.eclipse.org/webtools/) Downloaden.

> Im Terminal überprüfen ob Java JDK installiert ist.
```Terminal
    java -version
```
> Falls Java JDK noch nicht installiert ist <br>
> [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

<hr>

### Eclipse IDE for Enterprise Java Developers installieren

1. Eclipse öffnen
2. Eclipse in Applications Ordner verschieben
3. Eclipse in Applications Ordner (Finder -> Programme) suchen und öffnen.
4. Beim ersten Starten wird über ein Dialog Fenster abgefragt,
> „Eclipse“ ist eine aus dem Internet geladene App. Möchtest du sie wirklich öffnen?
und auf diesem Dialogfenster auf öffnen klicken. (Falls dieses Dialogfenster nicht erscheint und das Programm nicht startet, siehe Punkt 4.1.)

![image](./img/001_image.png)

4.1. Systemeinstellung öffnen -> Sicherheit -> Allgemein -> Apps - Downlaod erlauben von -> Und dort dann zulassen. 

![image](./img/002_image.png)

5. Workspace auswählen. Danach sollte dieser Startdialog kommen. Darauf ist zu Achten was im Header steht. Eclipse Java EE IDE for Web Developers.

![image](./img/003_image.png)

<hr>

## Installierung von Tomcat Server 

[Download Tomcat](http://tomcat.apache.org/download-90.cgi) -> Die Core Datei [zip(pgp, sha512)](https://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.16/bin/apache-tomcat-9.0.16.zip)
> Speichere den Download von Tomcat am besten in deinem Download ordner ab.

1. Tomcat zip File in Downloads entpacken. (Nach der Installation von Tomcat kann man diese Zip Datei wieder löschen.)
2. Terminal öffnen.
3. Nun wird die entpackte Datei verschoben. <br> 
```sudo mkdir -p /usr/local ``` <br>
```sudo mv ~/Downloads/apache-tomcat-9.0.16 /usr/local```<br>
! Bitte beachten welche Version runtergeladen wurde. Die Versionsnummer gegebenfalls Austauschen (tomcat-9.0.13).

4. Um später einfacher eine neuere Version zu Integrieren ersetzen wir den Tomcat Ordner in /Library/Tomcat durch einen symbolic Link aus unserem usr/local ordner. <br>
```sudo rm -f /Library/Tomcat```<br>
```sudo ln -s /usr/local/apache-tomcat-9.0.16 /Library/Tomcat```<br>

5. Nun ändern wir noch den Eigentümer-Benutzers um mit dem Ordner arbeiten zu können. (Usernamen ohne spitzeklammern.) <br>
```sudo chown -R <your_username> /Library/Tomcat```<br>
> ```sudo chown -R benediktgrether /Library/Tomcat ```<br>

6. Alle Script ausführbar machen.<br>
```sudo chmod +x /Library/Tomcat/bin/*.sh``` <br>

7. Server starten<br>
```/Library/Tomcat/bin/startup.sh```<br>

8. Server stoppen<br>
```/Library/Tomcat/bin/shutdown.sh```

![image](./img/004_image.png)

<hr>

## Tomcat mit Eclipse IDE for Enterprise Java Developers verbinden

1. Eclipse öffnen.
2. Willkommens Fenster schließen.
3. Unten in der Leiste Server auswählen
![image](./img/005_image.png)<br><br>
4. Neuen Server erstellen
5. Den Apache Dropdown Ordner auswählen
6. Tomcat v9.0 Server auswählen -> Next
7. Bei Tomcat installation directory auf Browse klicken
8. Nun im Dropdown Menü Festplatte auswählen.
![image](./img/006_image.png)<br><br>

<!-- brew cask install homebrew/cask-versions/sequel-pro-nightly -->