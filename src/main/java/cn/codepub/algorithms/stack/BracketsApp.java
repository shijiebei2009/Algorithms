package cn.codepub.algorithms.stack;

import cn.codepub.algorithms.utils.StackX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * Created with IntelliJ IDEA. 2016/1/8 20:17
 * </p>
 * <p>
 * ClassName:BracketsApp
 * </p>
 * <p>
 * Description:判断括号是否匹配，For Example：(((())))
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */

public class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.println("Enter string containing delimiters:");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        return str;
    }
}

class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        this.input = in;
    }

    public void check() {
        int stackSize = input.length();
        StackX<Character> theStack = new StackX(stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = theStack.pop();
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[')
                                || (ch == ')' && chx != '(')) {
                            System.out.println("Error:" + ch + " at " + (j + 1));
                        }
                    } else {
                        System.out.println("Error:" + ch + " at " + (j + 1));
                    }
                default:
                    break;
            }
        }
        if (!theStack.isEmpty()) {
            System.out.println("Error:missing right delimiter");
        } else {
            System.out.println("It is legitimate!");
        }
    }

}
