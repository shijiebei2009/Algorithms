package cn.codepub.algorithms.strings;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 21:43
 * </p>
 * <p>
 * ClassName:Combination
 * </p>
 * <p>
 * Description:组合：一般地，从m个不同的元素中，任取n（n≤m）个元素为一组，叫作从m个不同元素中取出n个元素的一个组合
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

        System.out.println("测试第二种方法");
        combination();
    }

    /**
     * 第一种方法
     *
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

    /**
     * 第二种方法
     * 基本思路：求全组合，则假设原有元素n个，则最终组合结果是2^n个。原因是： 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011<br/>
     * 所以一共三位，每个位上有两个选择0,1。所以是2^n个结果。这些结果的位图值都是0,1,2....2^n。所以可以类似全真表一样，从值0到值2^n依次输出结果：即：000,001,010,011,100,101,110,111<br/>
     * 对应输出组合结果为：空,a,b,ab,c,ac,bc,abc. 这个输出顺序刚好跟数字0~2^n结果递增顺序一样 取法的二进制数其实就是从0到2^n-1的十进制数
     */
    public static void combination() {
        String[] str = {"a", "b", "c"};
        int n = str.length; // 元素个数。
        // 求出位图全组合的结果个数：2^n
        int nbit = 1 << n; // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。:即求出2^n=2Bit。
//        System.out.println("全组合结果个数为：" + nbit + ",二进制：" + Integer.toBinaryString(nbit));
        for (int i = 0; i < nbit; i++) { // 结果有nbit个。输出结果从数字小到大输出：即输出0,1,2,3,....2^n。
//            System.out.print("组合数值  " + i + " 对应编码为： ");
            for (int j = 0; j < n; j++) { // 每个数二进制最多可以左移n次，即遍历完所有可能的变化新二进制数值了
                int tmp = 1 << j;
//                System.out.println("->" + Integer.toBinaryString(tmp));
                if ((tmp & i) != 0) { // & 表示与。两个位都为1时，结果才为1
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}
