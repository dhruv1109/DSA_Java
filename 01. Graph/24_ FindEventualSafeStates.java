// https://leetcode.com/problems/find-eventual-safe-states/description/

class Solution {
    private boolean dfs(int s,boolean[] vis,boolean[] pathvis, int[][] graph){
        vis[s]=true;
        pathvis[s]=true;
        for(int adj: graph[s]){
            if(!vis[adj]){
                if(dfs(adj,vis,pathvis,graph)==true)
                    return true;
            } else if(pathvis[adj]){
                return true;
            }
        }
        pathvis[s]=false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathvis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,pathvis,graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!pathvis[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}