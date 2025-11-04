
package bits;

public class BIt_Man {

    public void Swap(int a,int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b; 
    }

    public void ithSet(int x,int i){
        if((x & (1 << i)) == 1) System.out.println("Set");
        if((1 & (x >> i)) == 1) System.out.println("Set");
    }
    public static void main(String[] args) {
        
    }
}
