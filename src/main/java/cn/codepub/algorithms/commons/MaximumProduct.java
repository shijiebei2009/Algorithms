package cn.codepub.algorithms.commons;

import org.junit.Test;

/**
 * <p>
 * Created with IntelliJ IDEA. 15/12/17 16:53
 * </p>
 * <p>
 * ClassName:MaximumProduct（最大乘积）
 * </p>
 * <p>
 * Description:输入n个元素组成的序列S，你需要找出一个乘积最大的连续子序列。如果这个最大的乘积不是正数，应输出0表示无解。
 * 1<=n<=18：表示不超过18个元素
 * -10<=Si<=10：表示每个元素的绝对值不大于10
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class MaximumProduct {

    /**
     * 连续子序列必有开始和结束，所以采用暴力破解法，枚举开始元素和结束元素
     *
     * @param arrs
     * @return 最大乘积结果
     */
    public static long getMaximumProduct(long[] arrs) {
        long max = 0;
        //以i作为开始，以j作为结束
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                long temp = 1;
                for (int k = i; k <= j; k++) {
                    temp *= arrs[k];
                }
                if (temp > max) {
                    max = temp;
                }

            }
        }
        return max;
    }

    @Test
    public void test() {
        long[] arr = new long[]{2, 4, -3};
        long maximumProduct = getMaximumProduct(arr);
        System.out.println(maximumProduct);
        arr = new long[]{2, 5, -1, 2, -1};
        maximumProduct = getMaximumProduct(arr);
        System.out.println(maximumProduct);
    }


}
