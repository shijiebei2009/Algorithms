package cn.codepub.algorithms.commons;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/12/12 15:35
 * </p>
 * <p>
 * ClassName:ConversionOfNumberSystems
 * </p>
 * <p>
 * Description:任意进制位转换系统
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class ConversionOfNumberSystems {
    /**
     * 第一种方法
     *
     * @param number 需要进行进制转换的数字
     * @param base   需要转为几进制
     * @return
     */
    public static String conversion(int number, int base) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int i = number % base;
            switch (i) {
                case 11:
                    sb.append("A");
                    break;
                case 12:
                    sb.append("B");
                    break;
                case 13:
                    sb.append("C");
                    break;
                case 14:
                    sb.append("D");
                    break;
                case 15:
                    sb.append("E");
                    break;
                default:
                    sb.append(i);
            }
            number /= base;

        }
        return sb.reverse().toString();
    }

    /**
     * 第二种方法
     *
     * @param num  需要转换进制的数字
     * @param base 需要转成几进制
     * @return 转换结果
     */
    public static String baseString(int num, int base) {
        String str, digit = "0123456789abcdef";
        if (num == 0) {
            return "";
        } else {
            str = baseString(num / base, base);
            return str + digit.charAt(num % base);
        }
    }

    @Test
    public void test() {
        System.out.println(conversion(1024, 16));
        System.out.println(baseString(1024, 16));
        Assert.assertEquals(conversion(1024, 16), baseString(1024, 16));
    }
}
