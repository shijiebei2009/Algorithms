package cn.codepub.algorithms.sorting;

import java.util.Arrays;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/19 10:17
 * </p>
 * <p>
 * ClassName:ShellSort
 * </p>
 * <p>
 * Description:希尔排序
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 4, 1, 11, 12, 122, 122, 1222, 12222, 14433};
        int length = nums.length;
        int d = 1;
        while (d < length / 3) {
            //之所以对d进行这种操作，是因为如下性质：使用递增序列1, 4, 13, 40, 121, 364…的希尔排序所需的比较次数不会超出N的若干倍乘以递增序列的长度
            d = d * 3 + 1;
        }
        while (d >= 1) {
            for (int i = d; i < length; i++) {
                for (int j = i; j >= d; j -= d) {
                    if (nums[j - d] > nums[j]) {
                        swap(nums, j, j - d);
                    }
                }
            }
            d = d / 3;
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
