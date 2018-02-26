package heap;

import java.util.Arrays;
import java.util.Date;

/**
 * @author: luoluo
 * @description:
 * @Date: Created in 20:17 2018/2/22
 * @modified By:
 */
public class MaxHeap {

    private int[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(int[] nums) {
        data = new int[nums.length+1];
        count = nums.length;
        this.capacity = nums.length;

        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = nums[i];
        }

        for (int i = count/2; i >=1 ; i--) {
            shuifDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int num) {
        assert count + 1 <= capacity;
        data[count + 1] = num;
        count++;
        shiftUp(count);
    }

    public int extractMax(){
        int max = data[1];
        swap(count, 1);
        data[count] = 0;
        count--;
        shuifDown(1);
        return max;
    }

    private void shuifDown(int num) {
        while (num * 2 <= count) {
            int j = 2 * num;
            if (j + 1 <= count && data[j+1] > data[j]) {
                j++;
            }
            if (data[j] < data[num]) {
                break;
            }
            swap(j, num);
            num = j;
        }
    }

    public void shiftUp(int count) {
        int num = count;
        while (num > 1 && data[num]>data[num/2]) {
            swap(num, num / 2);
            num /= 2;
        }
    }

    public void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static void main(String[] args) {
        //MaxHeap maxHeap = new MaxHeap(100);
        //maxHeap.insert(65);
        //maxHeap.insert(33);
        //maxHeap.insert(22);
        //maxHeap.insert(11);
        //maxHeap.insert(5);
        MaxHeap maxHeap = new MaxHeap(new int[]{2,3,5,4,11,8,9,22,33,65});
        System.out.println(maxHeap.size());
        System.out.println(Arrays.toString(maxHeap.data));

        //System.out.println(maxHeap.extractMax());
        //System.out.println(Arrays.toString(maxHeap.data));
    }
}
