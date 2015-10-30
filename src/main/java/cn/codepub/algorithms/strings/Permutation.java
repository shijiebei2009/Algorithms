package cn.codepub.algorithms.strings;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 19:37
 * </p>
 * <p>
 * ClassName:Permutation
 * </p>
 * <p>
 * Description:全排列
 * 解题思路：每次交换两个字符，然后递归处理剩下的字符，比如'a','b','c'
 * 第一步可以看作是'a'与'a'交换->'a','b','c'，然后递归处理'b','c'
 * 第二步可以看作是'a'与'b'交换->'b','a','c'，然后递归处理'a','c'
 * 第三步可以看作是'a'与'c'交换->'c','b','a'，然后递归处理'b','a'
 * <p>
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Permutation {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        char[] strs = new char[]{'a', 'b', 'c'};
        permutation(strs, 0, strs.length);
    }

    public static void permutation(char[] strs, int start, int end) {
        if (start >= end) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = start; i < end; i++) {
            swap(strs, start, i);
            sb.append(strs[start]);
            permutation(strs, start + 1, end);
            swap(strs, start, i);
            sb.deleteCharAt(start);
        }
    }

    private static void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }
}
