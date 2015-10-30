package cn.codepub.algorithms;

import java.util.Stack;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/29 21:43
 * </p>
 * <p>
 * ClassName:CheckStackSequence
 * </p>
 * <p>
 * Description:
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 例如序列1,2,3,4,5是某栈的压栈序列，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但是4,3,5,1,2就不可能是其弹出序列
 * <p>
 * 解题思路：既然是判断栈的弹栈序列是否合法，那么就用一个栈来模拟弹出序列即可，最后栈空说明全部弹出，合法，否则栈非空说明不合法
 * ① 如果下一个弹出元素和刚好要入栈元素一致，两者都向后走
 * ② 如果下一个弹出元素和栈顶元素一致，那么先弹栈再入栈
 * ③ 如果下一个弹出元素和要入栈元素不一致，且和栈顶元素也不一致，那么将要入栈元素压栈
 * ④ 最后如果按照弹栈序列能将栈弹空，那么说明序列合法，否则不合法
 * <p>
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class CheckStackSequence {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{4, 5, 3, 2, 1};
        boolean check = check(nums1, nums2);
        System.out.println(check);

        int[] nums3 = new int[]{1, 4, 5, 2, 3};
        boolean check1 = check(nums1, nums3);
        System.out.println(check1);

        int[] nums4 = new int[]{4, 3, 5, 1, 2};
        boolean check2 = check(nums1, nums4);
        System.out.println(check2);

        int[] nums5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums6 = new int[]{3, 8, 7, 9, 6, 5, 4, 2, 1};
        boolean check3 = check(nums5, nums6);
        System.out.println(check3);

    }

    /**
     * @param nums1 入栈序列
     * @param nums2 出栈序列
     * @return 出栈序列是否合法
     */
    public static boolean check(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        int current = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums2[current] == nums1[i]) {//说明该元素入栈之后即刻出栈，所以将i和current递增即刻
                current++;
            } else {
                //如果在下一个元素入栈之前有元素要弹栈，那么需要先弹栈再入栈
                if (!stack.isEmpty() && nums2[current] == stack.peek()) {
                    current++;
                    stack.pop();
                    stack.push(nums1[i]);//别忘记将新的元素入栈
                } else {
                    //直接入栈
                    stack.push(nums1[i]);
                }
            }
        }
        //剩下的栈内元素都是依次出栈即可
        while (current < nums2.length && nums2[current] == stack.peek() && !stack.isEmpty()) {
            current++;
            stack.pop();
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
