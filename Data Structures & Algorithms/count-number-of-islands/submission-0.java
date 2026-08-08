class Solution {
    int n, m;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    boolean isValid(int i, int j, char[][] grid, boolean[][] vis) {
        return i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == '1' && !vis[i][j];
    }

    void dfs(char[][] grid, boolean[][] vis, int i, int j) {
        vis[i][j] = true;

        for (int a = 0; a < dir.length; a++) {
            int cx = i + dir[a][0];
            int cy = j + dir[a][1];

            if (isValid(cx, cy, grid, vis)) {
                dfs(grid, vis, cx, cy);
            }
        }
    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]== '1' && !vis[i][j]) {
                    dfs(grid, vis, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }
}
