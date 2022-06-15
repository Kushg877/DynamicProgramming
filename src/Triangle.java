public class Triangle {
    public static void main(String[] args) {
        int[][] matrix = {{1},{2,3},{3,6,7},{8,9,6,10}};
        int[][] dp={{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        System.out.println(rec(0,0,matrix));
        System.out.println(memo(0,0,matrix,dp));
        System.out.println(tab(matrix,dp));
        System.out.println(space(matrix));
    }
    public static int rec(int row, int col , int[][] matrix){
        if(row== matrix.length-1){
            return matrix[row][col];
        }
        int d = matrix[row][col]+rec(row+1,col,matrix);
        int dr =matrix[row][col]+rec(row+1,col+1,matrix);

        return Math.min(d,dr);
    }
    public static int memo(int row, int col , int[][] matrix , int[][] dp){
        if(row== matrix.length-1){
            return matrix[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int d = matrix[row][col]+memo(row+1,col,matrix,dp);
        int dr =matrix[row][col]+memo(row+1,col+1,matrix,dp);

        return dp[row][col] =Math.min(d,dr);
    }

    public static int tab(int[][] matrix , int[][] dp){
        int n = matrix.length;
        for(int i=0;i<matrix[n-1].length;i++){
            dp[n-1][i] = matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d = matrix[i][j]+dp[i+1][j];
                int dr =matrix[i][j]+dp[i+1][j+1];
                dp[i][j] =Math.min(d,dr);
            }
        }
        return dp[0][0];
    }

    public static int space(int[][] matrix){
        int n = matrix.length;
        int[] prev = new int[n];
        for(int i=0;i<matrix[n-1].length;i++){
            prev[i] = matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            int[] curr=new int[n];
            for(int j=i;j>=0;j--){
                int d = matrix[i][j]+prev[j];
                int dr =matrix[i][j]+prev[j+1];
                curr[j] =Math.min(d,dr);
            }
            prev=curr;
        }
        return prev[0];
    }
}
