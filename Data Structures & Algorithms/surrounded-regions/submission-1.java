
class Solution {
    int n, m;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Mark border-connected 'O's as 'T'
    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // Mark as visited & safe

        for (int[] d : dir) {
            dfs(board, i + d[0], j + d[1]);
        }
    }

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;

        // 1. Run DFS on all border cells
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][m - 1] == 'O') dfs(board, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[n - 1][j] == 'O') dfs(board, n - 1, j);
        }

        // 2. Flip remaining 'O' to 'X', and restore 'T' back to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
