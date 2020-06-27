### Task3
The first line of input contains a positive number n, next n lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph. Please provide a working code that will give us the answer for the following questions: how many separated graphs are in the input.

Sample:

For the input:
```
3
1 2
2 3
5 6

```

expected output is:

```
2
```


## Requirements
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Build app localy and run
Being in the project main directory, run
```shell
mvn package
```
then go to the target directory which contains the built application. To run the applications use the command: 
```shell
java -jar .\Task3-1.0.jar -f <path to file>
```
contents of the test.txt file:
```
3
1 2
2 3
5 6

```

```shell
java -jar .\Task3-1.0.jar -f test.txt
```
