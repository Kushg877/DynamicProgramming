import java.util.Arrays;

public class MaximumSumNonAdjacent {
    public static void main(String[] args) {
        int[] arr={2,1,4,15};
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(rec(3,arr));
        System.out.println(memo(3,dp,arr));
        System.out.println(tab(dp,arr));
        System.out.println(space(arr));
    }
    public static int rec(int ind , int[] arr){
        if(ind==0){
            return arr[ind];
        }
        if(ind<0){
            return 0;
        }

        int pick = arr[ind]+rec(ind-2,arr);
        int nonPick = rec(ind-1,arr);

        return Math.max(pick,nonPick);
    }

    public static int memo(int ind, int[] dp, int[] arr){
        if(ind==0){
            return dp[ind] = arr[ind];
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int pick = arr[ind]+memo(ind-2,dp,arr);
        int nonPick = memo(ind-1,dp,arr);

        return dp[ind]=Math.max(pick,nonPick);

    }

    public static int tab(int[] dp,int[] arr){
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            int pick =arr[i];
            if(i>1){
                pick+=dp[i-2];
            }
            int nonPick = arr[i-1];
            dp[i]=Math.max(pick,nonPick);
        }
        return dp[dp.length-1];
    }

    public static int space(int[] arr){
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1;i<arr.length;i++){
            int pick =arr[i];
            if(i>1){
                pick+=prev2;
            }
            int nonPick = prev;
            int curri=Math.max(pick,nonPick);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}
