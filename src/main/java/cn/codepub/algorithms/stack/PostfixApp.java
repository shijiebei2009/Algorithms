package cn.codepub.algorithms.stack;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>
 * Created with IntelliJ IDEA. 2016/1/8 19:04
 * </p>
 * <p>
 * ClassName:PostfixApp
 * </p>
 * <p>
 * Description:求解后缀表达式，For Example<br/>
 * Enter postfix:34*2/<br/>
 * 3 Stack(bottom->top):<br/>
 * 4 Stack(bottom->top):3<br/>
 * Stack(bottom->top):3 4<br/>
 * 2 Stack(bottom->top):12<br/>
 * / Stack(bottom->top):12 2<br/>
 * Evaluates to 6<br/>
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class PostfixApp {
    public static void main(String[] args) throws Exception {
        String input;
        int output;
        while (true) {
            System.out.print("Enter postfix:");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            ParsePost aParse = new ParsePost(input);
            output = aParse.doParse();
            System.out.println("Evaluates to " + output);
        }
    }

    public static String getString() throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(isr);
        String s = buf.readLine();
        return s;
    }
}

class StackX {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public int peekN(int n) {
        return stackArray[n];
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

class ParsePost {
    private StackX theStack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public int doParse() {
        theStack = new StackX(20);
        char ch;
        int j;
        int num1, num2, interAns;
        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            theStack.displayStack("" + ch + " ");
            if (ch >= '0' && ch <= '9') {
                theStack.push((int) (ch - '0'));
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                        break;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}