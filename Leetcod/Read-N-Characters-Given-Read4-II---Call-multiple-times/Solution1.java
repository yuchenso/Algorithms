/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    Queue<Character> queue = new LinkedList<Character>();
    public int read(char[] buf, int n) {
        int bufIndex = 0;
        boolean end = false;
        while (!end && bufIndex < n) {
            char[] buffer = new char[4];
            int readNum = read4(buffer);
            for (int i = 0; i < readNum; i++) queue.add(buffer[i]);
            if (queue.size() < 4) end = true;
            while (!queue.isEmpty() && bufIndex < n) {
                buf[bufIndex] = queue.poll();
                bufIndex++;
            }
        }
        return bufIndex;
    }
}
