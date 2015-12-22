package cn.codepub.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/12/14 10:06
 * </p>
 * <p>
 * ClassName:Dijkstra
 * </p>
 * <p>
 * Description:使用迪杰斯特拉算法解决单源最短路径
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Dijkstra {

    //顶点数组
    public Vertex[] vertexes;

    //顶点类
    class Vertex {
        char name;//顶点名称
        Edge firstEdge;//顶点所连的第一条边

        public Vertex(char name) {
            this.name = name;
        }
    }

    //边类
    class Edge {
        Vertex endVertex;//边所连的末尾节点
        int value;//边的权值，注意使用迪杰斯特拉不允许权值为负值
        Edge next = null;//该边的起点所连的另一头边，采用邻接表结构存储

        public Edge(int value) {
            this.value = value;
        }
    }

    @org.junit.Test
    public void create() {
        //构造图
        Edge edge2 = new Edge(2);
        Edge edge3 = new Edge(3);
        Edge edge1 = new Edge(1);
        Edge edge4 = new Edge(4);
        Edge edge8 = new Edge(8);
        Edge edge7 = new Edge(7);
        Edge edge5 = new Edge(5);


        Vertex v0 = new Vertex('0');
        Vertex v1 = new Vertex('1');
        Vertex v2 = new Vertex('2');
        Vertex v3 = new Vertex('3');
        Vertex v4 = new Vertex('4');

        edge2.next = edge4;
        edge2.endVertex = v1;
        edge4.endVertex = v4;
        v0.firstEdge = edge2;

        edge3.endVertex = v2;
        v1.firstEdge = edge3;

        edge1.next = edge5;
        edge1.endVertex = v4;
        edge5.endVertex = v3;
        v2.firstEdge = edge1;

        edge7.endVertex = v3;
        v4.firstEdge = edge7;

        edge8.endVertex = v0;
        v3.firstEdge = edge8;
        vertexes = new Vertex[]{v0, v1, v2, v3, v4};
        //寻找最短路径数组
        Dijkstra.getShortestPath(vertexes);

    }

    /**
     * 求得单源最短路径
     *
     * @param vertexes
     */
    public static void getShortestPath(Vertex[] vertexes) {
        int[] dist = new int[vertexes.length];
        char[] pred = new char[vertexes.length];

        Queue<Vertex> queue = new ArrayDeque<>();
        for (int i = 0; i < vertexes.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            pred[i] = '-';
        }
        dist[0] = 0;//表示源到源自身为0
        pred[0] = '0';

        //通常情况下，是按照优先级高低插入队列，而优先级高低的衡量标准是离源点距离的远近，但是此并不为必要条件，所以你可以以其它顺序插入队列
        //以v0,v1,v2,v3,v4的顺序插入队列
        //for (int i = 0; i < vertexes.length; i++) {
        //  queue.add(vertexes[i]);
        //}

        //以v0,v1,v4,v2,v3的顺序插入队列
        queue.add(vertexes[0]);
        queue.add(vertexes[1]);
        queue.add(vertexes[4]);
        queue.add(vertexes[2]);
        queue.add(vertexes[3]);
        System.out.println(Arrays.toString(dist));
        for (Vertex v : queue) {
            System.out.print("顶点数组为：" + v.name + "\t");
        }
        System.out.println();
        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
//            Graph.Vertex vertex = queue.peek();
            int u = getNo(vertexes, vertex.name);
            if (-1 == u) {
                System.err.println("该顶点不存在：" + vertex.name);
                break;
            }
            Edge firstEdge = vertex.firstEdge;
            while (firstEdge != null) {
                int w = firstEdge.value;//获取边的权值
                int v = getNo(vertexes, firstEdge.endVertex.name);
                if (-1 == v) {
                    System.err.println("该顶点不存在：" + firstEdge.endVertex.name);
                }
                int newW = dist[u] + w;
                if (newW < 0) {
                    newW = Integer.MAX_VALUE;//如果溢出，需要重新置为最大整数值，原因是：最大整数值加任意大于0的值就会溢出，变为最小正整数值
                }

                if (newW < dist[v]) {
                    System.out.print("(" + "0" + "," + vertex.name + ")" + "+" + "(" + vertex.name + "," + firstEdge.endVertex.name + ")" + "<" + "" +
                            "(0," +
                            firstEdge
                                    .endVertex
                                    .name + ")");
                    System.out.println("\t更新距离数组\t" + "(0," + firstEdge.endVertex.name + ")=" + newW);
                    dist[v] = newW;
                    pred[v] = vertex.name;
                } else {
                    System.out.println("(" + "0" + "," + vertex.name + ")" + "+" + "(" + vertex.name + "," + firstEdge.endVertex.name + ")" + ">" +
                            "" +
                            "(0," +
                            firstEdge
                                    .endVertex
                                    .name + ")");

                }
                firstEdge = firstEdge.next;
            }

        }
        System.out.println("距离数组为：" + Arrays.toString(dist));
        //注意，最终的最短路径可以经过pred数组推导出来，很简单
        System.out.println("路径数组为：" + Arrays.toString(pred));
    }

    /**
     * 根据节点的名称返回节点在数组中的序号
     *
     * @param vertexes
     * @param name
     * @return
     */
    private static int getNo(Vertex[] vertexes, char name) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i].name == name) {
                return i;
            }
        }
        return -1;
    }
}
