class Solution {
    void dfs(List<List<Integer>> adj, boolean[] vis, int i) {
        vis[i] = true;
        for (Integer c : adj.get(i)) {
            if (!vis[c]) {
                dfs(adj, vis, c);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, vis, i);
                c++;
            }
        }
        return c;
    }
}
