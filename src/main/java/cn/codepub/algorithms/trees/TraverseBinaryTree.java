package cn.codepub.algorithms.trees;

import cn.codepub.algorithms.commons.Tree;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 14:16
 * </p>
 * <p>
 * ClassName:TraverseTree
 * </p>
 * <p>
 * Description:提供对二叉树的三种遍历方式：先序遍历，中序遍历，后序遍历
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class TraverseBinaryTree {
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
        r2.right = r3;
        System.out.println("先序遍历");
        preOrder(root);
        System.out.println("\n中序遍历");
        inOrder(root);
        System.out.println("\n后序遍历");
        postOrder(root);
    }

    public static void preOrder(Tree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + "\t");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public static void inOrder(Tree root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.value + "\t");
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public static void postOrder(Tree root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.value + "\t");
    }

}
