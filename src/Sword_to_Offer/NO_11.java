package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/10
 **/
class Solution_11 {
    public int minArray(int[] numbers) {
        int low = 0;                                //开头
        int high = numbers.length - 1;              //结尾
        while (low < high) {
            int pivot = low + (high - low) / 2;     //二分取中
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}

public class NO_11 {
    public static void main(String[] args) {
        System.out.println(new Solution_11().minArray(new int[]{3, 4, 5, 1, 2}));
    }
}
