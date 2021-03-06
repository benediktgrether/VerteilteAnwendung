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

1. Eclipse öffnen <br>
2. Eclipse in Applications Ordner verschieben <br>
3. Eclipse in Applications Ordner (Finder -> Programme) suchen und öffnen. <br>
4. Beim ersten Starten wird über ein Dialog Fenster abgefragt, <br>
> „Eclipse“ ist eine aus dem Internet geladene App. Möchtest du sie wirklich öffnen? <br>
und auf diesem Dialogfenster auf öffnen klicken. (Falls dieses Dialogfenster nicht erscheint und das Programm nicht startet, siehe Punkt 4.1.) <br>

![image](./img/001_image.png)

4.1. Systemeinstellung öffnen -> Sicherheit -> Allgemein -> Apps - Downlaod erlauben von -> Und dort dann zulassen. 

![image](./img/002_image.png)

5. Workspace auswählen. Danach sollte dieser Startdialog kommen. Darauf ist zu achten das Eclipse Java EE IDE for Web Developers im Header steht.

![image](./img/003_image.png)

<hr>

## Installierung von Tomcat Server 

[Download Tomcat](http://tomcat.apache.org/download-90.cgi) -> Die Core Datei [zip(pgp, sha512)](https://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.16/bin/apache-tomcat-9.0.16.zip)
> Speichere den Download von Tomcat am besten in deinem Download Ordner ab.

1. Tomcat zip File in Downloads entpacken. (Nach der Installation von Tomcat kann man diese Zip Datei wieder löschen.) <br>
2. Terminal öffnen. <br>
3. Nun wird die entpackte Datei verschoben. <br> 
```sudo mkdir -p /usr/local ``` <br>
```sudo mv ~/Downloads/apache-tomcat-9.0.16 /usr/local```<br>
! Bitte beachten welche Version runtergeladen wurde. Die Versionsnummer gegebenfalls Austauschen (tomcat-9.0.16). <br>

4. Um später einfacher eine neuere Version zu Integrieren ersetzen wir den Tomcat Ordner in /Library/Tomcat durch einen symbolic Link aus unserem usr/local ordner. <br>
```sudo rm -f /Library/Tomcat```<br>
```sudo ln -s /usr/local/apache-tomcat-9.0.16 /Library/Tomcat```<br>

1. Nun ändern wir noch die Rechte des Ordners.(Usernamen ohne Spitze klammern.) <br>
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

1. Eclipse öffnen. <br>
2. Willkommens Fenster schließen. <br>
3. Unten in der Leiste Server auswählen <br>

![image](./img/005_image.png)<br><br>
4. Neuen Server erstellen <br>
5. Den Apache Dropdown Ordner auswählen <br>
6. Tomcat v9.0 Server auswählen -> Next <br>
7. Bei Tomcat installation directory auf Browse klicken <br>
8. Nun im Dropdown Menü Festplatte auswählen.<br>

![image](./img/006_image.png)<br><br>
9. Nun Library -> Tomcat auswählen und auf Open clicken. <br>
10. Finsihed und dann Server starten klicken. <br>
11. Wenn alles funktioniert, steht in der Leiste Tomact v9.0 Server at Localhost[Started, Synchronized].<br>

![image](./img/007_image.png)<br><br>

<hr>

## Installation von MySQL

[MYSQL](https://dev.mysql.com/downloads/mysql/) herunterladen.

1. Am Ende der Installation wird gefordert das man ein Passwort erstellt. Dort wählt man nun Use Legacy Password Encryption <br>

![image](./img/008_image.png)<br><br>

2. Nun ein Passwort wählen und auf Finish klicken und den MacBook neustarten.<br>

![image](./img/009_image.png)<br><br>

3. Nun in den Systemeinstellungen überprüfen ob MySQL installiert ist, und überprüfen ob MySQL läuft.<br>

![image](./img/010_image.png)<br><br>
![image](./img/011_image.png)<br><br>

<hr>

## Installation von Sequel Pro

Sequel Pro über Homebrew installieren. 
1. Überprüfen ob Homebrew installiert ist. Dazu geben wir im Terminal<br>
```which brew``` <br>
ein 

> Homebrew ist installiert -> /usr/local/bin/brew -> weiter mit Punkt 3 <br>
> Homebrew ist nicht installiert -> brew not found -> weiter mit Punkt 2 <br>

2. Installieren von Homebrew falls es noch nicht vorhanden ist.<br>
[Homebrew Documentation](https://brew.sh/index_de)<br>
Im Terminal folgenden Befehl eingeben <br>
``` /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"```

3. Nun installieren wir Sequel Pro über Homebrew (Es kann sein das erst ein Update von Homebrew durchgeführt wird.) <br>
```brew cask install homebrew/cask-versions/sequel-pro-nightly```

![image](./img/012_image.png)<br><br>

4. Sequel Pro starten.
5. Im Connectionfenster nun TCP/IP auswählen und Daten eingeben.
   > Host: 127.0.0.1 <br>
   > Username: root <br>
   > Password: ****** <br>
   > Database und Port sind optional falls ein anderer Port wie 3306 in Verwendung ist.<br>

![image](./img/013_image.png)<br><br>
6. Connect <br>
   
7. Nun wird eine neue Datenbank angelegt. <br>
![image](./img/014_image.png)<br><br>

<hr>

## Datenbank mit Eclipse IDE for Enterprise Java Developers verbinden

1. Nun laden wir ein MySQL Package für Java herunter. <br>
[MySQL Package](https://www.mysql.com/de/products/connector/) <br> und wählen da JDBC Driver for MySQL (Connector/J) aus <br>

![image](./img/015_image.png)<br><br>
> Achtet beim Downloaden auf eure Aktuelle MySQL Version damit ihr den richtigen Connector auswählt.
2. Auf der Webseite wählen wir nun Platform Indepentent aus und Laden die Zip oder .tar Datei herunter.
3. Nun kopieren wir die Datei <br>
```mysql-connector-java-8.0.15.jar``` <br>
in den Ordner <br> ```Library/Tomact/lib/``` <br>
hinein. <br>

![image](./img/016_image.png)<br><br>
4. In Eclipse gehen wir auf den Reiter auf Data Source Explore und Database Connections mit rechtsklick und auf New <br>

![image](./img/017_image.png)<br><br>
5. Nun Generic JDBC auswählen und auf Next <br>

![image](./img/018_image.png)<br><br>
6. Nun werden wir einen neuen Driver hinzufügen in dem auf JAR List klicken und dann auf ADD JAR/Zip. Nun gehen wir wieder in den Library/Tomcat/lib/ Ordner und wählen mysql-connector-java-xxx.jar aus.<br>

![image](./img/019_image.png)<br><br> 
7. Danach Klicken wir auf Properties (es kann sein das Propertie nicht beim ersten mal Auftaucht. Bitte dann bei Driver files den Connector auswählen -> oder Edit und dann auf Abbrechen klicken und zurück in den Properties Reiter wieder Wechseln bis diese Abbildung dargestellt wird). <br>
   
![image](./img/020_image.png)<br><br> 
8. Nun geben wir diese Werte ein.
> Connection URL : jdbc:mysql://127.0.0.1:3306/Name-der-Datenbank <br>
> Database Name : "Name wie die Datenbank heißt"<br>
> Driver Class : -> Hier nun auf die ... Punkte klicken.<br>

![image](./img/021_image.png)<br><br> 
Hier wählen wir nun den untersten Database Driver aus 
![image](./img/022_image.png)<br><br> 
9. Nun auf Ok klicken und im nächsten Fenster geben wir nun folgende Sachen ein.
> Database: "Name der Datenbank" <br>
> URL:  dbc:mysql://127.0.0.1:3306/Name-der-Datenbank <br>
> User name: root <br>
> Password: ******* <br>

Dann die Checkbox Save Passwort auswählen und danach auf Test Connection.
![image](./img/023_image.png)<br><br> 
10. Bei erfolgreichem Test kommt dieser Dialog
![image](./img/024_image.png)<br><br> 
11. Nun auf Finish klicken und die Datenbank wird nun im Data Source Explorer angezeigt.
![image](./img/025_image.png)<br><br> 