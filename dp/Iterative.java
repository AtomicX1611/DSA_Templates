public class Iterative {
    
    int[][] dp;
    //Game DP
    public int solve(int x,int y){

        if(x == 0 && y == 0) return 0;
        
        if(dp[x][y] != -1) return dp[x][y];

        int ans = 0;
        for(int z = 0;z<=x;z++){
            if(solve(z,y) == 0){
                ans = 1;
                break;
            }
        }

        for(int z = 0;z<=y;z++){
            if(solve(x,z) == 0){
                ans = 1;
                break;
            }
        }
        
        for(int z = 1;z<=Math.min(x,y);z++){
            if(solve(x-z,y-z) == 0){
                ans = 1;
                break;
            }
        }
        
        return dp[x][y] = ans;
    }

    public void Iterative(){
        //Very Easy
        //Just go in the order of computaiton 
        //If u need the values , pre compute them first , that means 
        // go from the place where u need the base case first , then proceed like that .
    }
    public static void main(String[] args) {
        
    }
}
