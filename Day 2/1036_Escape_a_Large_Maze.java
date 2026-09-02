import java.util.*;

public class Solution {

    private static final int LIMIT = 20000;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(b[0] + "," + b[1]);
        }

        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] end, Set<String> blockedSet) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start[0] + "," + start[1]);

        while (!queue.isEmpty() && visited.size() <= LIMIT) {
            int[] curr = queue.poll();

            if (curr[0] == end[0] && curr[1] == end[1]) {
                return true;
            }

            for (int[] d : DIRS) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];

                String key = x + "," + y;

                if (x >= 0 && y >= 0 && x < 1000000 && y < 1000000 &&
                    !blockedSet.contains(key) && !visited.contains(key)) {

                    queue.offer(new int[]{x, y});
                    visited.add(key);
                }
            }
        }

        // If we explored enough area → not enclosed
        return visited.size() > LIMIT;
    }
}