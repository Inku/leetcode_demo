package inku.me.leetcode.q66;

import com.alibaba.fastjson.JSON;
import inku.me.leetcode.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Solution extends TestSupport {
    private int[] nums;

    @BeforeEach
    void befor() {
        this.nums = new int[]{0};
    }

    @Test
    void test() {
        int[] arr = plusOne(nums);
        logger.info(JSON.toJSONString(arr));
    }

    private int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            System.arraycopy(digits, 0, arr, 1, digits.length);
            return arr;
        }
        return digits;
    }

    private int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
