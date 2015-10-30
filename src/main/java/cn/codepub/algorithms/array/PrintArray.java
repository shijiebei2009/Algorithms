package cn.codepub.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/29 21:29
 * </p>
 * <p>
 * ClassName:PrintArray
 * </p>
 * <p>
 * Description:顺时针打印二位数组
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class PrintArray {
    static int nums[][];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        nums = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        moveRight(0, 0, nums.length, nums[0].length, 0, nums.length * nums[0].length);
        System.out.println(list);
        list.clear();
        nums = new int[][]{{1}, {2}};
        moveRight(0, 0, nums.length, nums[0].length, 0, nums.length * nums[0].length);
        System.out.println(list);
        list.clear();
    }

    private static void moveRight(int curRow, int curCol, int rows, int cols, int temp, int size) {
        if (size <= 0) {
            return;
        }
        if (curCol + 1 < cols - temp) {
            list.add(nums[curRow][curCol]);
            curCol++;
            size--;
            moveRight(curRow, curCol, rows, cols, temp, size);
        } else {
            moveDown(curRow, curCol--, rows, cols, temp, size);
        }
    }

    private static void moveDown(int curRow, int curCol, int rows, int cols, int temp, int size) {
        if (size <= 0) {
            return;
        }
        if (curRow + 1 < rows - temp) {
            list.add(nums[curRow][curCol]);
            size--;
            curRow++;
            moveDown(curRow, curCol, rows, cols, temp, size);
        } else {
            moveLeft(curRow--, curCol, rows, cols, temp, size);
        }
    }

    private static void moveLeft(int curRow, int curCol, int rows, int cols, int temp, int size) {
        if (size <= 0) {
            return;
        }
        if (curCol - 1 >= temp - 1) {
            list.add(nums[curRow][curCol]);
            size--;
            curCol--;
            moveLeft(curRow, curCol, rows, cols, temp, size);
        } else {
            moveUp(curRow, ++curCol, rows, cols, temp + 1, size);
        }

    }

    private static void moveUp(int curRow, int curCol, int rows, int cols, int temp, int size) {
        if (size <= 0) {
            return;
        }
        if (curRow - 1 > temp - 1) {
            curRow--;
            list.add(nums[curRow][curCol]);
            size--;
            moveUp(curRow, curCol, rows, cols, temp, size);
        } else {
            moveRight(curRow, ++curCol, rows, cols, temp, size);
        }
    }
}