class Solution {
    boolean dfs(List<List<Integer>> adj, int node, int par, boolean[] vis) {
        vis[node] = true;

        for (Integer child : adj.get(node)) {
            if (!vis[child]) {
                boolean ans = dfs(adj, child, node, vis);
                if (ans)
                    return true;
            } else if (vis[child] && child != par) {
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
       if (dfs(adj, 0, -1, vis)) {
            return false;
        }

        // Condition 3: Ensure all nodes are connected (all visited)
        for (boolean v : vis) {
            if (!v) return false;
        }
        return true;
    }
}
