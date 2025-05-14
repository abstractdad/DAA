import java.util.*;

public class DFS {
    static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, visited, adj);
        }
    }

    public static void startDFS(int start, List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        dfs(start, visited, adj);
        int totalVisited = 0;
        for (boolean v : visited) if (v) totalVisited++;
        System.out.println("\nTotal Nodes Visited: " + totalVisited);
    }
}
