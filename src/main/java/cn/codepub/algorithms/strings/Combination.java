package cn.codepub.algorithms.strings;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 21:43
 * </p>
 * <p>
 * ClassName:Combination
 * </p>
 * <p>
 * Description:组合
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Combination {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        char[] strs = new char[]{'a', 'b', 'c', 'd', 'e'};
        for (int i = 1; i <= strs.length; i++) {
            combination(strs, 0, i);
        }
    }

    /**
     * @param strs   需要操作的字符数组
     * @param start  从哪里开始取
     * @param number 取几个字符
     */
    public static void combination(char[] strs, int start, int number) {
        //定义函数出口先
        if (number <= 0 || start >= strs.length) {
            System.out.println(sb.toString());
            return;
        }
        //选取当前字符的话，需要将number-1
        sb.append(strs[start]);
        combination(strs, start + 1, number - 1);
        //不选取当前字符的话，number不变
        sb.deleteCharAt(sb.length() - 1);
        //注意因为还需要从start+1的位置开始取number个字符，那么如果剩下的字符不足number就没必要去取了
        if (strs.length - start > number) {
            combination(strs, start + 1, number);
        }

    }
}
