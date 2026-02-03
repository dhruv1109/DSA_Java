// https://leetcode.com/problems/rotting-oranges/description/

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh=0,time=-1;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[] {i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)
            return 0;

        int[] dx= {1,0,0,-1};
        int[] dy= {0,1,-1,0};

        while(!q.isEmpty()){
            int loop = q.size();
            while(loop-- > 0){
                int[] val=q.poll();
                for(int i=0;i<4;i++){
                    int x= val[0] + dx[i];
                    int y= val[1] + dy[i];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        fresh--;
                        q.add(new int[]{x,y});
                    }
                }
            }
            time++;
        }
        return fresh==0?time:-1;
    }
}