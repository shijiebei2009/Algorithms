package cn.codepub.algorithms.commons;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * <p>
 * Created with IntelliJ IDEA.
 * </p>
 * <p>
 * ClassName:LevenshteinDistance
 * </p>
 * <p>
 * Description:编辑距离算法
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 */
public class LevenshteinDistance {
    public static int leDistance(String inputX, String inputY) {
        int xLen = StringUtils.length(inputX) + 1;
        int yLen = StringUtils.length(inputY) + 1;
        int[][] dp = new int[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < yLen; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < xLen; i++) {
            for (int j = 1; j < yLen; j++) {
                if (inputX.charAt(i - 1) == inputY.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }

            }
        }
        return dp[xLen - 1][yLen - 1];
    }

    @Test
    public void test() {
        int leDistance = LevenshteinDistance.leDistance("", "aa");
        System.out.println(leDistance);
    }
}
