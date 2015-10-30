package cn.codepub.algorithms.sort;

import java.util.Arrays;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/17 22:30
 * </p>
 * <p>
 * ClassName:InsertSort
 * </p>
 * <p>
 * Description:插入排序
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9090, 4, 5, 2, 3, 1, 4, 5, 4, 4, 8989, 4};
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));

    }

    //交换函数
    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
