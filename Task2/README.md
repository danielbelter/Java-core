### Task2
The input is a long set of integers. Provide a working code that will find all the pairs (in this set) that sum up to 13. Each pair in the output should have first number not greater than the second one and lines should be sorted in an ascending order.

Sample:

For the input:

```
1 2 10 7 5 3 6 6 13 0

```

expected output is:

```
0 13
3 10
6 7
6 7
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
java -jar .\Task2-1.0.jar -f <data file location after data>
```
contents of the test.txt file:
```
1 2 10 7 5 3 6 6 13 0

```

```shell
java -jar .\Task2-1.0.jar -f test.txt
```
