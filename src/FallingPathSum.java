import java.lang.reflect.Array;
import java.util.Arrays;

public class FallingPathSum {
    public static void main(String[] args) {
        int[][] matrix= {{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        int[][] dp={{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        int n = matrix.length;
        int m = matrix[n-1].length;
        int maxi=0;
        for(int i=0;i<m;i++){
            maxi = Math.max(maxi,memo(n-1,i,matrix,dp));
        }
        System.out.println(maxi);
        System.out.println(tab(matrix,dp));
        System.out.println(space(matrix));
    }
    public static int rec(int row , int col , int[][] matrix){
        if(col<0 || col>matrix[0].length-1){
            return -11;
        }
        if(row == 0){
            return matrix[row][col];
        }

        int ld = matrix[row][col]+rec(row-1,col-1,matrix);
        int rd = matrix[row][col]+rec(row-1,col+1,matrix);
        int u =matrix[row][col]+rec(row-1,col,matrix);

        return Math.max(ld,Math.max(rd,u));
    }

    public static int memo(int row , int col , int[][] matrix , int[][] dp){
        if(col<0 || col>matrix[0].length-1){
            return -11;
        }
        if(row == 0){
            return matrix[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int ld = matrix[row][col]+memo(row-1,col-1,matrix,dp);
        int rd = matrix[row][col]+memo(row-1,col+1,matrix,dp);
        int u =matrix[row][col]+memo(row-1,col,matrix,dp);

        return dp[row][col] = Math.max(ld,Math.max(rd,u));
    }

    public static int tab(int[][] matrix , int[][] dp){
        for(int i=0;i<matrix.length;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int row=1;row<matrix.length;row++){
            for( int col = 0; col<matrix[row].length;col++){
                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;
                if(col>0){
                    ld = matrix[row][col]+dp[row-1][col-1];
                }
                if(col<matrix[row].length-1){
                    rd = matrix[row][col]+dp[row-1][col+1];
                }
                int u =matrix[row][col]+dp[row-1][col];
                dp[row][col] = Math.max(u,Math.max(ld,rd));
            }
        }
        int maxi = Integer.MIN_VALUE;
        for (int col = 0; col<matrix[0].length;col++){
            maxi = Math.max(maxi,dp[matrix.length-1][col]);
        }
        return maxi;
    }

    public static int space(int[][] matrix){
        int[] prev = new int[matrix[0].length];
        for(int i=0;i< matrix[0].length;i++){
            prev[i] = matrix[0][i];
        }

        for(int row=1;row<matrix.length;row++){
            int[] curr = new int[matrix[0].length];
            for( int col = 0; col<matrix[row].length;col++){
                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;
                if(col>0){
                    ld = matrix[row][col]+prev[col-1];
                }
                if(col<matrix[row].length-1){
                    rd = matrix[row][col]+prev[col+1];
                }
                int u =matrix[row][col]+prev[col];
                curr[col] = Math.max(u,Math.max(ld,rd));
            }
            prev=curr;
        }
        int maxi = Integer.MIN_VALUE;
        for (int col = 0; col<matrix[0].length;col++){
            maxi = Math.max(maxi,prev[col]);
        }
        return maxi;
    }

}
