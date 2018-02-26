import java.util.Arrays;

/**
 * @author: luoluo
 * @description: 归并排序
 * @Date: Created in 16:23 2018/2/22
 * @modified By:
 */
public class MergeSort {

    public static void main(String[] args) {
        sort(new int[]{3,2,1,2,4,4,33,22,44});
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {

        if (r <= l) {
            return;
        }

        int mid = (r - l) / 2 + l;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int[] ints = Arrays.copyOfRange(arr, l, r + 1);

        int i = l,j = mid+1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = ints[j-l];
                j++;
            } else if (j > r) {
                arr[k] = ints[i-l];
                i++;
            } else if (ints[i - l] > ints[j - l]) {
                arr[k] = ints[j - l];
                j++;
            }else{
                arr[k] = ints[i - l];
                i++;
            }
        }

    }
}
