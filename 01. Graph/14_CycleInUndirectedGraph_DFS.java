// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class Solution {
    
    private boolean checkForCycle(int node, int parent,List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(int x: adj.get(node)){
            if(!vis[x]){
                if(checkForCycle(x,node,adj,vis) == true)
                    return true;
            } else if(x != parent){
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                 if (checkForCycle(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}