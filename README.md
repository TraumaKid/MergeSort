# MergeSort in Java

This project provides a simple Java implementation of the Merge Sort algorithm.

## Features

- Efficient, stable sorting algorithm
- Works with integer arrays
- Well-commented and easy to understand

## Usage

1. Clone the repository.
2. Compile the Java files:
    ```sh
    javac src/Sorter.java
    ```
3. Run the program:
    ```sh
    java Sorter
    ```

## Example
```java
int[] arr = {5, 2, 9, 1, 5, 6};
Sorter.mergeSort(arr);
System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]
```
