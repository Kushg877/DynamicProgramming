import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr={10,20,30,10,20};
        int dp[] = new int[6];
        Arrays.fill(dp,-1);
        System.out.println(rec(0,4,arr,0));
        System.out.println(memo(4,dp,arr));
        System.out.println(tab(dp,arr));
        System.out.println(space(arr));
    }

    // Normal Recursion
    public static int rec(int curr, int fin , int[] arr , int energy){
        if(curr==fin){
            return energy;
        }
        if(curr==fin-1){
            return rec(curr+1,fin,arr,energy+Math.abs(arr[curr+1]-arr[curr]));
        }
        int left = rec(curr+1,fin,arr,energy+Math.abs(arr[curr+1]-arr[curr]));
        int right = rec(curr+2,fin,arr,energy+Math.abs(arr[curr+2]-arr[curr]));

        return Math.min(left,right);
    }

    // DP - Memoization
    public static int memo(int ind,  int[] dp , int[] arr ){
        if(ind==0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }

        int left = memo(ind-1,dp,arr) + Math.abs(arr[ind]-arr[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind>1){
            right = memo(ind-2,dp,arr) + Math.abs(arr[ind]-arr[ind-2]);
        }

        return dp[ind] = Math.min(left,right);
    }

    // Tabulation Method
    public static int tab(int[] dp,int[] arr){
        int n = arr.length;
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int left = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = dp[i-2] + Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(left,right);
        }
        return dp[n-1];
    }

    // Space Optimization
    public static int space(int[] arr){
        int n = arr.length;
        int prev = 0;
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int left = prev+Math.abs(arr[i]-arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = prev2 + Math.abs(arr[i]-arr[i-2]);
            }
            int curri = Math.min(left,right);
            prev2 = prev;
            prev=curri;
        }
        return prev;
    }
}
