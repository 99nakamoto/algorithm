package algo.questions;

import common.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class WoodenSticks {

    public static void main(String[] args) {
        WoodenSticks ins = new WoodenSticks();
        long startTime = System.currentTimeMillis();

        System.out.println("Code Ape Run... ");
        Pair[] points;

        points = new Pair[5];
        points[0] = new Pair(4, 9);
        points[1] = new Pair(5, 2);
        points[2] = new Pair(2, 1);
        points[3] = new Pair(3, 5);
        points[4] = new Pair(1, 4);
        System.out.println(ins.count(points));

        points = new Pair[3];
        points[0] = new Pair(2, 2);
        points[1] = new Pair(1, 1);
        points[2] = new Pair(2, 2);
        System.out.println(ins.count(points));

        points = new Pair[3];
        points[0] = new Pair(1, 3);
        points[1] = new Pair(2, 2);
        points[2] = new Pair(3, 1);
        System.out.println(ins.count(points));

        System.out.print("Total time = ");
        System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
    }

    public int count(Pair[] points) {
        Arrays.sort(points, new PointComparator());
        // now the array is sorted with Point.x
        int total = 0;
        int p = 0;
        int len = points.length;

        while (p < len) {
            // find the next non-null point
            while (p < len && points[p] == null) {
                p++;
            }
            if (p == len) {
                break;
            }
            // use points[p] as the first elements in the queue
            Pair temp = copy(points[p]);
            points[p] = null;
            total++;

            // then mark all elements that follow points[p]
            for (int k = p + 1; k < len; k++) {
                if (points[k] == null || points[k].y < temp.y) {
                    continue;
                }
                temp = copy(points[k]);
                points[k] = null;
            }
            p++;
        }
        return total;
    }

    Pair copy(Pair p) {
        Pair newP = new Pair(p.x, p.y);
        return newP;
    }

    class PointComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.x - p2.x;
        }
    }
}
