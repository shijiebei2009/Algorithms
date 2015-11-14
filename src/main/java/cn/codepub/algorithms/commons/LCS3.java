package cn.codepub.algorithms.commons;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * <p>
 * Created with IntelliJ IDEA.
 * </p>
 * <p>
 * ClassName:LCS3
 * </p>
 * <p/>
 * Description:使用动态规划解决最长公共子串
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 */
public class LCS3 {
    public static String lcsDp(String inputX, String inputY) {
        int xLen = 0;
        int yLen = 0;
        int maxLen = 0, maxIndex = 0;

        if (StringUtils.isEmpty(inputX)) {
            xLen = 0;
        } else {
            xLen = inputX.length();
        }
        if (StringUtils.isEmpty(inputY)) {
            yLen = 0;
        } else {
            yLen = inputY.length();
        }

        int dp[][] = new int[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (inputX.charAt(i) == inputY.charAt(j)) {
                    if (i != 0 && j != 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (0 == i || 0 == j) {
                        dp[i][j] = 1;
                    }
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        maxIndex = i + 1 - maxLen;
                    }
                }

            }

        }
        return inputX.substring(maxIndex, maxIndex + maxLen);
    }
    @Test
    public void test() {
        String s1 = "我是美abc国中defg国中间人";
        String s2 = "我是abdde我是美中国中国中国人";
        String s = lcsDp(s1, s2);
        System.out.println(s);
    }
}
