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
    System.arraycopy(array,index+1,res,index,array.length-index-1);
    return res;
}
}