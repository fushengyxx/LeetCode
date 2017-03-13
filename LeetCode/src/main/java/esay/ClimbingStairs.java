package esay;

/**
 * Created by yixinxin on 17/3/13.
 * <p>
 * 70. Climbing Stairs
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {
    // bugs
    // 3 as a group
    public int climbStairs(int n) {
        int result = 1;
        int res = n % 3;
        int group = n / 3; // 1 1 1, 1 2, 2 1

        switch (res) {
            case 0:
                result = (int) Math.pow(3, group);
                break;
            case 1:
                result = (int) Math.pow(3, group) + group + 1;
                break;
            case 2:
                result = (int) Math.pow(3, group) + group + 1;
        }
        return result;
    }

    // fibonacci
    /*
    Base cases:
    if n <= 0, then the number of ways should be zero.
    if n == 1, then there is only way to climb the stair.
    if n == 2, then there are two ways to climb the stairs.
    One solution is one step by another; the other one is two steps at one time.

    The key intuition to solve the problem is that given a number of stairs n, if we know the number ways to get to
    the points [n-1] and [n-2] respectively, denoted as n1 and n2 , then the total ways to get to the point [n] is n1
     + n2. Because from the [n-1] point, we can take one single step to reach [n]. And from the [n-2] point, we could
      take two steps to get there. There is NO overlapping between these two solution sets, because we differ in the
      final step.


     */
    public int climbStairs1(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_left = 2; // f(n-1)，refers to the number of solutions until the point [n-1]
        int two_step_left = 1; // f(n-2)，refers to the number of solution until the point [n-2]
        int all_ways = 0;

        // i = 2    => f(3)
        // i = n -1 => f(n)
        for(int i = 2; i < n; i++){
            // f(n) = f(n-1) + f(n-2)
            all_ways = one_step_left + two_step_left;

            // f(n-2) = f(n-1)
            two_step_left = one_step_left;
            // f(n-1) = f(n)
            one_step_left = all_ways;
        }
        return all_ways;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs1(4));
    }
}
