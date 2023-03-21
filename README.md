## Circular singly linked list class

### Description
This is a Java program that implements a singly circular linked list.
The first implementation of the list is singly linked list without using
built-in collections. The refactored variant is linked list, that uses 
built-in collections.

###Variant
The option is determined by the remainder of dividing the number of the gradebook 
by 4:

My number of the gradebook: 1332

1332 % 4 = 0

Variant: 0

**Initial list implementation:** circular singly linked list without using built-in collections

**Second implementation:** list based on built-in arrays/lists

## Instruction

+ Install the **Java Development Kit (JDK)** and **Apache Maven**
+ Clone **repo** on your computer.
```cmd
git clone https://github.com/hrystynaa/mtsd_lab2.git
```
+ **How to run example program:**

    + **Compile the code:** Open the command prompt and navigate to the directory
  with the ***Example.java*** file.
  Enter the following command to compile the code:
  ```
  cd ./mtsd_lab2/src/main/java/lab2
  javac Example.java
  ```

  + **Run the program:** After successful compilation, you can run the program by entering the following command in the command prompt:
  ```
   java Example
  ```
+ **How to run tests:**
```
cd .
mvn test
```
> [Failed CI Commit](https://github.com/hrystynaa/mtsd_lab2/commit/e77101a1d9ca6b283ce1ba5e73155e79ec705e33)

##Conclusion

I believe that unit tests are very useful because they can save a 
lot of time for developers first and foremost. For example, in my project, 
I wrote tests for the first implementation of a class, and thanks to this, 
refactoring the code and writing another implementation was much easier because 
I didn't worry about breaking anything. Unit tests help ensure the reliability
and stability of the program, 
which is very important when one mistake can cause too much loss.
