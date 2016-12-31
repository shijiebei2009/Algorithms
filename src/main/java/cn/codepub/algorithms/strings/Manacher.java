package cn.codepub.algorithms.strings;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * <p>
 * Created by wangxu on 2016/12/23 10:46.
 * </p>
 * <p>
 * Description: 最长回文子串Manacher算法
 * ① 在每个字符之间插入一个特殊字符（如ab插入后#a#b#），将所有的奇数和偶数字符串统一成奇数字符串处理
 * ② 用一个辅助数组P，P[id]记录的是以字符str[id]为中心的最长回文串半径
 * ③ 那么得到直径为P[id]*2-1（因为原点只有一个），这里面特殊字符始终比真实的字符串多一个，所以再减去一个特出字符P[id]*2-1-1
 * ④ 剩下的特殊字符和真实字符各占一半(P[id]*2-1-1)/2=P[id]-1，代表真正的以id为中心的最长回文串
 * ⑤ 那么max(P[id])-1就是该字符串的最长回文子串，剩下的就是求P[id]数组了
 * </p>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0 <br></br>
 * WebSite: http://codepub.cn <br></br>
 * Licence: Apache v2 License
 */
public class Manacher {
    public static void main(String[] args) {
        String str = "tattarrattat";
        str = "SatireVeritas";
        Manacher manacher = new Manacher();
        int maxPalindrome = manacher.getMaxPalindrome(str.toLowerCase());
        System.out.println(maxPalindrome);
        str = "abababbaba";
        maxPalindrome= manacher.getMaxPalindrome(str.toLowerCase());
        System.out.println(maxPalindrome);
    }

    private int getMaxPalindrome(String str) {
        int P[];//记录以字符S[i]为中心的最长回文子串向左/向右扩张的半径，包含其自身
        int id = 0;//已知右边界的最长回文子串的中心坐标
        int maxR = 0;//已知的最长回文子串的右边界坐标
        String join = "#" + StringUtils.join(str.toCharArray(), '#') + "#";
        char[] chars = join.toCharArray();
        P = new int[join.length()];
        for (int i = 1; i < P.length; i++) {
            int j = id - (i - id);//j是i相对于id的对称点，那么i<maxR的时候，它们必然在对称范围之内，所以P[i]=P[j]
            if (maxR > i) {
                if (maxR - i > P[j]) {
                    P[i] = P[j];
                } else {
                    P[i] = maxR - i;//这时最多只能确保i能延展到maxR，对于超过maxR的部分不能确保是否回文，所以其延展半径为(maxR-i)
                }
            } else {
                //仅包含其自身
                P[i] = 1;
            }
            //尝试扩展
            while ((i - P[i] >= 0) && (i + P[i] < P.length) && chars[i + P[i]] == chars[i - P[i]]) {
                //如果又发现一对回文，延展半径加1
                P[i]++;
            }
            //更新maxR和id
            if (i + P[i] > maxR) {
                //超过了子串的最右边界
                maxR = i + P[i];
                id = i;
            }
        }
        Arrays.sort(P);//升序排列
        return P[P.length - 1] - 1;
    }
}
