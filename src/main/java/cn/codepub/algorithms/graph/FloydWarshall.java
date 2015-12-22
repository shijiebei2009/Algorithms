package cn.codepub.algorithms.graph;

import java.util.Arrays;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/12/14 15:45
 * </p>
 * <p>
 * ClassName:FloydWarshall
 * </p>
 * <p>
 * Description:使用弗洛伊德算法求所有点对最短路径，而弗洛伊德的核心就是用动态规划
 * 动态规划有两个令人激动的特性：它专注解决较小的，有条件限制的问题。当限制条件很严格时，函数将会非常简单，系统地松弛限制条件，直到最后产生希望得到的结果
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class FloydWarshall {
    //顶点数组
    public Vertex[] vertexes;
    private static char[][] pred;//路径矩阵

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
        Vertex v0 = new Vertex('0');
        Vertex v1 = new Vertex('1');
        Vertex v2 = new Vertex('2');
        Vertex v3 = new Vertex('3');
        Vertex v4 = new Vertex('4');
        Edge edge2 = new Edge(2);
        edge2.endVertex = v1;
        Edge edge4 = new Edge(4);
        edge4.endVertex = v4;
        edge2.next = edge4;
        v0.firstEdge = edge2;

        Edge edge3 = new Edge(3);
        edge3.endVertex = v2;
        v1.firstEdge = edge3;

        Edge edge1 = new Edge(1);
        Edge edge5 = new Edge(5);
        edge1.endVertex = v4;
        edge5.endVertex = v3;
        edge1.next = edge5;
        v2.firstEdge = edge1;


        Edge edge7 = new Edge(7);
        edge7.endVertex = v3;
        v4.firstEdge = edge7;

        Edge edge8 = new Edge(8);
        edge8.endVertex = v0;
        v3.firstEdge = edge8;

        vertexes = new Vertex[]{v0, v1, v2, v3, v4};
        getShortestPathByDp(vertexes);

    }

    public static void getShortestPathByDp(Vertex[] vertexes) {
        int size = vertexes.length;
        int[][] dist = new int[size][size];
        pred = new char[size][size];
        for (int i = 0; i < size; i++) {
            int j = 0;
            for (; j < size; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                pred[i][j] = '-';
            }
            dist[i][i] = 0;
            Edge firstEdge = vertexes[i].firstEdge;
            while (firstEdge != null) {
                int no = getNo(vertexes, firstEdge.endVertex.name);
                dist[i][no] = firstEdge.value;
                pred[i][no] = vertexes[i].name;
                firstEdge = firstEdge.next;
            }
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    int newLen = dist[j][i] + dist[i][k];
                    if (newLen < 0) {
                        newLen = Integer.MAX_VALUE;//说明溢出了，那么重新置为最大整数值
                    }
                    if (newLen < dist[j][k]) {
                        dist[j][k] = newLen;
                        pred[j][k] = pred[i][k];
                    }
                }
            }
        }
        //dist[i][j]即表示在有向图中，从vi到vj的最短路径
        for (int[] d : dist) {
            System.out.println(Arrays.toString(d));
        }
        System.out.println("-------------------------");
        for (char[] d : pred) {
            System.out.println(Arrays.toString(d));
        }

        String s = constructShortestPath(4, 2);
        System.out.println("4->2的最短路径是；" + s);
    }

    private static int getNo(Vertex[] vertexes, char name) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i].name == name) {
                return i;
            }
        }
        return -1;
    }

    //从已知的pred矩阵中构造出最短路径

    /**
     * @param start 起始点
     * @param end   结束点
     * @return 起始点->结束的之间的最短路径
     */
    public static String constructShortestPath(int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(end + "-");
        int temp = end;
        while (temp != start) {
            char c = pred[start][temp];
            if (c == '-') {
                return start + "和" + end + "之间不存在最短路径！";
            }
            temp = Integer.valueOf(String.valueOf(c));
            sb.append(temp + "-");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}
