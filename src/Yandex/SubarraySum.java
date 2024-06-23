package Yandex;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for(int num : nums){
            sum += num;  // Calculate the running sum
            if(sum == k) // If runningSum is equal to k, then add 1 to count
                count++;
            if(map.containsKey(sum - k)) // If map contains a prefix sum of sum-k, then add the freq of prefixSum
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1); // Add the curr sum to the map with the corresponding frequency
        }
        return count;
    }
}
