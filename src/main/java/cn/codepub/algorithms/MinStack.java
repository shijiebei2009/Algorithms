package cn.codepub.algorithms;

import java.util.Stack;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/29 12:22
 * </p>
 * <p>
 * ClassName:MinStack
 * </p>
 * <p>
 * Description:
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class MinStack {
    public static void main(String[] args) {
        Stack<Integer> numberStack = new Stack<>();//存储元素的栈
        Stack<Integer> minStack = new Stack<>();//到当前元素为止，栈顶始终是最小的一个元素
        int nums[] = new int[]{3, 4, 2, 1, 9};
        for (int i : nums) {
            numberStack.push(i);
            if (!minStack.isEmpty() && i > minStack.peek()) {//与minStack的栈顶元素比较，如果比其大，将栈顶元素再次入栈
                minStack.push(minStack.peek());
            } else {//如果比其小，说明当前最小的元素是i，将i入栈
                minStack.push(i);
            }
        }
        System.out.println(numberStack);
        System.out.println(minStack);
    }
}
