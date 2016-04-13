package cn.codepub.algorithms.graph;

import cn.codepub.algorithms.graph.utils.UnionFindSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>
 * Created with IntelliJ IDEA. 15/12/16 15:39
 * </p>
 * <p>
 * ClassName:Kruskal
 * </p>
 * <p>
 * Description:使用克鲁斯卡尔算法求最小生成树，该算法的核心是一个不相交集，也就是说若加入当前边不形成回路的话即合法，否则不合法
 * 而实现不相交集最常用的方法就是使用并查集，借助于实现的并查集来实现克鲁斯卡尔算法
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Kruskal {
    private static List<Vertex> vertexList = new ArrayList<>();//顶点集
    /**
     * 实现一个匿名类，提供了基于边的权值的比较器
     */
    public static final Queue<Edge> QUEUE = new PriorityQueue<>((e1, e2) -> {
        if (e1.value == e2.value) {
            return 0;
        } else {
            return e1.value > e2.value ? 1 : -1;
        }
    });

    private static List<Edge> visitedEdges = new ArrayList<>();//已访问的边集
    private static List<Edge> edgeList = new ArrayList<>();//边集

    private static class Vertex {
        char name;//顶点名称

        public Vertex(char name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.valueOf(name);
        }
    }

    private static class Edge {
        Vertex start;//边的起始点
        Vertex end;//边的终结点
        int value;//边的权值

        public Edge(Vertex a, Vertex b, int val) {
            this.start = a;
            this.end = b;
            this.value = val;
        }

        @Override
        public String toString() {
            return "顶点是：" + this.start.name + "-->" + this.end.name + "，权值：" + this.value;
        }
    }

    /**
     * 添加边的函数
     *
     * @param a   起始点
     * @param b   终结点
     * @param val 边的权值
     */
    public static void addEdge(Vertex a, Vertex b, int val) {
        Edge edge = new Edge(a, b, val);
        edgeList.add(edge);
    }

    public static void minimumSpanningTree() {
        UnionFindSet unionFindSet = new UnionFindSet(vertexList.size());
        // 加入优先级队列
        QUEUE.addAll(edgeList);
        // queue.addAll(edgeList.stream().collect(Collectors.toList()));
        while (!QUEUE.isEmpty()) {
            Edge remove = QUEUE.remove();
            Vertex start = remove.start;//获取起始点
            Vertex end = remove.end;//获取终结点
            int startNo = getVertexNo(vertexList, start.name);//得到起点编号
            int endNo = getVertexNo(vertexList, end.name);//得到终点编号
            int father1 = unionFindSet.findSet(startNo);
            int father2 = unionFindSet.findSet(endNo);
            if (father1 != father2) {//说明两棵树不在同一棵子树
                unionFindSet.union(startNo, endNo);//合并之
                visitedEdges.add(remove);//将当前访问的边加入已访问列表
            }
        }
    }

    private static int getVertexNo(List<Vertex> vertexList, char name) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).name == name) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void create() {
        //构造图
        Vertex v0 = new Vertex('0');
        Vertex v1 = new Vertex('1');
        Vertex v2 = new Vertex('2');
        Vertex v3 = new Vertex('3');
        Vertex v4 = new Vertex('4');
        vertexList.add(v0);
        vertexList.add(v1);
        vertexList.add(v2);
        vertexList.add(v3);
        vertexList.add(v4);
        addEdge(v0, v1, 2);
        addEdge(v1, v2, 3);
        addEdge(v2, v4, 1);
        addEdge(v0, v4, 4);
        addEdge(v0, v3, 8);
        addEdge(v2, v3, 5);
        addEdge(v4, v3, 7);
        minimumSpanningTree();
        System.out.println("使用克鲁斯卡尔算法选取的边是：");
        System.out.println(visitedEdges);
    }
}
