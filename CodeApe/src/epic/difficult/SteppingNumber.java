package epic.difficult;

public class SteppingNumber {

    // this question is very difficult!

    public static void main(String[] args) {

        SteppingNumber ins = new SteppingNumber();
        System.out.println();

        long s = 1;
        long e = 1000;
        int sLength = (int) Math.floor(Math.log10(s) + 1);
        int eLength = (int) Math.floor(Math.log10(e) + 1);
        for (long i = sLength; i <= eLength; ++i) {
            // no leading zero
            for (long j = 1; j < 10; ++j) {
                Dfs(s, e, i, j);
            }
        }
    }

    private void solution() {

    }

    static void Dfs(long s, long e, long length, long num) {
        if (length - 1 == 0) {
            if (s <= num && num <= e)
                System.out.println("Stepping Number: " + num);
            return;
        }
        int lastDigit = (int) (num % 10);
        if (lastDigit == 0) {
            Dfs(s, e, length - 1, num * 10 + 1);
        } else if (lastDigit == 9) {
            Dfs(s, e, length - 1, num * 10 + 8);
        } else {
            Dfs(s, e, length - 1, num * 10 + lastDigit - 1);
            Dfs(s, e, length - 1, num * 10 + lastDigit + 1);
        }
    }

}
