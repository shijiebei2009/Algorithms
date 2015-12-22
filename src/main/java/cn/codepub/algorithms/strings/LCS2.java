package cn.codepub.algorithms.strings;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * <p>
 * Created with IntelliJ IDEA.
 * </p>
 * <p>
 * ClassName:LCS2
 * </p>
 * <p>
 * Description:最长公共子串算法
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 */
public class LCS2 {
    private static Integer getComLen(String firstStr, String secondStr) {
        Integer comLen = 0;
        while (StringUtils.isNotEmpty(firstStr) && StringUtils.isNotEmpty(secondStr)) {
            if (firstStr.charAt(0) == secondStr.charAt(0)) {
                comLen += 1;
                firstStr = firstStr.substring(1);
                secondStr = secondStr.substring(1);
            } else {
                break;
            }
        }
        return comLen;
    }

    private static String lcsBase(String inputX, String inputY) {
        Integer maxComLen = 0;
        Integer commonIndex = 0;

        for (int i = 0; i < inputX.length(); i++) {
            for (int j = 0; j < inputY.length(); j++) {
                Integer comLen = getComLen(inputX.substring(i), inputY.substring(j));
                if (comLen > maxComLen) {
                    maxComLen = comLen;
                    commonIndex = i;
                }
            }
        }
        return inputX.substring(commonIndex, commonIndex + maxComLen);
    }

    @Test
    public void test() {
        String s1 = "abcy交罚款撒了德萨 e";
        String s2 = "abcx交罚款dfdsafdsa范德萨 e";
        String s = lcsBase(s1, s2);
        System.out.println(s);
    }
}

