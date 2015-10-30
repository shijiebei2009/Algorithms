package cn.codepub.algorithms.trees;

import cn.codepub.algorithms.commons.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 13:38
 * </p>
 * <p>
 * ClassName:LevelTraverseBinaryTree
 * </p>
 * <p>
 * Description:二叉树的层次遍历
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class LevelTraverseBinaryTree {
    public static void main(String[] args) {
        Queue queue = new ArrayDeque<>();
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
        r2.right = r3;
        levelTraverse(root, queue);
    }

    public static void levelTraverse(Tree root, Queue<Tree> queue) {
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree remove = queue.remove();
            System.out.print(remove.value + "\t");
            if (remove.left != null) {
                queue.add(remove.left);
            }
            if (remove.right != null) {
                queue.add(remove.right);
            }

        }
    }
}


