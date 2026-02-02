class Solution {
    private void bfs(List<List<Integer>> adj,List<Integer> res,boolean[] vis,int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s]=true;
        while(!q.isEmpty()){
            int x= q.poll();
            res.add(x);
            for(int i:adj.get(x)){
                if(!vis[i])
                {
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!vis[i])
                bfs(adj,res,vis,i);
        }
        return res;
    }
}

