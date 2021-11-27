# esercitazioneFile
Create application able to read file .dat end analize

This application is able to analize two difference kind of .dat file:
football.dat
weather.dat

When you choose a file the application will read the file to create 
ObjectReadDto list.
Through this list it will be possible to analyze the data and return the necessary result.
The structure of the project is generic, two interfaces have been implemented that can also be reused for new files (obviously these interfaces need to be configured)


## For running the program you need:
- Java 1.8
- Maven (for running unit test)

## Compile and running Unit Test:
- mvn clean verify

## Running example
- cd target 
- java -classpath esercitazione-service-1.0.0.jar it.fabio.esercitazione.Main