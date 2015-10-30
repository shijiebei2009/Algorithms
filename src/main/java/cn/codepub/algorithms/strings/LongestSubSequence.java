package cn.codepub.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 求解思路（以递减子序列为例）：
 * 1.用dp[i]代表以当前第i个字符为结尾时，所持有的最长递减子序列的长度
 * 2.初始化所有的dp[i]值为1，之后再一步步更新之
 * 3.如果nums[i-1]比nums[i]大，那么dp[i]=dp[i-1]+1
 * 4.否则的话，要取0<=j<=i之间最大那个dp[j]，且该dp[j]满足nums[j]>nums[i]，这种情况说明中间跳过了几个元素
 * 5.对于满足条件的dp[j]将dp[j]+1赋值给dp[i]
 */
public class LongestSubSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 19, 12, 5, 4, 2, 3, 7, 9, 10, 6, 8, 3, 4, 3, 2, 1};
        LongestSubSequence longestSubSequence = new LongestSubSequence();
        List<Integer> longestDecreaseSubSequence = longestSubSequence.getLongestDecreaseSubSequence(nums);
        System.out.println(longestDecreaseSubSequence);
        List<Integer> longestIncreaseSubSequence = longestSubSequence.getLongestIncreaseSubSequence(nums);
        System.out.println(longestIncreaseSubSequence);

    }

    /**
     * @param nums 数组
     * @return 最长递减子序列链表
     */
    public List<Integer> getLongestDecreaseSubSequence(int[] nums) {
        int[] dp = new int[nums.length];
        int[] priors = new int[nums.length];//用于记录当前以该元素为最小元素的递减序列中该元素的前驱节点，用于打印序列
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        List<Integer> result = new ArrayList<>();//存储递减子序列
        int max = 0;//存储子序列的长度
        int endIndex = 0;//存储子序列的最后一个元素的下标
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {//说明连续
                dp[i] = dp[i - 1] + 1;
                priors[i] = i - 1;
            } else {//不连续的话要从第一个开始比较，取最长的一个
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i] && (dp[j] + 1) > dp[i]) {
                        dp[i] = dp[j] + 1;
                        priors[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                endIndex = i;
            }
        }

        //将子序列取出加入链表，作为结果返回
        while (max > 0) {
            result.add(0, nums[endIndex]);
            endIndex = priors[endIndex];//priors数组中依次存储的是以当前元素作为子序列的前一个节点的下标
            max--;
        }
        return result;
    }

    /**
     * @param nums 数组
     * @return 最长递增子序列链表
     */
    public List<Integer> getLongestIncreaseSubSequence(int[] nums) {
        int[] dp = new int[nums.length];
        int[] priors = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        List<Integer> result = new ArrayList<>();//存储递减子序列
        int max = 0;
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {//说明连续
                dp[i] = dp[i - 1] + 1;
                priors[i] = i - 1;
            } else {//不连续的话要从第一个开始比较，取最长的一个
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && (dp[j] + 1) > dp[i]) {
                        dp[i] = dp[j] + 1;
                        priors[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                endIndex = i;
            }
        }
        //将子序列取出加入链表，作为结果返回
        while (max > 0) {
            result.add(0, nums[endIndex]);
            endIndex = priors[endIndex];//priors数组中依次存储的是以当前元素作为子序列的前一个节点的下标
            max--;
        }
        return result;

    }


}
