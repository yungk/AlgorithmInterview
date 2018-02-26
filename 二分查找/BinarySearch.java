/**
 * @author: luoluo
 * @description:非递归的二分查找算法
 * @Date: Created in 23:31 2018/2/23
 * @modified By:
 */
public class BinarySearch {

    public static int find(int[] arr, int target) {

        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (r-l)/2 + l;

            if (target > arr[mid]) {
                l = mid;
            } else if (target < arr[mid]) {
                r = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
