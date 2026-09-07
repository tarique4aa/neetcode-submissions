class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        String s = "";
        solve(n, n, s);
        return ans;
    }

    public void solve(int o, int c, String s) {
        if (o == 0 && c == 0) {
            ans.add(s);
        }
       // Add '(' if we still have open brackets available
        if (o > 0) {
            solve(o - 1, c, s + "(");
        }

        // Add ')' if remaining close brackets exceed remaining open brackets
        if (c > o) {
            solve(o, c - 1, s + ")");
        }
        return;
    }
}
