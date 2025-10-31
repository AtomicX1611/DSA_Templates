import java.util.*;

public class Advanced {

        public void dfs(ArrayList<ArrayList<Integer>> graph, Stack<Integer> stk,int curr,boolean[] vis){
            vis[curr] = true;
            for(int v : graph.get(curr)){
              if(!vis[v]) dfs(graph,stk,v,vis);
            }
            stk.push(curr);
        }

        public void dfs1(ArrayList<ArrayList<Integer>> graph,int curr,boolean[] vis){
               vis[curr] = true;
             for(int v : graph.get(curr)){
              if(!vis[v]) dfs1(graph,v,vis);
            }
        }

    
        public void Kosaraju(int n,ArrayList<ArrayList<Integer>> graph){
            // Strongly connected components .
            //Sort in stack  ,finishing time last comes first.
            Stack<Integer> stack = new Stack<>();
            boolean[] vis = new boolean[n];
            for(int i = 0;i<n;i++){
                if(vis[i]) dfs(graph, stack, i, vis);
            }
            
            //Reverse the graph.
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0;i<n;i++) adj.add(new ArrayList<>());

            for(int i = 0;i<n;i++){
                vis[i] = false;
                for(int v : adj.get(i)){
                    adj.get(v).add(i);
                }
            }
            //Now do dfs .
            int scc = 0;
            while(stack.isEmpty()){
              int node = stack.pop();
              if(vis[node]){
                dfs1(adj, node, vis);
                scc++;
              }
            }
        }
        
        private int timer = 1;
        public void dfsTarjan(int curr,int par,boolean[] vis,ArrayList<ArrayList<Integer>> graph,int[] tim,int[] low,List<List<Integer>> bridges){
          vis[curr] = true;
          tim[curr] = low[curr] = timer;
          timer++;
          
          for(int v : graph.get(curr)){
            if(v == par) continue;
            if(vis[v]){
                dfsTarjan(v, curr, vis, graph, tim, low, bridges);
                low[curr] = Math.min(low[curr],low[v]);     
                if(low[v] > tim[curr]){
                    bridges.add(Arrays.asList(v,curr));
                }
            }else{
                     low[curr] = Math.min(low[curr],low[v]);
            }
          }
        }

        public void BridgesInTarjan(){

        }

        public void ArticulationPoint(){
             
        }
    public static void main(String[] args) {
        
    }
}
