// https://leetcode.com/problems/flood-fill

class Solution {
    
    private void dfs(int sr, int sc, int curr, int color, int[][] image, int m, int n){
        image[sr][sc] = color;

        int[] dx={1,0,0,-1};
        int[] dy={0,1,-1,0};

        for(int i=0;i<4;i++){
            int x=sr+dx[i];
            int y=sc+dy[i];
            if(x>=0 && y>=0 && x<m && y<n && image[x][y]==curr)
                dfs(x,y,curr,color,image,m,n);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int curr=image[sr][sc];
        if(curr==color)
            return image;
        
        int m=image.length;
        int n=image[0].length;
        dfs(sr,sc,curr,color,image,m,n);
        return image;
    }
}