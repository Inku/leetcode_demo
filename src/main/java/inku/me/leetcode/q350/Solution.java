package inku.me.leetcode.q350;

import com.alibaba.fastjson.JSON;
import inku.me.leetcode.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution extends TestSupport {
    private int[] nums1;
    private int[] nums2;

    @BeforeEach
    void befor() {
        this.nums1 = new int[]{1, 2, 2, 1};
        this.nums2 = new int[]{2, 2};
    }

    @Test
    void test() {
        int[] nums = intersect(nums1, nums2);
        logger.info(JSON.toJSONString(nums));
    }


    private int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }
        int index = 0;
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count > 0) {
                nums1[index] = num;
                index++;
                count--;
                map.put(num, count);
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }

    private int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    //有序数据
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}
