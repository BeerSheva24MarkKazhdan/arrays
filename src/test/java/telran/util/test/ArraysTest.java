package telran.util.test;

import org.junit.jupiter.api.Test;

import telran.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Comparator;
import java.util.Random;

public class ArraysTest {
private static final int N_ELEMENTS = 1_000;

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

 //HW6

@Test
void sortTest(){
    int[]testArray = java.util.Arrays.copyOf(numbers, numbers.length);
    int[] expected = {-4,3,7,10,12,13,14};
    sort(testArray);
    assertArrayEquals(expected, testArray);
}

@Test
void sortTestRandomArray(){
int[] array = getRandomArray(N_ELEMENTS);
int limit = array.length-1;
sort(array);
for(int i = 0; i < limit; i++){
assertTrue(array[i] <= array[i+1]);
}
}

private int[] getRandomArray(int nElements) {
    int[] res = new int[nElements];
    Random random = new Random();
    for(int i = 0; i< nElements; i++){
        res[i] = random.nextInt(0,10000);
    }
    return res;
}

@Test
void binarySearchTest(){
assertFalse(numbers.length==0); //Check zero lenght of array
int[] sortedArray = java.util.Arrays.copyOf(numbers, numbers.length); //Make a copy of origin Array for further sorting
sort(sortedArray); //Sort array
assertEquals(0, Arrays.binarySearch(sortedArray, -4)); // Checking binary search method for correct indexes
assertEquals(3, Arrays.binarySearch(sortedArray, 10)); // Checking binary search method for correct indexes
assertEquals(6, Arrays.binarySearch(sortedArray, 14)); // Checking binary search method for correct indexes
assertEquals(-1, Arrays.binarySearch(sortedArray, -5)); //Checking binary search for out of array values. 0 should be at 0 position, so method must return -1 value (-index - 1)
assertEquals(-8, Arrays.binarySearch(sortedArray, 15)); //Checking binary search for out of array values. 8 should be at 7 position, so method must return -8 value (-index - 1)
int[]shortArray = {1,2};
int[] sortedShortArray = java.util.Arrays.copyOf(shortArray, shortArray.length); //Make a copy of origin shortArray for further sorting
sort(sortedShortArray); //Sort shortArray
assertEquals(-3, Arrays.binarySearch(sortedShortArray, 5)); //Checking binary search for out of array values. 0 should be at 0 position, so method must return -1 value (-index - 1)
}

@Test
void insertSortredTest(){
assertFalse(numbers.length==0); //Check zero lenght of array
int[] sortedArray = java.util.Arrays.copyOf(numbers, numbers.length); //Make a copy of origin Array for further sorting
sort(sortedArray); //Sort array
int[]expected = {-4,3,7,10,11,12,13,14};
assertArrayEquals(expected, insertSorted(sortedArray, 11)); //Check if the "key" value is really at sorted array
int[]expected2 = {-5,-4,3,7,10,12,13,14};
assertArrayEquals(expected2, insertSorted(sortedArray, -5)); //Check if the "key" value is really at sorted array
int[]expected3 = {-4,3,7,10,12,13,14,15};
assertArrayEquals(expected3, insertSorted(sortedArray, 15)); //Check if the "key" value is really at sorted array
int[]expected4 = {-4,3,3,7,10,12,13,14};
assertArrayEquals(expected4, insertSorted(sortedArray, 3)); //Check if the "key" value is really at sorted array and correct work with already existing values
}

@Test
void isOneSwapTest(){
    int[]array = {1,2,3,9,5,6,7,8,4}; //Array with one swap to be sorted array
    int[]sortedArray = java.util.Arrays.copyOf(array, array.length); //Make a copy of random Array for further sorting
    sort(sortedArray);//Sort array
    assertTrue(isOneSwap(array, sortedArray)); //Check if array need only one swap to be sorted
    int[]array2 = {1,2,9,8,5,6,7,4,3};//Array with two swaps to be sorted array
    int[]sortedArray2 = java.util.Arrays.copyOf(array, array.length); //Make a copy of random Array for further sorting
    sort(sortedArray);//Sort array
    assertFalse(isOneSwap(array2, sortedArray2)); //Check if array has more than one swap to be sorted
}
@Test
void sortAnyTypeTest(){
String [] strings = {"lmn", "cfta", "w", "aa"};
String [] expectedASCIIStrings = {"aa", "cfta", "lmn", "w"};
String [] expectedLength = {"w", "aa", "lmn", "cfta"};
sortT(strings, new ComparatorASCII());
assertArrayEquals(expectedASCIIStrings, strings);
sortT(strings, new ComparatorLength());
assertArrayEquals(expectedLength, strings);
}
@Test
void binarySearchTTest(){
    Comparator<String> compStrings = new ComparatorASCII();
    Comparator<Integer> compInteger = new ComparatorInteger();
    Comparator<String> compLength = new ComparatorLength();
Integer[] array = {6,2,9,8,7};
String[] strings = {"lmn", "cfta", "w", "aa"};
Arrays.sortT(array, compInteger);
assertEquals(-2, Arrays.binarySearchT(array, 3, compInteger));
assertEquals(0, Arrays.binarySearchT(array, 2, compInteger));
assertEquals(4, Arrays.binarySearchT(array, 9, compInteger));
assertEquals(2, Arrays.binarySearchT(array, 7, compInteger));
Arrays.sortT(strings, compStrings);
assertEquals(-1, Arrays.binarySearchT(strings, "a", compStrings));
assertEquals(0, Arrays.binarySearchT(strings, "aa", compStrings));
assertEquals(1, Arrays.binarySearchT(strings, "cfta", compStrings));
Arrays.sortT(strings, compLength);
assertEquals(-5, Arrays.binarySearchT(strings, "akdtf", compLength));
assertEquals(0, Arrays.binarySearchT(strings, "w", compLength));
assertEquals(3, Arrays.binarySearchT(strings, "cfta", compLength));
}
@Test
void binarySearchNoComparator() {
    String [] strings ={"aa", "cfta", "lmn", "w"};
    Person prs1 = new Person(10, "Vasya");
    Person prs2 = new Person(20, "Itay");
    Person prs3 = new Person(30, "Sara");
    Person [] persons = {
        prs1, prs2, prs3
    };
    assertEquals(1, binarySearchNoComp(strings, "cfta"));
    assertEquals(0, binarySearchNoComp(persons, prs1));
    assertEquals(-1, binarySearchNoComp(persons, new Person(5, "Serg")));
}
@Test
void evenOddSorting() {
    Integer[] array = {7, -8, 10, -100, 13, -10, 99};
    Integer[] expected = {-100, -10, -8, 10, 99, 13, 7}; //even numbers in ascending order first, odd numbers in descending order after that
    sortT(array, new EvenOddComparator());
    assertArrayEquals(expected, array);
}
@Test
void findTest() {
    Integer[] array = {7, -8, 10, -100, 13, -10, 99};
    Integer [] expected = {7, 13, 99};
    assertArrayEquals(expected, find(array, new OddNumbersPredicate()));
}
@Test
void removeIfTest(){
    Integer[] array = {7, -8, 10, -100, 13, -10, 99};
    Integer[] expected = {-8,10,-100,-10};
    assertArrayEquals(expected, removeIf(array, new OddNumbersPredicate()));
}
}