public class Practice {
    int[] arr;
    int[] sum;
    int N , n;
    int[] dp;
    public int NSlimes(int l,int r){    
        
        if(l == r) return 0;
        int ans = 0;
        for(int k = l;k<=r;k++){
            ans = Math.min(ans,NSlimes(l, k) + NSlimes(k+1, r) + sum[r] - sum[l]);    
        }    
        return ans;
    }

    public boolean KStones(int stones){
         if(stones == 0) return false;
         if(dp[stones] != -1) return dp[stones] == 1;
        for(int i = 0;i<n;i++){
            if(arr[i] > stones) break;
            if(!KStones(stones-arr[i])){
                dp[stones] = 1;
                return true;
            }
        }
        dp[stones] = 0;
        return false;
    }

    public int LDeque(int[] arr,int l,int r){
        
        //If u take one, the other will try to minimze u

        int ans = 0;
        // Take l
        int left = arr[l] +  Math.min(LDeque(arr, l+1, r),LDeque(arr, l+1, r));
        //Take r
        int right = arr[r] + Math.min(LDeque(arr, l, r-1),LDeque(arr, l, r-1));
        ans = Math.max(left,right);

        return ans;
    }

    public void gameDP(){
        
    }
    public static void main(String[] args) {
        
    }
}
