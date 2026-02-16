// https://leetcode.com/problems/01-matrix/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        int d=0;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        while(!q.isEmpty()){
            int s = q.size();
            while(s-- > 0){
                int [] val = q.poll();
                int x = val[0];
                int y = val[1];
                dist[x][y] = d;
                for(int i=0;i<4;i++){
                    int newx = x + dx[i];
                    int newy = y + dy[i];
                    if(newx>=0 && newy>=0 && newx<m && newy<n && !vis[newx][newy]){
                        vis[newx][newy]= true;
                        q.add(new int[]{newx,newy});
                    }
                }
            }
            d++;
        }
        return dist;
    }
}