public class ST{

    public class Tree{
        int[] seg;
        int[] arr;
        Tree(int nums[]){
            int n = nums.length;
            arr = nums;
            seg = new int[4*n];
            
        }
        public void build(int i,int l,int r){
           if(l == r) {
            seg[i] = arr[l];
            return;
           }
           int mid = (r+l)/2;
           build(i*2, l, mid);
           build(i*2+1, mid+1, r);
           seg[i] = Math.max(seg[2*i],seg[2*i+1]);
        }

        public int query(int i,int low,int high,int l,int r){
            if(low>=l && high<=r) return seg[i];
            if(low>r || high<l) return Integer.MIN_VALUE;

            int mid = (low+high)/2;
            int left = query(2*i,low,mid,l,r);
            int right = query(2*i+1, mid+1, high, left, r);
            return Math.max(left,right);
        }
    }
    public static void main(String[] args) {
        
    }
}