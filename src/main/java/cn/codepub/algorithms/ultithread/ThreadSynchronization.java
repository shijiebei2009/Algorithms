package cn.codepub.algorithms.ultithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/29 21:43
 * </p>
 * <p>
 * ClassName:ThreadSynchronization
 * </p>
 * <p>
 * Description:开启三个线程，这三个线程的ID分别是A,B,C，每个线程将自己的ID在屏幕上打印10遍，要求输出结果必须按ABC的顺序显示，例如ABCABC...
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class ThreadSynchronization extends Thread {

    private AtomicInteger synObj;//全局共享的同步计数器
    private String name;//每个线程的ID
    private int flag;//每个线程的标识，用来判断该第几个线程打印了

    private int count = 0;//记录打印次数

    public ThreadSynchronization(AtomicInteger synObj, String name, int flag) {
        this.synObj = synObj;
        this.name = name;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (synObj) {
                if (synObj.get() % 3 == flag) {
                    synObj.set(synObj.get() + 1);
                    System.out.print(name);
                    count++;
                    synObj.notifyAll();
                    if (count == 10) {
                        break;
                    }
                } else {
                    try {
                        synObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ThreadSynchronization tp = new ThreadSynchronization(atomicInteger, "A", 0);
        ThreadSynchronization tp1 = new ThreadSynchronization(atomicInteger, "B", 1);
        ThreadSynchronization tp2 = new ThreadSynchronization(atomicInteger, "C", 2);
        tp.start();
        tp1.start();
        tp2.start();
    }
}