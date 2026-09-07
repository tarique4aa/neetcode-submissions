class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean isValid(int i, int j, char[][] board, boolean[][] vis) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j] == true;
    }
    public boolean dfs(char[][] board, boolean[][] vis, int i, int j, String word, String temp) {
        vis[i][j] = true;
        if (temp.equals(word))
            return true;

        for (int[] a : dir) {
            int x = a[0] + i;
            int y = a[1] + j;
            if (!isValid(x, y, board, vis) && dfs(board, vis, x, y, word, temp + board[x][y])) {
                return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, vis, i, j, word, String.valueOf(board[i][j]))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
