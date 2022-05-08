/**
 * @author Lovsog
 * 2022/4/18
 * LeetCode 1534.统计好三元组
 **/
class Solution_1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int num = 0;
        for(int i = 0; i < arr.length-2; ++i){
            for(int j = i+1; j < arr.length-1; ++j) {
                if(Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j+1; k < arr.length; ++k) {
                        if(Math.abs(arr[j] - arr[k]) <= b) {
                            if(Math.abs(arr[i] - arr[k]) <= c) {
//                                System.out.println(i+" "+j+" "+k);
                                num++;
                            }
                        }
                    }
                }
            }
        }
        return num;
    }
}

public class NO_1534 {
    public static void main(String[] args) {
        System.out.println(new Solution_1534().countGoodTriplets(new int[]{1,1,2,2,3}, 0, 0 ,1));
    }
}
