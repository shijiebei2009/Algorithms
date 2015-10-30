package cn.codepub.algorithms.sorting;

import java.util.Arrays;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/21 14:42
 * </p>
 * <p>
 * ClassName:QuickSort
 * </p>
 * <p>
 * Description:快速排序
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 9, 1, 2, 33, 11, 22};
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int nums[], int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end - 1;
        int mid = nums[end];
        while (left < right) {
            while (nums[left] < mid && left < right) {
                left++;
            }

            while (nums[right] > mid && left < right) {
                right--;
            }
            swap(nums, left, right);
        }

        if (nums[left] > mid) {
            swap(nums, left, end);
        } else {
            left++;
        }
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private void swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
