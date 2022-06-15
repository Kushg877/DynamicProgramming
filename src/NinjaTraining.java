import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] arr = {{1,2,5},{3,1,1},{3,3,3}};
        int[][] dp = new int[4][4];
        System.out.println(rec2(0,3,arr));
        System.out.println(memo(2,3,arr,dp));
        System.out.println(tab(0,2,dp,arr));
    }


    public static int memo(int day ,int last , int[][] arr , int[][] dp){
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi = Math.max(arr[0][i],maxi);
                }
            }
            return dp[day][last]=maxi;
        }
        if(dp[day][last]!=0){
            return dp[day][last];
        }
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int point = memo(day-1,i,arr,dp)+arr[day][i];
                maxi = Math.max(point,maxi);
            }
        }
        return dp[day][last]= maxi;
    }

    public static int rec(int day, int last, int[][] arr){
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi = Math.max(arr[0][i],maxi);
                }
            }
            return maxi;
        }
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int point = rec(day-1,i,arr)+arr[day][i];
                maxi = Math.max(point,maxi);
            }
        }
        return maxi;
    }
    public static int rec2(int day , int last , int[][] arr){
        if(day==2){
            int maxi = 0;
            for(int i =0 ; i<=2;i++){
                if(i!=last){
                    maxi = Math.max(maxi,arr[day][i]);
                }
            }
            return maxi;
        }
        int maxi=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int point = rec2(day+1,i,arr)+arr[day][i];
                maxi = Math.max(maxi,point);
            }
        }
        return maxi;
    }
    public static int tab(int day,int last,int[][] dp,int[][] arr){
        int n = arr.length;

        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][1],arr[0][0]);
        dp[0][3] = Math.max(Math.max(arr[0][1],arr[0][2]),arr[0][0]);

        for(int i=1;i<n;i++){
            for(int j=0;j<=3;j++){
                int maxi=0;
                for(int k=0;k<3;k++){
                    int point = rec2(day+1,i,arr)+arr[day][i];
                    maxi = Math.max(maxi,point);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[n-1][3];
    }


}
