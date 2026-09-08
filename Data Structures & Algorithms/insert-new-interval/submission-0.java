class Solution {
    public int[][] insert(int[][] l, int[] nl) {
        List<int[]> ans = new ArrayList<>();
        int n = l.length;
        int i = 0;
        while (i < n) {
            if (l[i][1] < nl[0]) {
               ans.add(new int[]{l[i][0], l[i][1]});
            } else if(l[i][0]>nl[1]){
                break;
            }else{
                 //merge
                nl[0] = Math.min(l[i][0], nl[0]);
                nl[1] = Math.max(l[i][1], nl[1]);
            }
            i++;
        }

        ans.add(new int[]{nl[0], nl[1]});
        while (i < n) {
            ans.add(new int[]{l[i][0], l[i][1]});
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
