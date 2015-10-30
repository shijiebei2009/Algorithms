package cn.codepub.algorithms.strings;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/22 15:17
 * </p>
 * <p>
 * ClassName:test
 * </p>
 * <p>
 * Description:模式串查找，当模式串出现在文本中的时候，返回匹配的开始索引值，否则未查到返回-1
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class PatternStringMatch {
    public static void main(String[] args) {
        PatternStringMatch patternStringMatch = new PatternStringMatch();
        int search = patternStringMatch.search("abcdefghi", "ih");
        System.out.println(search);
        int search2 = patternStringMatch.search("abddfdjskfjd", "jd");
        System.out.println(search2);
    }

    /**
     * @param text
     * @param pat
     * @return 约定：查到了返回匹配的索引值，否则未查到则返回-1
     */
    private static int search(String text, String pat) {
        int patLen = pat.length();
        int textLen = text.length();
        int step = textLen - patLen;
        if (step < 0) {
            return -1;//模式串比文本串长，肯定不存在匹配情况
        }
        for (int i = 0; i <= step; i++) {
            int j;
            for (j = 0; j < patLen; j++) {
                if (pat.charAt(j) != text.charAt(i + j)) {
                    break;
                }
            }
            if (j == patLen) {//模式串已经走到结尾了，那么i在文本串中正好是匹配到的模式串的开始索引
                return i;
            }
        }
        return -1;
    }
}
