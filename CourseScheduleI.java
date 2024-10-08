import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer> > g = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        // Create Adj list Graph
        for(int [] edge : pre) {
            g.get(edge[1]).add(edge[0]);
        }
        // Track on the whole, the visted nodes
        boolean[] vis = new boolean[n];
        // Track during the dfs started from particular node
        boolean[] curStack = new boolean[n];

        // Start from every index, and check if cycle exists
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                // If dfs returns true, cycle exists, returns immediately
                if(dfs(i, g, vis, curStack))
                    return false;
            }
        }
        // Cycle doesn't exists
        return true;
    }

    private boolean dfs(int i, List<List<Integer>> g, boolean[] vis, boolean[] curStack) {
        // Mark both the array index true
        vis[i] = true;
        curStack[i] = true;

        for(int j : g.get(i)) {
            if(!vis[j]) {
                // traverse every child if its not visited
                if(dfs(j, g, vis, curStack))
                    return true;
            } else if(curStack[j]) {
                // If its already visited and also in the current recursion stack, cycle found
                return true;
            }
        }
        // When the dfs call execution ends, we need to reset the curr recursion stack
        curStack[i] = false;
        return false;
    }
}
