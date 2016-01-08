package cn.codepub.algorithms.utils;

/**
 * <p>
 * Created with IntelliJ IDEA. 2016/1/8 19:18
 * </p>
 * <p>
 * ClassName:StackX
 * </p>
 * <p>
 * Description:公用的自定义Stack，支持泛型操作
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class StackX<T> {
    private int maxSize;
    private Object[] stackArray;
    private int top;

    public StackX() {

    }

    public StackX(int s) {
        maxSize = s;
        stackArray = new Object[maxSize];
        top = -1;
    }

    public void push(T j) {
        stackArray[++top] = j;
    }

    public T pop() {
        return (T) stackArray[top--];
    }

    public T peek() {
        return (T) stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public T peekN(int n) {
        return (T) stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack(bottom->top):");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j) + " ");
        }
        System.out.println();
    }
}
