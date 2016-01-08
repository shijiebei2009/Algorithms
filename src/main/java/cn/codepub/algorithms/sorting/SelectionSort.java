package cn.codepub.algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>
 * Created with IntelliJ IDEA. 2016/1/8 19:43
 * </p>
 * <p>
 * ClassName:SelectionSort
 * </p>
 * <p>
 * Description:选择排序
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class SelectionSort {
    public void selectionSort(int[] nums) {
        int min;
        for (int i = 0; i < nums.length; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public void swap(int[] nums, int one, int two) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{9, 3, 4, 22, 33, 1, 9, 11, 10};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
