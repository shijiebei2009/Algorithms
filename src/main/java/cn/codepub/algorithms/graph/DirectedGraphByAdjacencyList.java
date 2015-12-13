package cn.codepub.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/12/2 20:33
 * </p>
 * <p>
 * ClassName:UndirectedGraphByAdjacencyList
 * </p>
 * <p>
 * Description:使用邻接表实现的无向图深度优先及广度优先
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class DirectedGraphByAdjacencyList {
    public static void main(String[] args) {
        DirectedGraphByAdjacencyList undirectedGraphAdjacencyList = new DirectedGraphByAdjacencyList();
        undirectedGraphAdjacencyList.createGraph();
        undirectedGraphAdjacencyList.depthFirstSearch();
        undirectedGraphAdjacencyList.breadthFirstSearch();
    }

    private void breadthFirstSearch() {
        boolean visited[] = new boolean[vertexes.length];
        Queue<Integer> queue = new ArrayDeque();
        System.out.println("\nBreadth First Search:");
        for (int i = 0; i < vertexes.length; i++) {
            if (!visited[i]) {
                queue.add(i);
            }
            while (!queue.isEmpty()) {
                Integer remove = queue.remove();
                if (!visited[remove]) {
                    String data = vertexes[remove].data;
                    System.out.print(data + "\t");
                    visited[remove] = true;
                }
                Edge firstEdge = vertexes[remove].firstEdge;
                while (firstEdge != null) {
                    if (!visited[firstEdge.vertex]) {
                        queue.add(firstEdge.vertex);
                    }
                    firstEdge = firstEdge.nextEdge;
                }

            }


        }
    }

    public void depthFirstSearch() {
        System.out.println("\nDepth First Search:");
        boolean[] visited = new boolean[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            if (!visited[i]) {
                depthFirstSearch(visited, i);
            }
        }
    }

    private void depthFirstSearch(boolean[] visited, int i) {
        System.out.print(vertexes[i].data + "\t");
        visited[i] = true;
        Edge firstEdge = vertexes[i].firstEdge;
        while (firstEdge != null) {
            if (!visited[firstEdge.vertex]) {
                depthFirstSearch(visited, firstEdge.vertex);
            }
            firstEdge = firstEdge.nextEdge;
        }
    }


    //邻接表中边对应的链表的顶点
    private class Edge {
        int vertex;//该边所指向顶点的位置
        Edge nextEdge;//指向下一条弧的指针
    }

    //邻接表中表的顶点
    private class Vertex {
        String data;//顶点信息
        Edge firstEdge;//指向第一条依附该顶点的弧
    }

    private Vertex[] vertexes;//顶点数组


    /**
     * 根据用户输入构造图
     */
    public void createGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input vertex number:");
        int vertexNum = scanner.nextInt();
        System.out.println("please input edge number:");
        int edgeNum = scanner.nextInt();

        //无向图有n个顶点，最多有n*(n-1)/2条边
        // vertex: n = > edge: (n-1)*n/2
        if (vertexNum < 1 || edgeNum < 1 || edgeNum > (vertexNum - 1) * vertexNum / 2) {
            System.err.println("input error, invalid vertex or edges!");
            return;
        }

        //init vertex and edges
        vertexes = new Vertex[vertexNum];
        System.out.println("input the vertex by space:");
        for (int i = 0; i < vertexNum; i++) {
            vertexes[i] = new Vertex();
            vertexes[i].data = scanner.next();
            vertexes[i].firstEdge = null;
        }


        System.out.println("input the edge between vertex by pair:");
        for (int i = 0; i < edgeNum; i++) {
            String v1 = scanner.next();
            String v2 = scanner.next();
            int start = getPosition(v1);
            int end = getPosition(v2);
            if (start == -1 || end == -1) {
                System.err.println(v1 + " or " + v2 + " are invalid!");
            }
            if (vertexes[start].firstEdge == null) {
                Edge edge = new Edge();
                edge.vertex = end;
                edge.nextEdge = null;
                vertexes[start].firstEdge = edge;
            } else {
                Edge firstEdge = vertexes[start].firstEdge;
                while (firstEdge.nextEdge != null) {
                    firstEdge = firstEdge.nextEdge;
                }
                Edge edge = new Edge();
                edge.vertex = end;
                edge.nextEdge = null;
                firstEdge.nextEdge = edge;
            }

        }
        System.out.println("打印顶点如下：");
        for (int i = 0; i < vertexes.length; i++) {
            String data = vertexes[i].data;
            System.out.print(data + "\t");
        }
        System.out.println("\n打印边的邻接表如下：");
        for (int i = 0; i < vertexes.length; i++) {
            Edge firstEdge = vertexes[i].firstEdge;
            System.out.print(vertexes[i].data);
            while (firstEdge != null) {
                System.out.print("--" + vertexes[firstEdge.vertex].data);
                firstEdge = firstEdge.nextEdge;
            }
            System.out.print("\t");
        }
    }

    private int getPosition(String v1) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i].data.equals(v1)) {
                return i;
            }
        }
        return -1;
    }
}
