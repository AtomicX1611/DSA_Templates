import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MST {

    class Pair{
        int node;
        int distance;
        public Pair(int node,int dist){
            this.node = node;
            distance = dist;
        }
    }

    public void Prims(ArrayList<ArrayList<Pair>> graph,int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (X,Y) -> X.distance - Y.distance
        );

        int[] vis = new int[n];

        pq.add(new Pair(0,0));  
        int sum = 0;
        while(pq.size() > 0){
         Pair pair = pq.remove();
         int u = pair.node , wt = pair.distance;
         if(vis[u] == 1) continue;
         sum += wt;
         for(Pair it: graph.get(u)){
            if(vis[it.node] != 1) { 
                pq.add(new Pair(it.node,it.distance));
            }
         }

        }
    }
        
    public static void main(String[] args) {
        
    }
}
