public class PrintTargetSubset{

   public static int rec(int i,int left,int[] arr){
        if(left < 0) return 0;
        if(i == arr.length){
            if(left == 0) return 1;
            else return 0;
        }
        int ans = 0;
        if(rec(i+1,left,arr) == 1) ans = 1;
        else if(rec(i+1,left-arr[i],arr) == 1) ans = 1;
        return ans;
    }

    //Print solutions
    public void printset(int i,int left,int[] arr){
        if(i == arr.length + 1) return ;

        if(rec(i+1,left,arr) == 1) {
            printset(+1, left, arr);
        }
        else if(rec(i+1,left-arr[i],arr) == 1) {
            System.out.println(" "+arr[i]);
        }
    }
    public static void main(String[] args) {
        // Make sure u can cache dp states across queries .
        // So dont use target if targert changes across nultiple queries .
        // Use the fact that zero sum should be remaining
        int n = 0 ;
        int[] queries = new int[n];
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            int ans = rec(0,queries[i],arr);
        }
    }
}