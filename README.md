# range-formatter
This is my implementation of code which has the ability to produce a comma delimited list of numbers, grouping the numbers into a range when they are sequential.

# instructions:
### compile
javac -d out -sourcepath src\main\java src\main\java\numberrangesummarizer\*.java

###  run
java -cp out numberrangesummarizer.App

# To run tests
mvn test