import java.util.Arrays;

/**
 * @author: luoluo
 * @description:二路快排
 * @Date: Created in 17:31 2018/2/22
 * @modified By:
 */
public class QuickSort2 {

    public static void main(String[] args) {
        sort(new int[]{3,4,5,61,2,3,44});
    }

    public static void sort(int[] arr) {
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int l, int r) {
        if (r < l) {
            return;
        }
        int partition = partition(arr, l, r);
        sort(arr, l, partition - 1);
        sort(arr, partition + 1, r);
    }

    public static int partition(int[] arr, int l, int r) {

        int v = arr[l];
        int i = l+1;
        int j = r;
        while (true) {
            while (i<=r && arr[i]<v) i++;
            while (j>=l+1 && arr[j]>v) j--;
            if (j < i) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}

