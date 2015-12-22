package cn.codepub.algorithms.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created with IntelliJ IDEA. 15/12/16 10:33
 * </p>
 * <p>
 * ClassName:Prim
 * </p>
 * <p>
 * Description:使用Prim算法实现最小生成树，注意最小生成树所使用的图是无向图，所以其存储结构应区别于有向图
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Prim {
    private static class Vertex {
        char name;//顶点名称

        public Vertex(char name) {
            this.name = name;
        }

        public Vertex() {

        }

        @Override
        public String toString() {
            return String.valueOf(this.name);
        }
    }

    private static class Edge {
        Vertex start;//边的开始顶点
        Vertex end;//边的结束顶点
        int value;//权值

        public Edge(Vertex start, Vertex end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    private static List<Vertex> vertexList = new ArrayList<>();//节点集
    private static List<Vertex> visitedVertex = new ArrayList<>();//已经访问的节点集
    private static List<Edge> edgeList = new ArrayList<>();//边集合

    public static void addEdge(Vertex a, Vertex b, int val) {
        Edge edge = new Edge(a, b, val);
        edgeList.add(edge);
    }


    /**
     * 使用Prim算法求最小生成树
     */
    public static void minimumSpanningTree() {
        //随机选择第0个作为开始
        visitedVertex.add(vertexList.get(0));
        for (int i = 1; i < vertexList.size(); i++) {//其实并不需要遍历vertexList，需要做的只是剩余几个节点遍历几次即可，因为最终的目的是将所有的节点都加入已访问列表，而我们已经随机选择从第0个开始了，第0个已经被首先加入
            int temp = Integer.MAX_VALUE;//遍历取得权值最小的边，且该边属于start和end节点
            Vertex tempVertex = new Vertex();
            //从已访问列表中查找边，将其作为start，寻找start和end之间满足条件的边
            for (Vertex start : visitedVertex) {
                for (int j = 0; j < edgeList.size(); j++) {
                    Edge edge = edgeList.get(j);
                    if (edge.start.name == start.name && !containVertex(edge.end.name)) {
                        //说明在start和end之间存在边，并且边的权值也可以获得
                        int weight = edge.value;
                        if (weight < temp) {
                            temp = weight;
                            tempVertex = edge.end;//如若选择该边，那么将顶点加入已访问列表
                        }
                    }
                }
            }
            visitedVertex.add(tempVertex);
        }

    }

    /**
     * 测试当前顶点是否已加入“已访问顶点列表”
     *
     * @param name
     * @return
     */
    private static boolean containVertex(char name) {
        for (int i = 0; i < visitedVertex.size(); i++) {
            if (visitedVertex.get(i).name == name) {
                return true;
            }
        }
        return false;
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
        System.out.println(visitedVertex);
    }
}
