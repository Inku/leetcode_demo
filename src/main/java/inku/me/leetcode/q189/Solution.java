package inku.me.leetcode.q189;

import com.alibaba.fastjson.JSON;
import inku.me.leetcode.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Solution extends TestSupport {
    private int[] nums;
    private int k;

    @BeforeEach
    void befor() {
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        k = 13;
        k = k % nums.length;
    }

    @Test
    void test() {
        rotate(nums, k);
        logger.info(JSON.toJSONString(nums));
    }

    private void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        for (int i = 0; i < k ; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    private void rotate1(int[] nums, int k) {
        if (k == 0) {
            return;
        }

    }

    private void rotate2(int[] nums, int k) {
        if (k == 0) {
            return;
        }

    }
}
