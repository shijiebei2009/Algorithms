package cn.codepub.algorithms.graph.utils;

/**
 * <p>
 * Created with IntelliJ IDEA. 15/12/16 16:34
 * </p>
 * <p>
 * ClassName:UnionFindSet
 * </p>
 * <p>
 * Description:实现一个Java版并查集，应用于克鲁斯卡尔算法
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class UnionFindSet {
    public int[] father;//father[i]=i表示本集合且i是集合对应的树的根，father[i]=j表示j是i的父节点
    public int[] rank;//rank[i]代表集合的秩，比如子孙个数或者树的高度等。用于合并集合，秩小的合并到秩大的
    private int DEFAULT_SIZE = 2 << 9;//设置默认值为1024

    public UnionFindSet() {
        init();
    }

    public UnionFindSet(int size) {
        DEFAULT_SIZE = size;
        init();
    }

    /**
     * 利用默认值做初始化工作
     */
    private void init() {
        father = new int[DEFAULT_SIZE];
        rank = new int[DEFAULT_SIZE];
        makeSet();
    }

    /**
     * 初始化集合
     */
    public void makeSet() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * 查找一个元素所在的集合，其精髓是找到这个元素所在的集合的祖先，如果需要判断两个元素是否属于同一个集合，只要看他们所在集合的祖先是否相同即可
     *
     * @param x
     * @return
     */
    public int findSet(int x) {
        if (x != father[x]) {
            //在递归查找的时候进行了路径压缩，所谓的路径压缩其实非常简单，就是将该树的祖先置为每个节点的父节点
            father[x] = findSet(father[x]);
        }
        return father[x];
    }

    /**
     * 合并树，将秩小的合并到大的
     *
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if (x == y) {
            return;
        }
        if (rank[x] > rank[y]) {
            father[y] = x;
        } else if (rank[x] < rank[y]) {
            father[x] = y;
        } else {//任意合并一个即可
            rank[y]++;
            father[x] = y;
        }
    }
}
