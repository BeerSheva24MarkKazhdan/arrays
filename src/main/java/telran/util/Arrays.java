package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;

public class Arrays {

public static int search(int [] array, int key){
int index = 0;
while (index < array.length && key !=array [index]) {
    index++;
}
return index == array.length ? -1 : index;
}

public static int[] addNumber(int [] array, int numbers) {
int[] res = java.util.Arrays.copyOf(array, array.length + 1);
res[array.length] = numbers;
    return res;
}

public static int[] insert(int[] array, int index, int number) {
    int [] res = java.util.Arrays.copyOf(array,array.length+1);
    System.arraycopy(array,index,res,index+1,array.length - index);
    res[index] = number;
 return res;   
}
 
public static int[] remove(int[]array, int index) {
    int [] res = java.util.Arrays.copyOf(array,array.length-1);
    System.arraycopy(array,index+1,res,index,res.length-index);
    return res;
}

//HW 6

public static boolean pushMaxAtEnd(int[]array, int length){
    boolean res=true;

for(int i = 0; i < length; i++) {
    if (array[i] > array[i + 1]){
        res=false;
        swap(array, i, i + 1);
    }
}
return res;
}

private static void swap(int[] array, int i, int j) {
int tmp = array[i];
array[i] = array[j];
array[j] = tmp;
}

public static void sort(int [] array) {
    int length = array.length;
    boolean flSorted = false;
    while (!flSorted){
        length--;
        flSorted = pushMaxAtEnd(array, length);
}
}
/**
 *
 * @param array - sorted array
 * @param key - being searched number
 * @return see comments definition
 */
public static int binarySearch(int[] array, int key){
    int low = 0;
    int high = array.length - 1;
    int mid = low + ((high - low) / 2);
    while (low <= high) {
        if (array[mid] == key) {
            return mid;
        }
        else if (array[mid] < key) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        mid = low + ((high - low) / 2);
    }
    return -mid-1;
}

public static int[] insertSorted(int[] array, int number){
    int keyIndex = binarySearch(array, number);
    if (keyIndex < 0){
        keyIndex = Math.abs(keyIndex)-1;
    } 
    array=insert(array, keyIndex, number);
    return array;
}
public static boolean isOneSwap(int [] array, int [] sortedArray) {
    int swap = 0;
    for (int i = 0; i < array.length; i++) {
        if (sortedArray[i] != array[i]){
            swap++;
        }
    }
if (swap == 2) {
    return true;
} else {
    return false;
}
}
    public static <T> void sortT(T[] array, Comparator<T> comparator) {
        int length = array.length;
        boolean flSort = false;
        do {
            length--;
            flSort = true;
            for(int i = 0; i < length; i++) {
                if(comparator.compare(array[i], array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    flSort = false;
                }
            }
        }while(!flSort);
    }

private static <T> void swap(T[] array, int i, int j) {
    T tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
}

public static <T> int binarySearchT(T[] array, T key, Comparator<T> comp) {
    int low = 0;
    int high = array.length - 1;
    int mid = low + ((high - low) / 2);
    int compRes = 0;
        while (low <= high && (compRes = comp.compare(array[mid], key))!=0) {
            if (compRes < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        mid = low + ((high - low) / 2);
        }

            return low>high ? -mid-1 : mid;
}

public static <T> int binarySearchNoComp(T[] array, T key) {
   //return java.util.Arrays.binarySearch(array, key);
    return  binarySearchT(array, key,(Comparator<T>) Comparator.naturalOrder());
}

public static <T> T[] insert(T [] array, int index, T item) {
    T[] res = java.util.Arrays.copyOf(array, array.length + 1);
    System.arraycopy(array, index, res, index + 1, array.length - index);
    res[index] = item;
    return res;
}
public static <T> T[] find(T[]array, Predicate<T> predicate) {
    T[] result = java.util.Arrays.copyOf(array, 0);
    for(int i = 0; i < array.length; i++) {
        if(predicate.test(array[i])) {
            result = insert(result, result.length, array[i]);
        }
    }
    return result;
}

public static <T> T[] removeIf (T[] array, Predicate<T> predicate){
    return find(array, predicate.negate());
}
} 