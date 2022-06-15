public class HouseRobber {
    public static void main(String[] args) {
        int[] arr={2,1,4,9};
        int[] dp = new int[arr.length];
        System.out.println(rec(3,arr));
    }
    public static int rec(int ind,int[] arr){
        if(ind==0){
            return arr[ind];
        }
        if(ind<0){
            return 0;
        }

        int pick = arr[ind]+rec(ind-2,arr);
        int notPick = rec(ind-1,arr);

        return Math.max(pick,notPick);
    }
}
