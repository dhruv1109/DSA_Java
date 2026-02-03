// https://leetcode.com/problems/flood-fill

class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int curr=image[sr][sc];
        if(curr==color)
            return image;
        
        int m=image.length;
        int n=image[0].length;

        int[] dx={1,0,0,-1};
        int[] dy={0,1,-1,0};

        Queue<pair> q= new LinkedList<>();
        q.add(new pair(sr,sc));
        image[sr][sc]=color;

        while(!q.isEmpty()){
            pair p=q.poll();
            for(int i=0;i<4;i++){
                int x=p.row + dx[i];
                int y=p.col + dy[i];
                if(x>=0 && y>=0 && x<m && y<n && image[x][y]==curr){
                    q.add(new pair(x,y));
                    image[x][y] = color;
                }
            }
        }
        return image;
    }
}