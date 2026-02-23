// https://www.geeksforgeeks.org/problems/topological-sort/1

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int n = edges.length;
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[V];
        
        for(int i=0;i<n;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            adj.get(x).add(y);
            indegree[y]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int x = q.poll(); 
            ans.add(x);
            for(int it: adj.get(x)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        return ans;
    }
}