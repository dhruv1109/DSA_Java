// https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    private boolean dfs(int s, int cur, int[][] graph, int[] color)
    {
        color[s] = cur;
        for(int x:graph[s]){
            if(color[x]==-1){
                if(dfs(x,1-cur,graph,color)==false)
                    return false;
            } else if(color[x]==cur)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] color = new int[m];
        Arrays.fill(color,-1);
        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(dfs(i,0,graph,color)==false)
                    return false;
            }
        }
        return true;
    }
}