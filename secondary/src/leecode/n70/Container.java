package leecode.n70;

public class Container {
    public static void main(String[] args) {
        System.out.printf(climbStairs(1000) + "");
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    public static int climbStairsMemo(int n, int memo[]) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }


}
