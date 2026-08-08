

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // 1. Initialize queue with initial rotten oranges & count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh fruit exist, 0 minutes needed
        if (freshCount == 0) return 0;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minutes = 0;

        // 2. Multi-source BFS level-by-level
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size(); // process all oranges rotten at the current minute
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // mark as rotten
                        queue.offer(new int[] {nr, nc});
                        freshCount--; // decrement remaining fresh count
                    }
                }
            }
            minutes++;
        }

        // 3. Return result based on remaining fresh oranges
        return freshCount == 0 ? minutes : -1;
    }
}