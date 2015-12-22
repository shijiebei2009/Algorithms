package cn.codepub.algorithms.commons;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * <p>
 * Created with IntelliJ IDEA. 15/12/17 11:03
 * </p>
 * <p>
 * ClassName:TopK
 * </p>
 * <p>
 * Description:思考利用JDK的PriorityQueue实现TopK问题，TopK问题说的是：输入n个整数，输出其中最小的k个
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class TopK {

    private static Queue<Integer> queue;

    /**
     * 从n个整数中查找最小的k个
     *
     * @param n
     * @param k
     * @return
     */
    public static boolean getTopK(int n, int k) {
        queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        if (n < k) {
            System.err.println("输入的n和k不合法！");
            return false;
        }

        Random random = new Random();
        //先加入k个再说
        for (int i = 0; i < k; i++) {
            queue.add(random.nextInt());
        }
        //这个时候，队列已满，若再想加入，那么必须是比队列中最大的元素小的才可以加入
        for (int i = k; i < n; i++) {
            int i1 = random.nextInt();
            if (queue.peek() > i1) {
                queue.poll();
                queue.add(i1);
            }

        }
        return true;
    }

    /**
     * 因为队列是一个大根堆，所以如果想从小到大输出的话，需要借助其它方式，最简单的是利用递归同样可以实现
     *
     * @param queue
     */
    public static void printTopK(Queue queue) {
        if (!queue.isEmpty()) {
            Object remove = queue.remove();
            printTopK(queue);
            System.out.println(remove);
        }
    }

    @Test
    public void test() {
        boolean topK = getTopK(5, 10);
        if (topK) {
            printTopK(queue);
        }
        topK = getTopK(100, 100);
        if (topK) {
            printTopK(queue);
        }
        topK = getTopK(10000, 10);
        if (topK) {
            printTopK(queue);
        }

    }
}
