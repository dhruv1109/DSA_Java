// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class Solution {
    class pair{
        int node;
        int parent;
        pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    
    private boolean checkForCycle(int s,List<List<Integer>> adj, boolean[] vis){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(s,-1));
        vis[s] = true; 
        while(!q.isEmpty()){
            pair p = q.poll();
            int node = p.node;
            int parent = p.parent;
            for(int x : adj.get(node)){
                if(!vis[x]){
                    vis[x] = true;
                    q.add(new pair(x,node));
                } else if(x != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
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
                 if (checkForCycle(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}