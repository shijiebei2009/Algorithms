package cn.codepub.algorithms.stack;


import cn.codepub.algorithms.utils.StackX;

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


class ParsePost {
    private StackX<Integer> theStack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public int doParse() {
        theStack = new StackX<Integer>(20);
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