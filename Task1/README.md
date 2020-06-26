### Task1
TThe input is a long set of integers. Please write a small app that will output the list of distinct elements sorted in ascending order, plus the basic measurement information that contains the number of elements in the source, number of distinct elements, min and max value.
 
 Sample:
 
 For the input:
```
1 10 20 20 2 5

```

expected output is:

```
1 2 5 10 20
count: 6
distinct: 5
min: 1
max: 20
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
java -jar .\Task1-1.0.jar -f <path to file>
```
contents of the test.txt file:
```
1 10 20 20 2 5

```

```shell
java -jar .\Task2-1.0.jar -f test.txt
```
