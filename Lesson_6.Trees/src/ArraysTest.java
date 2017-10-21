///1. Реализовать простейшую хеш-функцию. На вход функции подаётся строка, на выходе сумма кодов символов.
import java.util.*;
class ArraysTest{
    public static void main(String[] args){
        int[] a = {34, -45, 12, 67, -24, 45, 36, -56};
        Arrays.sort(a);
        for (int i: a)
            System.out.print(a[i] + " ");
        System.out.println();
        Arrays.fill(a, Arrays.binarySearch(a, 12), a.length, 0);
        for (int i: a)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}