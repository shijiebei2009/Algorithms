package cn.codepub.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/12/1 18:21
 * </p>
 * <p>
 * ClassName:UndirectedGraphByAdjacencyMatrix
 * </p>
 * <p>
 * Description:使用邻接矩阵实现无向图的深度优先及广度优先
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */

public class UndirectedGraphByAdjacencyMatrix {
    private String[] vertex;//顶点集合
    private int[][] edges;//边的集合

    public static void main(String[] args) {
        UndirectedGraphByAdjacencyMatrix undirectedGraphByAdjacencyMatrix = new UndirectedGraphByAdjacencyMatrix();
        undirectedGraphByAdjacencyMatrix.createGraph();//创建图
        // test data following
        // please input vertex number:
        // 7
        // please input edge number:
        // 7
        // input the vertex by space:
        // a b c d e f g
        // input the edge between vertex by pair:
        // a c a d a f b c c d e g f g
        undirectedGraphByAdjacencyMatrix.depthFirstSearch();//开始深度优先
        undirectedGraphByAdjacencyMatrix.breadthFirstSearch();

    }

    public void breadthFirstSearch() {
        //设置访问标记数组
        System.out.println("\nBreadth First Search:");
        boolean[] visited = new boolean[vertex.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < vertex.length; i++) {
            if (!visited[i]) {
                System.out.print(vertex[i] + "\t");
                queue.add(i);
                visited[i] = true;
            }
            while (!queue.isEmpty()) {
                int remove = queue.remove();
                int count = 0;
                for (int j = getNextVertex(remove, count); j >= 0; j = getNextVertex(remove, count)) {
                    if (!visited[j]) {
                        visited[j] = true;
                        System.out.print(vertex[j] + "\t");
                        queue.add(j);
                    } else {
                        count++;
                    }
                }
            }
        }
    }

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
        vertex = new String[vertexNum];
        edges = new int[vertexNum][vertexNum];
        System.out.println("input the vertex by space:");
        for (int i = 0; i < vertexNum; i++) {
            vertex[i] = scanner.next();
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
            //更新边的邻接矩阵
            edges[start][end] = 1;
            edges[end][start] = 1;
        }
        System.out.println("打印顶点如下：" + Arrays.toString(vertex));
        System.out.println("打印边的邻接矩阵如下：");
        for (int temp[] : edges) {
            System.out.println(Arrays.toString(temp));
        }
    }

    /**
     * 对外暴露的调用接口
     */
    public void depthFirstSearch() {
        //设置访问标记数组
        boolean[] visited = new boolean[vertex.length];

        System.out.println("Depth First Search:");
        for (int i = 0; i < vertex.length; i++) {
            if (!visited[i]) {
                depthFirstSearch(visited, i);
            }
        }

    }

    /**
     * 内部递归的深度优先实现
     *
     * @param visited
     * @param i
     */
    private void depthFirstSearch(boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(vertex[i] + "\t");
        int count = 0;
        for (int j = getNextVertex(i, count); j >= 0; j = getNextVertex(i, count)) {
            if (!visited[j]) {
                depthFirstSearch(visited, j);
            } else {
                count++;
            }
        }
    }

    /**
     * 寻找与当前点有边相连的下一个顶点
     *
     * @param row 查找该行
     * @param col 从该列开始查找
     * @return
     */
    private int getNextVertex(int row, int col) {
        for (int j = col; j < edges[row].length; j++) {
            if (edges[row][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 返回顶点在集合中的位置
     *
     * @param s
     * @return
     */
    public int getPosition(String s) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].equalsIgnoreCase(s)) {
                return i;
            }
        }
        return -1;
    }

}
