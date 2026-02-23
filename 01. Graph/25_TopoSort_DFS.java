// https://www.geeksforgeeks.org/problems/topological-sort/1

class Solution {
    private void dfs(int s,Stack<Integer> st,boolean[] vis,
    List<ArrayList<Integer>> adj){
        vis[s]=true;
        for(int x : adj.get(s)){
            if(!vis[x]){
                dfs(x,st,vis,adj);
            }
        }
        st.add(s);
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int n = edges.length;
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            adj.get(x).add(y);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,st,vis,adj);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
        
    }
}