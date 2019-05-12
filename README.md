# RpgGame
Make a RPG Game

>General
-Clicker Heroes game in java Maven.
-Player vs Ai
-Player can be stronger and stronger like in the rpg games.
-Players' have lot of stats like Money, Damage, Critical Chance, Critical damage,
	Damage, Ai Damage, Lvl and more...

>General infos
- Based on MVC pattern.
- JavaFX the front-end.
- Logged the modell, dao package.

>Database	
- Created with JPA (EmbeddedDriver - Derby) local datastore.
- Player's stats stored.

>CheckStyle
- command: mvn site
- Extensive.
- Based on "checkstyle.xml"

>Test:
- command: mvn test
- Some simple JUnit test for modell classes.

>Creating JAR:
- command: mvn package

>Running:
- command: mvn compile exec:java
- The main class: MainApp.java
