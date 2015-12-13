package cn.codepub.algorithms.commons;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * <p>
 * Created with IntelliJ IDEA.
 * </p>
 * <p>
 * ClassName:LCS
 * </p>
 * <p>
 * Description:最长公共子序列
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 */
public class LCS {
    public static String lcsBase(String inputX, String inputY) {
        if (StringUtils.isEmpty(inputX) || StringUtils.isEmpty(inputY) || inputX.length() == 0 || inputY.length() == 0) {
            return "";
        } else {
            char x = inputX.charAt(0);
            char y = inputY.charAt(0);
            if (x == y) {
                return lcsBase(inputX.substring(1), inputY.substring(1)) + x;
            } else {
                return getMax(lcsBase(inputX.substring(1), inputY), lcsBase(inputX, inputY.substring(1)));
            }

        }
    }

    private static String getMax(String x, String y) {
        Integer xLen = 0;
        Integer yLen = 0;
        if (StringUtils.isEmpty(x)) {
            xLen = 0;
        } else {
            xLen = x.length();
        }
        if (StringUtils.isEmpty(y)) {
            yLen = 0;
        } else {
            yLen = y.length();
        }

        if (xLen >= yLen) {
            return x;
        } else {
            return y;
        }
    }

    @Test
    public void test() {
//        蓬安县房屋瓦片被震
        String base1 = "落广西陕西震感强烈";
        String base2 = "汶川地震致重庆4名学生死亡100多人受伤";
        String s = lcsBase(base1, base2);
        System.out.println(StringUtils.reverse(s));

        String s2 = lcsBase("1233433236676", "98723765655423");

        System.out.println(StringUtils.reverse(s2));

        String s1 = lcsBase("123s212346我的大中国啊33z", "33z的大中国");
        System.out.println(StringUtils.reverse(s1));

        Integer a = 10000, b = 1000;
        Integer c = 100, d = 100;
        System.out.println(a == b);
        System.out.println(c == d);
    }


}
