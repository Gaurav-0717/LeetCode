class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0] , b[0]));
        ans.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] last = ans.get(ans.size()-1);
            int[] current = intervals[i];

            if(current[0]<=last[1]){
                last[1]=Math.max(last[1],current[1]);
            }else{
                ans.add(current);
            }
        }

        return ans .toArray(new int[ans.size()][]);
    }
}