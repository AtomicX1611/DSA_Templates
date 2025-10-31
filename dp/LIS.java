public class LIS {
    int[] dp;
    int[] arr;
    public int rec(int i){

        if(i < 0) return 0;

        int ans = 0;
        for(int k = i;k>=0;k--){
            if(arr[k] < arr[i]) {
                ans = Math.max(ans,1+dp[k]);
            }
        }    
        return dp[i] = ans;
    }
    int[][] grid;
    
    public void f(int[][] grid,int i,int j){
        
    }
    public static void main(String[] args) {
        
    }
}
