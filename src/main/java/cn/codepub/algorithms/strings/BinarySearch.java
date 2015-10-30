package cn.codepub.algorithms.strings;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/15 17:15
 * </p>
 * <p>
 * ClassName:BinarySearch
 * </p>
 * <p>
 * Description:二分查找
 * 注意点：数组在传递进来之前一定是排好序的数组，采用递归实现的方法一定要提供出口
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class BinarySearch {

    /**
     * 递归方式实现二分查找
     *
     * @param nums  查找的数组
     * @param start 开始下标
     * @param end   结束下标
     * @param key   查找元素
     * @return 查找元素的下标，当未查到的时候，返回-1
     */
    private static int recursionBinarySearch(int[] nums, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (nums[mid] == key) {
            return mid;
        } else if (nums[mid] > key) {
            //说明key在当前分组的左半边
            return recursionBinarySearch(nums, start, mid - 1, key);
        } else {
            //在右半边
            return recursionBinarySearch(nums, mid + 1, end, key);
        }


    }

    /**
     * 非递归方式实现二分查找
     *
     * @param nums 查找的数组
     * @param key  查找元素
     * @return 查找元素的下标，当未查到返回-1
     */
    private static int nonRecursionBinarySearch(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        int i = recursionBinarySearch(nums, 0, nums.length - 1, 11);
        System.out.println(i);
        int i1 = nonRecursionBinarySearch(nums, 1);
        System.out.println(i1);
    }

}