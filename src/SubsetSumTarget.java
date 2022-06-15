import java.util.Arrays;

public class SubsetSumTarget {
    public static void main(String[] args) {
        int[] arr = {2,3,1,3};
        int target = 11;
        int[][] dp = new int[arr.length][target+1];
        boolean[][] dp1 = new boolean[arr.length][target+1];
        for(int i=0;i<arr.length;i++){
            for (int j = 0 ;j<target+1;j++){
                dp[i][j] = -1;
            }
        }
        for(int i=0;i<arr.length;i++){
            for (int j = 0 ;j<target+1;j++){
                dp1[i][j] = false;
            }
        }
        System.out.println(rec(arr,target,3));
        System.out.println(memo(arr,target,3,dp));
        System.out.println(tab(arr,target,dp1));
        System.out.println(space(arr,target));
    }
    public static boolean rec(int[] arr , int target , int index){
        if(target == 0){
            return true;
        }
        if(index == 0){
            return arr[index] == target;
        }
        boolean notTake = rec(arr,target,index-1);

        boolean take = false;
        if(target>=arr[index]){
            take = rec(arr , target-arr[index] , index-1);
        }

        return notTake||take;
    }
    public static boolean memo(int[] arr , int target , int index ,int[][] dp){
        if(target==0){
            return true;
        }
        if(index==0){
            return target == arr[index];
        }
        if(dp[index][target]!=-1){
            if(dp[index][target]==0){
                return false;
            }
            else{
                return true;
            }
        }
        boolean notTake = memo(arr , target , index-1,dp);
        boolean take = false;
        if(target>=arr[index]){
            take = memo(arr,target-arr[index] , index-1,dp);
        }
        boolean ans = take||notTake;
        if(ans == true){
            dp[index][target] = 1;
            return ans;
        }
        else{
            dp[index][target] = 0;
            return ans;
        }

    }
    public static boolean tab(int[] arr , int target , boolean[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        dp[0][arr[0]] =true;
        for(int i =1 ; i<arr.length;i++){
            for(int j=1;j<target+1;j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(j>=arr[i]){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take||notTake;
            }
        }
        return dp[arr.length-1][target];
    }
    public static boolean space(int[] arr , int target){
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        prev[arr[0]] =true;
        for(int i =1 ; i<arr.length;i++){
            boolean[] curr = new boolean[target+1];
            curr[0]=true;
            for(int j=1;j<target+1;j++){
                boolean notTake = prev[j];
                boolean take = false;
                if(j>=arr[i]){
                    take = prev[j-arr[i]];
                }
                curr[j] = take||notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}
