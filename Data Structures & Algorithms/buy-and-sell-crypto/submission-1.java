class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;
        int ans = 0;

        int[] mi = new int[n];
        int[] ma = new int[n];

        mi[0] = p[0];
        for (int i = 1; i < n; i++) {
            mi[i] = Math.min(mi[i - 1], p[i]);
        }

        ma[n - 1] = p[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ma[i] = Math.max(mi[i + 1], p[i]);
        }

        for(int i=0;i<n;i++){
            ans = Math.max(ans, ma[i]-mi[i]);
        }
        return ans;
    }
}
