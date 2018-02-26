import java.util.Arrays;

/**
 * @author: luoluo
 * @description:
 * @Date: Created in 19:06 2018/2/22
 * @modified By:
 */
public class QuickSort3Ways {

    public static void main(String[] args) {
        sort(new int[]{3,4,5,61,2,3,44});
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {

        if (r <= l) {
            return;
        }
        int v = arr[l];
        int lt = l;
        int gt = r+1;
        int i = l + 1;
        while (gt > i) {
            if (arr[i] > v) {
                swap(arr,i,gt-1);
                gt--;
            } else if (arr[i] < v) {
                swap(arr, i, lt+1);
                i++;
                lt++;
            }else{
                i++;
            }
        }
        swap(arr, l, lt);

        sort(arr, l, lt);
        sort(arr, gt, r);
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
