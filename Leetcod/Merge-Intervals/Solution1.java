public class Solution1 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return result;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.end < cur.start) {
                result.add(pre);
                pre = cur;
            }
            else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        result.add(pre);
        return result;
    }
}
