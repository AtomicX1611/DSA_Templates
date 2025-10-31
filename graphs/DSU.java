import java.util.*;

public class DSU {
    class DS{
        List<Integer> size = new ArrayList<>();
        List<Integer> par = new ArrayList<>();
        public DS(int n){
            for(int i = 0;i<=n;i++) {
                size.add(1);
                par.add(i);
            } 
        }
        public int findUPar(int u){
         if(u == par.get(u)) return u;
         int uPar = findUPar(par.get(u));
         par.set(u,uPar);
         return uPar;
        }
        public void UnionBySize(int u,int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_u == ulp_v) return;
            if(size.get(ulp_u) < size.get(ulp_v)){
                par.set(ulp_u,ulp_v);
                par.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
            }else{
                 par.set(ulp_v,ulp_u);
                par.set(ulp_u,size.get(ulp_v) + size.get(ulp_u));
            }
        }
    }

    

      class Edge implements Comparable<Edge>{
      
        int src,dest,wt;
        public Edge(int src,int dest,int wt){
            this.src = src ;
            this.dest = dest;
            this.wt = wt;   
        }
        public int compareTo(Edge e2){
             return this.wt - e2.wt;
        }

    }
       public void KrushKal(int V){
            List<Edge> edges = new ArrayList<>(); 
            // Cosntruct the edges list from the graph

            Collections.sort(edges);
            DS ds = new DS(V);
            int mST = 0;
            for(Edge edge : edges){
                int u = edge.src , v = edge.dest , wt = edge.wt;
                if(ds.findUPar(u) != ds.findUPar(v)){
                   ds.UnionBySize(u, v);
                   mST += wt;     
                }
            }
            // U got the MST sum . 
            // If u want the edges , just add the edges in a new list  
        }

    public static void main(String[] args) {
        
    }
}
