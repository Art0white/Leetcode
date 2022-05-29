import java.util.HashSet;
import java.util.Set;

/**
 * @author Lovsog
 * 2022/5/25
 **/

class Solution_1224 {
    public int maxEqualFreq(int[] nums) {
        //记录出现次数n的元素
        Set<Integer> set = new HashSet<>();
        //记录出现次数n-1的元素
        Set<Integer> set1 = new HashSet<>();
        //记录各个元素出现次数
        int[] arr = new int[100001];
        //n 记录相同元素出现的最多次数，m 出现过几种元素,k 记录出现n-1次元素的次数
        int n = 0 , m = 0 , max = 1 , k = 0;
        for(int i=0; i<nums.length; i++){
            arr[nums[i]]++;
            if(arr[nums[i]] > n){
                k = set.size()-1;
                n++;
                set.clear();
                set1.clear();
                set.add(nums[i]);
            }else if(arr[nums[i]] == n)
                set.add(nums[i]);
            else if(arr[nums[i]] == n-1)
                set1.add(nums[i]);
            if(arr[nums[i]] == 1) m++;
            //当前出现的元素都是出现次数相同，且不为最后一个元素
            if(set.size() == m && i != nums.length-1)
                max = i+2;
            //出现n次的有一个，同时剩下的m-1种元素都是出现n-1次；
            if(set.size() == 1 && set1.size()+k == m-1)
                max = i+1;
            //出现n次的有m-1个，同时剩下的1个元素只出现一次
            if(set.size() == m-1 && i == set.size()*n)
                max = i+1;
        }
        return max;
    }
}

public class NO_1224 {
    public static void main(String[] args) {
        System.out.println(new Solution_1224().maxEqualFreq(new int[]{2,2,1,1,5,3,3,5}));
    }
}
