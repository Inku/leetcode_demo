package inku.me.leetcode.q26;

import inku.me.leetcode.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Solution extends TestSupport {
    private int[] nums;

    @BeforeEach
    void befor() {
        this.nums = new int[]{1, 1, 2};
//        this.nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    }

    @Test
    void test() {
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            logger.info(nums[i] + "");
        }
    }

    private int removeDuplicates(int[] nums) {
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            int e = nums[i];
            if (e > nums[length - 1]) {
                nums[length] = e;
                length++;
            }
        }
        return length;
    }

    //官方解答
    private int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
