package inku.me.leetcode.q1;

import inku.me.leetcode.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution extends TestSupport {
    private int[] nums;
    private int target;

    @BeforeEach
    void befor() {
        this.nums = new int[]{2, 7, 11, 15};
        this.target = 18;
    }

    @Test
    void test() {
        int[] arr = twoSum2(nums, target);
        for (int i : arr) {
            logger.info(i + "");
        }
    }

    private int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
