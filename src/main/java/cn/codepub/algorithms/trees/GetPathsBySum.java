package cn.codepub.algorithms.trees;

import cn.codepub.algorithms.commons.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 16:38
 * </p>
 * <p>
 * ClassName:GetPathsBySum
 * </p>
 * <p>
 * Description:
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class GetPathsBySum {
    static Stack<Tree> stack = new Stack();
    static List<List<Tree>> pathsList = new ArrayList<>();

    public static void main(String[] args) {
        Tree root = new Tree(10);//给定的树
        Tree l1 = new Tree(5);
        Tree l2 = new Tree(4);
        Tree r1 = new Tree(12);
        Tree r2 = new Tree(7);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        int num = 22;//给定的整数
        dfs(root, new ArrayList<Tree>());
        //这样就获取到了所有路径的集合
        for (List<Tree> list : pathsList) {
            int temp = 0;
            for (Tree t : list) {
                temp += t.value;
            }
            if (temp == num) {
                System.out.println(list);
            }
        }
    }

    /**
     * 使用变体的深度优先遍历，存储下来每一条路径
     * 在压栈的时候，同时将结点加入链表，在弹栈的时候，先判断是否是叶子结点，是的话，则输出一条路径，然后直接移除此结点
     *
     * @param root
     */
    public static void dfs(Tree root, List<Tree> path) {
        if (null == root) {
            return;
        }
        //设置访问标记
        root.isVisited = true;
        //入栈
        stack.push(root);
        //加入链表
        path.add(root);
        //开始弹栈
        while (!stack.isEmpty()) {
            //在弹栈的同时也要将该结点从路径中移除，但是在移除前要判断是否已经是一条完整的路径，如果是一条完整的路径，则存储之
            Tree pop = stack.pop();
            if (pop.left != null && !pop.left.isVisited) {
                dfs(pop.left, path);
            }
            if (pop.right != null && !pop.right.isVisited) {
                dfs(pop.right, path);
            }
            if (pop.left == null && pop.right == null) {
                //说明到了叶子结点了
                pathsList.add(new ArrayList<>(path));
            }
            path.remove(pop);//从一条路径中移除
        }
    }
}
