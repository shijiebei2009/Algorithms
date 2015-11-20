package cn.codepub.algorithms.trees;

import cn.codepub.algorithms.utils.Tree;

import java.util.Stack;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 17:32
 * </p>
 * <p>
 * ClassName:DepthFirstTraversal
 * </p>
 * <p>
 * Description:二叉树的深度优先遍历
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class DepthFirstTraversal {
    static Stack<Tree> stack = new Stack();

    public static void main(String[] args) {
        Tree root = new Tree(1);
        Tree l1 = new Tree(3);
        Tree l2 = new Tree(9);
        Tree l3 = new Tree(11);
        Tree r1 = new Tree(5);
        Tree r2 = new Tree(12);
        Tree r3 = new Tree(13);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l2.left = l3;
        l3.right = r2;
        l3.left = new Tree(14);
        r2.right = r3;

        Tree r4 = new Tree(88);
        r1.right = r4;
        dfs(root);
    }

    public static void dfs(Tree root) {
        if (null == root) {
            return;
        }
        //设置访问标记
        root.isVisited = true;
        //入栈
        stack.push(root);
        //访问结点
        //开始弹栈
        if (!stack.isEmpty()) {
            Tree pop = stack.pop();
            System.out.print(pop.value + "\t");
            if (pop.left != null && !pop.left.isVisited) {
                dfs(pop.left);
            }
            if (pop.right != null && !pop.right.isVisited) {
                dfs(pop.right);
            }
        }
    }
}
