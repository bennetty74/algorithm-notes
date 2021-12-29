package org.bugkit.leetcode;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * @author bugkit
 * @since 2021.12.29
 */
public class MajorElement {

    public int majorityElement(int[] nums) {
        // 假设众数是第一个
        int major = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            // 相同+1
            if (nums[i] == major) {
                cnt++;
            } else {
                // 不用-1，等于0后则重新选择i+1个元素作为众数
                cnt--;
                if (cnt == 0) {
                    major = nums[i + 1];
                }
            }
        }
        return major;
    }

}
