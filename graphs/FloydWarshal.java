import java.util.*;
public class FloydWarshal{

    public void f(int[][] mat){
          int n = mat.length;
          for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == -1) mat[i][j] = Integer.MAX_VALUE;
                if(i == j) mat[i][j] = 0;
            }
          }

          for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    mat[i][j] = Math.min(mat[i][j],mat[i][k] + mat[k][j]);
                }
            }
          }

          for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
               if(mat[i][j] == Integer.MAX_VALUE) mat[i][j] = -1;
            }
          }

          //If at all soemthing ahs a negative value , then tat means negative cycle exists .
    }

    public static void BellManFord(int[][] edges,int n){
      int[] dist = new int[n];
      Arrays.fill(dist,Integer.MIN_VALUE);
      dist[0] = 0;

      for(int i = 0;i<n;i++){
        for(int j = 0;j<edges.length;j++){
          int u = edges[j][0] , v = edges[j][1] , wt = edges[j][2];
          if(dist[u] != Integer.MIN_VALUE && dist[u] + wt < dist[v]){
            dist[v] = dist[u] + wt;
          }
        }
      }

      //Reolax the nth time 
      for(int[] edge : edges){
        int u = edge[0] , v = edge[1] , wt = edge[2];
          if(dist[u] != Integer.MIN_VALUE && dist[u] + wt < dist[v]){
           // Negative cycle exists
          }
      }

    }

    public static void main(String[] args) {
        
    }
}