// https://leetcode.com/problems/as-far-from-land-as-possible/description/

class Solution {
    class pair{
        int row;
        int col;
        pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    q.add(new pair(i,j));
            }
        }

    if(q.size()==0 || q.size()==n*n)
        return -1;

    int dist=-1;
    int[] dx={1,0,0,-1};
    int[] dy={0,1,-1,0};

    while(!q.isEmpty()){
        int size=q.size();
        while(size-- > 0){
            pair p =q.poll();
            for(int i=0;i<4;i++){
                int x= p.row + dx[i];
                int y=p.col + dy[i];

                if(x>=0 && y>=0 && x<n && y<n && grid[x][y]==0){
                    grid[x][y]=1;
                    q.add(new pair(x,y));
                }
            }
        }
        dist++;
    }
    return dist;
    }
}