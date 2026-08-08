

class Solution {
    private int rows, cols;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.rows = heights.length;
        this.cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // 1. Run DFS for Top and Bottom borders
        for (int c = 0; c < cols; c++) {
            // Top border -> Pacific
            dfs(0, c, pacific, heights[0][c]);
            // Bottom border -> Atlantic
            dfs(rows - 1, c, atlantic, heights[rows - 1][c]);
        }

        // 2. Run DFS for Left and Right borders
        for (int r = 0; r < rows; r++) {
            // Left border -> Pacific
            dfs(r, 0, pacific, heights[r][0]);
            // Right border -> Atlantic
            dfs(r, cols - 1, atlantic, heights[r][cols - 1]);
        }

        // 3. Collect cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int prevHeight) {
        // Boundary check, visited check, and height flow check (must go uphill or equal height)
        if (r < 0 || r >= rows || c < 0 || c >= cols || 
            ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        // Mark cell as reachable
        ocean[r][c] = true;

        // Explore all 4 cardinal directions
        dfs(r + 1, c, ocean, heights[r][c]); // Down
        dfs(r - 1, c, ocean, heights[r][c]); // Up
        dfs(r, c + 1, ocean, heights[r][c]); // Right
        dfs(r, c - 1, ocean, heights[r][c]); // Left
    }
}