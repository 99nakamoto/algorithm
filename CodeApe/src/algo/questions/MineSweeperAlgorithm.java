package algo.questions;

import java.util.ArrayList;
import java.util.List;

public class MineSweeperAlgorithm {

    // this minesweeper algorithm uses O(1) space complexity

    // set verbose to false to hide the step-by-step loggging
    private static final boolean verbose = true;
    private static int stepCount = 1;

    public static void main(String[] args) {
        MineSweeperAlgorithm ins = new MineSweeperAlgorithm();
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
                ins.validate(matrix, matrix.length, matrix[0].length));
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
                ins.validate(matrix, matrix.length, matrix[0].length));
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
                ins.validate(matrix, matrix.length, matrix[0].length));
        System.out.println();

        System.out.print("Total time = ");
        System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
    }

    public boolean validate(int[][] matrix, int m, int n) {
        Pos nextStep = findZero(matrix, m, n);
        if (nextStep == null) {
            // the matrix deos not contain 0
            return false;
        }

        // visit the first position, and go from there
        matrix[nextStep.x][nextStep.y] = 2;
        while (nextStep != null) {
            nextStep = step(matrix, nextStep, m, n);
        }

        // after visiting all positions, check if there is remaining 0s
        return findZero(matrix, m, n) == null;
    }

    Pos step(int[][] matrix, Pos cur, int m, int n) {
        // Now cur is located at a pos with value = 2
        // print matrix in "verbose" mode
        if (verbose) {
            System.out.println("Step #" + stepCount++);
            for (int[] array : matrix) {
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        // make a list of valid neighbors, for the convenience of checking
        List<Pos> neighbors = new ArrayList<Pos>();
        neighbors.add(new Pos(cur.x - 1, cur.y));
        neighbors.add(new Pos(cur.x, cur.y - 1));
        neighbors.add(new Pos(cur.x + 1, cur.y));
        neighbors.add(new Pos(cur.x, cur.y + 1));
        for (int i = neighbors.size() - 1; i >= 0; i--) {
            if (!isValidPos(neighbors.get(i), m, n)) {
                neighbors.remove(i);
            }
        }

        // check if there is adjacent 0,
        // if there is, mark 0 as 2 and return that position
        for (Pos neighbor : neighbors) {
            if (matrix[neighbor.x][neighbor.y] == 0) {
                matrix[neighbor.x][neighbor.y] = 2;
                return neighbor;
            }
        }

        // if no adjacent 0, then check if there is adjacent 2.
        // if there is, mark current as 3 and then return that position
        for (Pos neighbor : neighbors) {
            if (matrix[neighbor.x][neighbor.y] == 2) {
                matrix[cur.x][cur.y] = 3;
                return neighbor;
            }
        }

        //if no adjacent 0 and no adjacent 2, mark current as 3 and return null
        matrix[cur.x][cur.y] = 3;
        return null;
    }

    boolean isValidPos(Pos p, int m, int n) {
        return p.x >= 0 && p.x < m && p.y >= 0 && p.y < n;
    }

    Pos findZero(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    return new Pos(i, j);
                }
            }
        }
        return null;
    }

    class Pos {
        int x;
        int y;

        public Pos(int a, int b) {
            x = a;
            y = b;
        }
    }
}
