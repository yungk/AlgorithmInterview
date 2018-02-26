import java.util.Arrays;

/**
 * @author: luoluo
 * @description:
 * @Date: Created in 16:10 2018/2/22
 * @modified By:
 */
public class InsertSort {

    public static void main(String[] args) {
        sort(new int[]{2, 34, 4, 5, 6, 11, 1});

    }

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
