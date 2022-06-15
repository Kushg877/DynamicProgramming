import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(print1(n,dp));
        System.out.println(Arrays.toString(dp));
    }
    public static int print1(int n, int[] dp){
        if(n<=1) return n;

        if(dp[n]!= -1) return dp[n];
        return dp[n]= print1(n-1,dp) + print1(n-2,dp);
    }
}
