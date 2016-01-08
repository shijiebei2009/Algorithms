package cn.codepub.algorithms.queue;

/**
 * <p>
 * Created with IntelliJ IDEA. 2016/1/8 19:57
 * </p>
 * <p>
 * ClassName:PriorityApp
 * </p>
 * <p>
 * Description:Implements a simple priority queue
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */


public class PriorityApp {
    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityApp().new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        while (!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + "   ");
        }
    }

    class PriorityQ {
        private int maxSize;
        private long[] queArray;
        private int nItems;

        public PriorityQ(int s) {
            maxSize = s;
            queArray = new long[maxSize];
            nItems = 0;
        }

        public void insert(long item) {
            int j;
            if (nItems == 0) {
                queArray[nItems++] = item;

            } else {
                for (j = nItems - 1; j >= 0; j--) {
                    if (item > queArray[j]) {
                        queArray[j + 1] = queArray[j];
                    } else {
                        break;
                    }

                }
                queArray[j + 1] = item;
                nItems++;
            }
        }

        public long remove() {
            return queArray[--nItems];
        }

        public long peekMin() {
            return queArray[nItems - 1];
        }

        public boolean isEmpty() {
            return nItems == 0;
        }

        public boolean isFull() {
            return nItems == maxSize;
        }
    }
}

