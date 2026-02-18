// https://leetcode.com/problems/possible-bipartition/description/

class Solution {
    private boolean dfs(int s, int cur,int[] color,List<List<Integer>> adj){
        color[s]=cur;
        for(int x:adj.get(s)){
            if(color[x]==-1){
                if(dfs(x,1-cur,color,adj)==false)
                    return false;
            } else if(color[x]==cur)
                return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i =0;i<dislikes.length;i++){
            int x = dislikes[i][0]-1;
            int y = dislikes[i][1]-1;
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i =0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,adj)==false)
                    return false;
            }
        }
        return true;
    }
}