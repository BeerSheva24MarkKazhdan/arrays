package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer arg0, Integer arg1) {
        return arg0%2==0 && arg0%2==0 && arg0>arg1 ? 1: arg0%2!=0 && arg1%2!=0 && arg0<arg1 ? 1: arg0%2!=0 && arg1%2==0 ? 1 : 0;
    }

}
