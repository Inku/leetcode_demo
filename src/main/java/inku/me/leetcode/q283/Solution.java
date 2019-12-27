package inku.me.leetcode.q283;

import com.alibaba.fastjson.JSON;
import inku.me.leetcode.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Solution extends TestSupport {
    private int[] nums;

    @BeforeEach
    void befor() {
        this.nums = new int[]{1, 0, 0, 3, 12};
    }

    @Test
    void test() {
        moveZeroes1(nums);
        logger.info(JSON.toJSONString(nums));
    }

    private void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    private void moveZeroes1(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
