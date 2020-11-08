package com.turbosha.algorithm.offer;

/**
 * #11：旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class Solution11 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 1, 3};
        Solution11 s = new Solution11();
        s.minArray(arr);
    }

    // 官方：双指针，二分法
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = (left + right) / 2;
            if (numbers[temp] > numbers[right]) {
                left = temp + 1;// 这里+1，是因为即使发生旋转，旋转点也不会跳过
            } else if (numbers[temp] < numbers[right]) {
                right = temp; // 这里不能-1，是因为发生旋转，旋转点会跳过
            } else {
                right--; // 这里不能是right=temp;因为首尾相同时，可能会跳过旋转点
            }
        }
        return numbers[left];
    }


    // 自己做的
    public int minArray2(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) return numbers[i];
            min = numbers[i];
        }
        return numbers[0];
    }
}
