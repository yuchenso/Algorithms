public class Solution1 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            rst.add(newInterval);
            return rst;
        }
        
        Interval cur = newInterval;
        for (int i = 0; i < intervals.size(); i++) {
            Interval item = intervals.get(i);
            if (cur == null) {
                rst.add(item);
            }
            else if (cur.end < item.start) {
                rst.add(cur);
                rst.add(item);
                cur = null;
            }
            else if (cur.start > item.end) {
                rst.add(item);
            }
            else {
                cur.start = Math.min(cur.start, item.start);
                cur.end = Math.max(cur.end, item.end);
            }
        }
        if (cur != null) rst.add(cur);
        return rst;
    }
}
