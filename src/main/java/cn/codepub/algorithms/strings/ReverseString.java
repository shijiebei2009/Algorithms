package cn.codepub.algorithms.strings;

import cn.codepub.algorithms.utils.StackX;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>
 * Created with IntelliJ IDEA. 2016/1/8 19:32
 * </p>
 * <p>
 * ClassName:ReverseString
 * </p>
 * <p>
 * Description:反转字符串，例如abc->cba
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class ReverseString {
    private String input;
    private String output = "";//默认是null，所以此处将""赋值给它

    public ReverseString(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX<Character> theStack = new StackX(stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }

    public static String getString() throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws Exception {
        String input, output;
        while (true) {
            System.out.println("Enter a String:");
            System.out.flush();
            input = ReverseString.getString();
            if (input.equals("")) {
                break;
            }
            ReverseString reverse = new ReverseString(input);
            output = reverse.doRev();
            System.out.println("Reversed:" + output);

        }

    }
}
