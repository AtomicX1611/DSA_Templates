package Templates.greedy;

public class Greedy {

    public void leastSumThatIsNotPresent(int[] arr){
         Arrays.sort(arr);
         int sum = 0;
         int ans = 0;
         for(int i = 0;i<arr.length;i++){
            if(preSum + 1>= arr[i]) preSum+= arr;
            else {
                ans += preSum + 1;
                break;
            }
         }   
    }
    public static void main(String[] args) {
        
    }
}
