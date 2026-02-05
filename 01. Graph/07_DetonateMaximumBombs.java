// https://leetcode.com/problems/detonate-the-maximum-bombs/description/

class Solution {
    private int dfs(int[][] bombs, boolean[] vis, List<List<Integer>> adj, int s){
        vis[s]=true;
        int count =1;
        for(int x: adj.get(s)){
            if(!vis[x])
                count +=dfs(bombs,vis,adj,x);
        }
        return count;
    }
    public int maximumDetonation(int[][] bombs) {
        int n= bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r = bombs[i][2];
            for(int j=0;j<n;j++){
                if(i==j) continue;

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x1-x2;
                long dy = y1-y2;

                if(dx*dx + dy*dy <= r*r){
                    adj.get(i).add(j);
                }
            }
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            boolean[] vis = new boolean[n];
            if(!vis[i]){
            int count = dfs(bombs,vis,adj,i);
            ans = Math.max(ans,count);
            } 
        }
        return ans;
    }
}