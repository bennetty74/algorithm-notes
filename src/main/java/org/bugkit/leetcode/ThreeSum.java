package org.bugkit.leetcode;

import java.util.*;

/**
 * @author bugkit
 * @since 2022.1.20
 */
public class ThreeSum {

    boolean lower = false, higher = false;

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        if (nums.length <= 2) {
            return new ArrayList<>(res);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int target = -nums[i];
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    Collections.sort(list);
                    res.add(list);
                    if (higher) {
                        right--;
                    } else if (lower) {
                        left++;
                    } else {
                        break;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                    lower = true;
                    higher = false;
                } else {
                    right--;
                    higher = true;
                    lower = false;
                }
            }
        }
        return new ArrayList<>(res);
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
//        int[] sorted = new int[]{-5, -3, -3, -2, -2, -2, -1, -1, 0, 1, 1, 1, 2, 3, 3, 4, 4};
        int[] sorted = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
//        int[] sorted = new int[]{0,0,0};
        System.out.println(threeSum.threeSum(sorted));
    }


}