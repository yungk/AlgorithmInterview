import java.util.Arrays;

/**
 * @author: luoluo
 * @description:冒泡排序
 * @Date: Created in 14:06 2018/2/26
 * @modified By:
 */
public class BubbleSort {

    public static void main(String[] args) {
        sort(new int[]{1, 2, 4, 6, 11, 15, 8, 5});
    }

    // 我们的算法类不允许产生任何实例
    private BubbleSort(){}

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length-1; j >i ; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr,j-1,j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
