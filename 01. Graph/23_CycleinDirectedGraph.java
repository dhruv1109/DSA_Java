// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class Solution {
    private boolean dfs(int s,ArrayList<Integer>[] graph, 
                        boolean[] vis, boolean[] pathvis){
        vis[s]=true;
        pathvis[s]=true;
        
        for(int x:graph[s]){
            if(!vis[x]){
                if(dfs(x,graph,vis,pathvis)==true)
                    return true;
            } else if(pathvis[x]){
                return true;
            }
        }
        pathvis[s]=false;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e:edges){
            int x = e[0];
            int y = e[1];
            graph[x].add(y);
        }
        
        boolean[] vis= new boolean[V];
        boolean[] pathvis= new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,graph,vis,pathvis)==true)
                    return true;
            }
        }
        return false;
    }
}