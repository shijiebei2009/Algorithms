package cn.codepub.algorithms.strings;


import java.util.Arrays;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/12/1 14:18
 * </p>
 * <p>
 * ClassName:StringSort
 * </p>
 * <p>
 * Description:实现一个简单的字符串按照字典序排序，不区分大小写
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class StringSort {

    public static void main(String[] args) {
        String[] strs = new String[]{"alphabet", "alligator", "alternate", "alternative"};
        bubbleSort(strs);
        System.out.println(Arrays.toString(strs));
    }

    /**
     * 实现排序函数的主体
     *
     * @param strs 需要排序的字符串数组
     */
    public static void bubbleSort(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            for (int j = strs.length - 1; j > i; j--) {
                int compare = compare(strs[i], strs[j]);
                if (compare > 0) {
                    //说明前面一个大
                    String temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }
            }
        }
    }

    /**
     * 辅助排序函数
     *
     * @param s1
     * @param s2
     * @return 1 前者大；-1 后者大；0 两者相等
     */
    private static int compare(String s1, String s2) {
        s1 = s1.toLowerCase();//全转小写
        s2 = s2.toLowerCase();
        int len1 = s1.length();
        int len2 = s2.length();
        int count = len1 < len2 ? len1 : len2;
        for (int i = 0; i < count; i++) {
            int first = (int) s1.charAt(i);//将字母强转为ASCII码
            int second = (int) s2.charAt(i);
            if (first < second) {
                return -1;//前一个小
            } else if (first > second) {
                return 1;//后一个小
            } else {
                continue;
            }
        }
        //如果全部比较完了，则谁短谁小
        if (len1 < len2) {
            return -1;
        } else if (len1 > len2) {
            return 1;
        } else {
            return 0;
        }
    }
}
