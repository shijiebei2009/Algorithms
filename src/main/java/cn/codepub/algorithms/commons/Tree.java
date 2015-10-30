package cn.codepub.algorithms.commons;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/30 14:50
 * </p>
 * <p>
 * ClassName:Tree
 * </p>
 * <p>
 * Description:公用的树定义
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Tree {
    public Tree left;//左子树
    public Tree right;//右子树
    public int value;//结点值
    public boolean isVisited;//是否访问

    public Tree() {

    }

    public Tree(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
