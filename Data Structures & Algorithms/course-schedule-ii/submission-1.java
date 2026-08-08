class Solution {
    public int[] findOrder(int nc, int[][] p) {
        int[] in = new int[nc];
        int[] ans = new int[nc];
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < nc; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] ed : p) {
            adj.get(ed[1]).add(ed[0]);
            in[ed[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nc; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        
        int idx = 0;
        while (!q.isEmpty()) {
            int f = q.poll();
            ans[idx++] = f;
            
            for (Integer c : adj.get(f)) {
                in[c]--;
                if (in[c] == 0) {
                    q.add(c);
                }
            }
        }
        
        // If idx == nc, all courses were processed successfully.
        // Otherwise, a cycle exists, so return an empty array.
        return idx == nc ? ans : new int[0];
    }
}