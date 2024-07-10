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

}
