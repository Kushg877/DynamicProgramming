import java.util.Arrays;

public class CherryPickup3D {
    public static void main(String[] args) {
        int[][] matrix = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
        int[][][] dp=new int[3][4][4];
        for(int i=0;i< dp.length;i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(rec(0,0,2,3,3,matrix));
        System.out.println(memo(0,0,2,3,3,matrix,dp));
    }
    public static int rec(int i, int j1,int j2,int r, int c,int[][] matrix){
        if(j1<0 || j2<0 || j1>=c || j2>=c){
            return -111;
        }
        if(i == r-1){
            if(j1==j2){
                return matrix[i][j1];
            }
            else{
                return matrix[i][j1]+matrix[i][j2];
            }
        }
        int maxi=-111;
        for(int dj1 = -1 ; dj1<=1 ; dj1++){
            for (int dj2 = -1 ; dj2<=1 ; dj2++){
                if(j1==j2){
                    maxi = Math.max(maxi,matrix[i][j1]+rec(i+1,j1+dj1,j2+dj2,r,c,matrix));
                }
                else{
                    maxi = Math.max(maxi,matrix[i][j1]+matrix[i][j2]+rec(i+1,j1+dj1,j2+dj2,r,c,matrix));
                }
            }
        }
        return maxi;
    }

    public static int memo(int i, int j1,int j2,int r, int c,int[][] matrix,int[][][] dp){
        if(j1<0 || j2<0 || j1>=c || j2>=c){
            return -111;
        }
        if(i == r-1){
            if(j1==j2){
                return matrix[i][j1];
            }
            else{
                return matrix[i][j1]+matrix[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int maxi=-111;
        for(int dj1 = -1 ; dj1<=1 ; dj1++){
            for (int dj2 = -1 ; dj2<=1 ; dj2++){
                if(j1==j2){
                    maxi = Math.max(maxi,matrix[i][j1]+rec(i+1,j1+dj1,j2+dj2,r,c,matrix));
                }
                else{
                    maxi = Math.max(maxi,matrix[i][j1]+matrix[i][j2]+rec(i+1,j1+dj1,j2+dj2,r,c,matrix));
                }
            }
        }
        return dp[i][j1][j2] = maxi;
    }
//    public static int tab(int[][] matrix, int[][][] dp){
//        for(int i=0;i<matrix[matrix.length].length;i++){
//            for(int j=0; j<matrix[matrix.length].length;j++){
//                if(i==j){
//                    dp[matrix.length-1][i][j]=matrix[matrix.length-1][j];
//                }
//                else{
//                    dp[matrix.length-1][i][j]=matrix[matrix.length-1][j]+=matrix[matrix.length-1][i];
//                }
//            }
//        }
//
//    }
}

