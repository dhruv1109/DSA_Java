// https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    private boolean bfs(int s, int[][] graph, int[] color)
    {
        color[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int node = q.poll();
            int cur = color[node];
            for(int x: graph[node]){
                if(color[x]==-1){
                    color[x] = (cur == 1) ? 0 : 1; // 1-cur
                    q.add(x);
                }
                else if(color[x]==cur)
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] color = new int[m];
        Arrays.fill(color,-1);
        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(bfs(i,graph,color)==false)
                    return false;
            }
        }
        return true;
    }
}