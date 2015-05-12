package algo.questions;

import java.util.ArrayList;
import java.util.List;

public class MineSweeperAskyfeng {

    // this minesweeper algorithm uses O(1) space complexity

    // set verbose to false to hide the step-by-step loggging
    private static final boolean verbose = false;
    private static int stepCount = 1;

    public static void main(String[] args) {
        MineSweeperAskyfeng ins = new MineSweeperAskyfeng();
        long startTime = System.currentTimeMillis();

        System.out.println("Code Ape Run... ");

        int[][] matrix;
        // make a test case
        stepCount = 1;
        matrix = new int[5][];
        matrix[0] = new int[]{0, 0, 0, 1, 0};
        matrix[1] = new int[]{0, 1, 1, 1, 1};
        matrix[2] = new int[]{0, 0, 0, 0, 1};
        matrix[3] = new int[]{0, 1, 1, 0, 1};
        matrix[4] = new int[]{0, 0, 1, 0, 1};

        // run the test
        System.out.println("Result is " +
                ins.validate(matrix));
        System.out.println();

        // make another test case
        stepCount = 1;
        matrix = new int[5][];
        matrix[0] = new int[]{0, 0, 0, 1, 0};
        matrix[1] = new int[]{0, 1, 0, 1, 0};
        matrix[2] = new int[]{0, 1, 0, 1, 0};
        matrix[3] = new int[]{0, 1, 0, 1, 0};
        matrix[4] = new int[]{0, 1, 0, 0, 0};

        // run the test
        System.out.println("Result is " +
                ins.validate(matrix));
        System.out.println();

        // make another test case
        stepCount = 1;
        matrix = new int[5][];
        matrix[0] = new int[]{0, 0, 1, 1, 1};
        matrix[1] = new int[]{0, 1, 1, 1, 1};
        matrix[2] = new int[]{0, 1, 0, 0, 1};
        matrix[3] = new int[]{0, 0, 0, 0, 1};
        matrix[4] = new int[]{0, 0, 0, 0, 1};

        // run the test
        System.out.println("Result is " +
                ins.validate(matrix));
        System.out.println();

        System.out.print("Total time = ");
        System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
    }

    public boolean validate(int[][] puzzle) {
        //4-connectivity
        boolean firstScan = true;
        for (int r = 0; r < puzzle.length; r++) {
            for (int c = 0; c < puzzle[0].length; c++) {
                if (1 == puzzle[r][c])
                    continue;
                if (!firstScan && 0 == puzzle[r][c])
                    return false;

                int x = r, y = c;
                while (true) {
                    while (0 == puzzle[x][y]) {
                        puzzle[x][y] = 2;
                        if (x + 1 < puzzle.length && 0 == puzzle[x + 1][y]) {
                            x += 1;
                            continue;
                        }
                        if (y + 1 < puzzle[0].length && 0 == puzzle[x][y + 1]) {
                            y += 1;
                            continue;
                        }
                        if (x - 1 >= 0 && 0 == puzzle[x - 1][y]) {
                            x -= 1;
                            continue;
                        }
                        if (y - 1 >= 0 && 0 == puzzle[x][y - 1]) {
                            y -= 1;
                        }
                    }

                    while (2 == puzzle[x][y] && !((x + 1 < puzzle.length && 0 == puzzle[x + 1][y]) || (y + 1 < puzzle[0].length && 0 == puzzle[x][y + 1])
                            || (x - 1 >= 0 && 0 == puzzle[x - 1][y]) || (y - 1 >= 0 && 0 == puzzle[x][y - 1]))) {
                        puzzle[x][y] = 3;
                        if (x + 1 < puzzle.length && 2 == puzzle[x + 1][y]) {
                            x += 1;
                            continue;
                        }
                        if (y + 1 < puzzle[0].length && 2 == puzzle[x][y + 1]) {
                            y += 1;
                            continue;
                        }
                        if (x - 1 >= 0 && 2 == puzzle[x - 1][y]) {
                            x -= 1;
                            continue;
                        }
                        if (y - 1 >= 0 && 2 == puzzle[x][y - 1]) {
                            y -= 1;
                        }
                    }

                    if (x + 1 < puzzle.length && 0 == puzzle[x + 1][y])
                        x += 1;
                    else if (y + 1 < puzzle[0].length && 0 == puzzle[x][y + 1])
                        y += 1;
                    else if (x - 1 >= 0 && 0 == puzzle[x - 1][y])
                        x -= 1;
                    else if (y - 1 >= 0 && 0 == puzzle[x][y - 1])
                        y -= 1;
                    else
                        break;
                }
                firstScan = false;
            }
        }
        return true;
    }
}
