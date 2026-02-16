// https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row.add(0);
                    q.add(new int[]{i, j});
                } else {
                    row.add(-1);
                }
            }
            dist.add(row);
        }

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n
                        && dist.get(nx).get(ny) == -1) {

                    dist.get(nx).set(ny, dist.get(x).get(y) + 1);
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }
}
