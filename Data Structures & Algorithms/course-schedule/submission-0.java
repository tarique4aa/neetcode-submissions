class Solution {
    public boolean canFinish(int nc, int[][] p) {
        int[] in = new int[nc];
        List<List<Integer>> adj = new ArrayList<>();
        int n = p.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nc; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            adj.get(p[i][1]).add(p[i][0]);
            in[p[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nc; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int f = q.poll();
            ans.add(f);
            List<Integer> childs = adj.get(f);
            for (Integer c : childs) {
                in[c]--;
                if (in[c] == 0) {
                    q.add(c);
                }
            }
        }

        return ans.size() == nc;
    }
}
