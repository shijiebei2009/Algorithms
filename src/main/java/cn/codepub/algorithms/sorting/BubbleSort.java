package cn.codepub.algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>
 * Created with IntelliJ IDEA. 2016/1/8 19:37
 * </p>
 * <p>
 * ClassName:BubbleSort
 * </p>
 * <p>
 * Description:冒泡排序
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class BubbleSort {
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public void swap(int[] nums, int one, int two) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{7, 3, 4, 23, 3, 9};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
