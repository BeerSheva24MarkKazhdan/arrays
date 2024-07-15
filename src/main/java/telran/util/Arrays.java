package telran.util;

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
}