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
 * 第一步，排列的精髓是交换和顺序处理，比如，考虑[1,2,3,4]排列，实际上是，1和1，2，3，4分别交换得来
 * 1和1交换：[1]，[2，3，4]
 * 1和2交换：[2]，[1，3，4]
 * 1和3交换：[3]，[2，1，4]
 * 1和4交换：[4]，[2，3，1]
 * <p>
 * 那么下面分别考虑上面的四个结果，比如，考虑
 * [1]，[2，3，4]
 * <p>
 * 第二步，我们把[1]固定不变，考虑[2，3，4]，把它看成是2和2，3，4分别交换，得到如下结果：
 * [1]固定，2和2交换：[1]，[2]，[3，4]
 * [1]固定，2和3交换：[1]，[3]，[2，4]
 * [1]固定，2和4交换：[1]，[4]，[3，2]
 * <p>
 * 这个时候，再分别考虑第二步之后的三个结果，比如，考虑
 * [1]，[2]，[3，4]
 * <p>
 * 第三步，我们把[1]，[2]固定不变，考虑[3，4]，把它看成是3和3，4分别交换，得到如下结果：
 * [1][2]固定，3和3交换：[1]，[2]，[3]，[4]
 * [1][2]固定，3和4交换：[1]，[2]，[4]，[3]
 * <p>
 * 从上面分析可以看出，其实第二步就是对第一步的部分递归，同样，第三步也是对第二步的部分递归，当最右边只有一个数字的时候，我们就进行输出
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
