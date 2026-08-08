class Solution {
    int inf = 2147483647;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int n, m;

    boolean isValid(int i, int j, int[][] grid) {
        return i >= 0 && j >= 0 && i < n && j < m && grid[i][j] != -1 && grid[i][j] != 0;
    }

    void dfs(int[][] grid, int i, int j, int c) {
        for (int a = 0; a < dir.length; a++) {
            int cx = i + dir[a][0];
            int cy = j + dir[a][1];
        
            if (isValid(cx, cy, grid) && grid[cx][cy] > c + 1) {
                grid[cx][cy] = c + 1;
                dfs(grid, cx, cy, c + 1);
            }
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }
}