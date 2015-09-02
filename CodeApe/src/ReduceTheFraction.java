import java.util.Scanner;

public class ReduceTheFraction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            System.out.println(process(line));
        }
    }

    private static String process(String line) {
        String[] input = line.split("/");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);
        int commonDivisor = gcd(num1, num2);
        return num1 / commonDivisor + "/" + num2 / commonDivisor;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
