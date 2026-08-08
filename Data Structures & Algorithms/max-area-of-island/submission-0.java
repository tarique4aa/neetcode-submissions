class Solution {
    int n, m;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean isValid(int i, int j, int[][] grid, boolean[][] vis) {
        return i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 1 && !vis[i][j];
    }

    int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        int c = 1;
        for (int a = 0; a < dir.length; a++) {
            int cx = i + dir[a][0];
            int cy = j + dir[a][1];
            if (isValid(cx, cy, grid, vis)) {
                c += dfs(grid, cx, cy, vis);
            }
        }
        return c;
    }

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int x = dfs(grid, i, j, vis);
                    ans = Math.max(ans, x);
                }
            }
        }
        return ans;
    }
}
