// https://leetcode.com/problems/number-of-provinces/description/

class Solution {

    private void dfs(List<List<Integer>> adj, boolean[] vis, int s){
        vis[s]=true;
        for(int i: adj.get(s)){
            if(!vis[i])
                dfs(adj,vis,i);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<isConnected.length; i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[isConnected.length];
        int ans=0;

        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                ans++;
                dfs(adj,vis,i);
            }
        }
        return ans;
    }
}