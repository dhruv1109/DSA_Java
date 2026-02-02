public class Solution {
    private void dfs(int s, List<List<Integer>> adj, boolean[] vis, List<Integer> res){
        vis[s]=true;
        res.add(s);
        for(int x: adj.get(s)){
            if(!vis[x])
                dfs(x,adj,vis,res);
        }
    }
    
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
      boolean[]vis = new boolean[V];
      List<Integer> res = new ArrayList<>();
      for(int i=0;i<V;i++){
        if(!vis[i])
            dfs(i,adj,vis,res);
      }
      return res;
    }
}