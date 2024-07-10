package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

public class ArraysTest {
int[] numbers = {10, 7, 12, -4, 13, 3, 14};

@Test
void searchTest() {
    assertEquals (0, search(numbers, 10));
    assertEquals (6, search(numbers, 14));
    assertEquals (3, search(numbers, -4));
    assertEquals (-1, search(numbers, 100));
    assertFalse(numbers.length==0);
}

@Test
void addTest() {
    int newNumber = 100;
    int [] expected = {10, 7, 12, -4, 13, 3, 14, newNumber};
    assertArrayEquals(expected, addNumber(numbers, newNumber));
    assertFalse(numbers.length==0);
}

@Test
void insertTest() {
    int number=100;
    int index = 0;
    int [] array = {5,6,9,1,5,3,8};
    int [] expected = {number,5,6,9,1,5,3,8};
    assertArrayEquals(expected, insert(array, index , number));
    index = 7;
    int [] expected2 = {5,6,9,1,5,3,8,number};
    assertArrayEquals(expected2, insert(array, index , number));
    index = 4;
    int [] expected3 = {5,6,9,1,number,5,3,8};
    assertArrayEquals(expected3, insert(array, index , number));
    assertFalse(array.length==0);
}

@Test
void removeTest() {
int index=0;
int [] array = {5,6,9,1,5};
int [] expected = {6,9,1,5};
assertArrayEquals(expected, remove(array, index));
index = 1;
int [] expected2 = {5,9,1,5};
assertArrayEquals(expected2, remove(array, index));
index = 2;
int [] expected3 = {5,6,1,5};
assertArrayEquals(expected3, remove(array, index));
index = 3;
int [] expected4 = {5,6,9,5};
assertArrayEquals(expected4, remove(array, index));
index = 4;
int [] expected5 = {5,6,9,1};
assertArrayEquals(expected5, remove(array, index));
assertFalse(array.length==0);
}
}