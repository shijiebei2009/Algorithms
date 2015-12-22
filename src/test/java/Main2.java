import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/12/15 15:11
 * </p>
 * <p>
 * ClassName:Main2
 * </p>
 * <p>
 * Description:TODO
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int[] arrs = new int[num];
            for (int i = 0; i < num; i++) {
                arrs[i] = in.nextInt();
            }
            int[] dp = new int[num];
            dp[0] = arrs[0];
            for (int i = 1; i < num; i++) {
                int temp = 0;
                for (int j = 0; j < i; j++) {
                    int calculate = calculate(arrs, j, i);
                    if (calculate > temp) {
                        temp = calculate;
                    }
                }
                dp[i] = Math.max(dp[i - 1], temp);
            }
            System.out.println(dp[num - 1]);
        }
    }

    private static int calculate(int[] arrs, int start, int end) {
        int small = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (arrs[i] < small) {
                small = arrs[i];
            }
        }
        return small * (end - start + 1);
    }

    int count = 0;

    public void print_permu(int[] nums, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(nums));
            count++;
        }
        for (int i = start; i < end; i++) {
            swap(nums, start, i);
            print_permu(nums, start + 1, end);
            swap(nums, start, i);

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        print_permu(nums, 0, nums.length);
        System.out.println(count);
    }

    @Test
    public void test2() {
        int k = 1;
        while (true) {
            double sum = getSum(k++);

            double b = 1 / sum;
            System.out.println(b);
            if (0 == b) {
                break;
            }

        }
    }

    public static double getSum(int n) {
        if (n <= 0) {
            return 1;
        }
        return n * getSum(n - 1);
    }

    @Test
    public void test3() {
        print_subset(3,5);
    }

    void print_subset(int n, int s) {
        for (int i = 0; i < n; i++) {
            if ((s & (1 << i)) != 0) {
                System.out.println(i);
            }
        }
    }
}
