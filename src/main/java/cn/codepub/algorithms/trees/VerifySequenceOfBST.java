package cn.codepub.algorithms.trees;

import java.util.Arrays;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 14:56
 * </p>
 * <p>
 * ClassName:VerifySequenceOfBST
 * </p>
 * <p>
 * Description:
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果，如果是则返回true，否则返回false
 * 假设输入的数组的任意两个数字都互不相同
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class VerifySequenceOfBST {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 6, 9, 11, 10, 8};
        boolean verify = verify(nums);
        System.out.println(verify);
        nums = new int[]{7, 4, 6, 5};
        verify = verify(nums);
        System.out.println(verify);
    }

    public static boolean verify(int[] sequences) {
        if (null == sequences || sequences.length <= 1) {
            return true;
        }
        int root = sequences[sequences.length - 1];
        int index = 0;
        //寻找左右子树的分割点
        while (index < sequences.length && sequences[index] < root) {
            index++;
        }
        //校验右子树应该是全大于root值
        for (int i = index; i < sequences.length; i++) {
            if (sequences[i] < root) {
                return false;
            }
        }
        boolean left = true;
        //如果index==0，说明根节点之前所有元素都属于右子树，无需判断左子树
        if (index > 0) {
            left = verify(Arrays.copyOf(sequences, index));
        }
        boolean right = true;
        //如果index>=length-1，根节点之前所有元素都属于左子树，无需判断右子树
        if (index < sequences.length - 1) {
            right = verify(Arrays.copyOfRange(sequences, index, sequences.length - 1));
        }
        return left && right;
    }
}
