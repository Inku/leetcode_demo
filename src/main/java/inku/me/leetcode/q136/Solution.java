package inku.me.leetcode.q136;

import inku.me.leetcode.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Solution extends TestSupport {
    private int[] nums;

    @BeforeEach
    void befor() {
        this.nums = new int[]{4, 1, 2, 1, 2};
    }

    @Test
    void test() {
        int i = singleNumber(nums);
        logger.info(i + "");
    }

    private int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
