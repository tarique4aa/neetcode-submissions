class Solution {
    int n;
    int[] par;
    int find(int node) {
        if (par[node] == node) {
            return node;
        }
        return find(par[node]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        par = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            par[i] = i;
        }
        for (int[] e : edges) {
            int la = find(e[0]);
            int lb = find(e[1]);
            if (la == lb)
                return e;
            else {
                par[lb] = la;
            }
        }
        return new int[0];
    }
}
