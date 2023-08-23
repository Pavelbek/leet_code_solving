package pargunov.easy;

public class ClimbingStairs_70 {
    public static void main(String[] args) {
        // 1
        // 2 = 2
        // 3 = 2 + 1 = 3
        // 4 = 3 + 2 = 5
        // 5 = 5 + 3
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {
        int first = 1;
        int second = 2;
        if (n == 1) return first;

        for (int i = 3; i <= n; i++) { //
            var tmp = first;
            first = second;
            second = tmp + second;
        }

        return second;
    }
}
