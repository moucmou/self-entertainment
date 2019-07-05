package note.sort;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/7/5 14:04
 */
public class QuickSort {

    /**
     * 简单快排
     */
    static List<Integer> list = Arrays.asList(5, 6, 8, 1, 3, 7, 10, 4, 6);

    public static void main(String[] args) {
        Integer[] array = list.toArray(new Integer[0]);
        srot(array, 0, 8);
        System.out.println();
    }

    private static void srot(Integer[] array, int left, int right) {
        if (left >= right || ArrayUtils.isEmpty(array))
            return;
        int i = left;
        int j = right;
        int key = array[i];
        while (i < j) {
            while (i < j && array[j] >= key) j--;
            array[i] = array[j];
            while (i < j && array[i] <= key) i++;
            array[j] = array[i];
        }
        array[j] = key;
        srot(array, left, i - 1);
        srot(array, i + 1, right);
    }

}
