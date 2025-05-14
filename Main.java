import java.util.*;

public class Main {

    // ---------- 1. Recursive Selection Sort ----------
    static void recursiveSelectionSort(int[] arr, int start) {
        if (start >= arr.length - 1) return;
        int minIdx = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) minIdx = i;
        }
        int temp = arr[start];
        arr[start] = arr[minIdx];
        arr[minIdx] = temp;
        recursiveSelectionSort(arr, start + 1);
    }

    // ---------- 2. Iterative Selection Sort ----------
    static void iterativeSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = temp;
        }
    }

    // ---------- 3. Recursive Insertion Sort ----------
    static void recursiveInsertionSort(int[] arr, int n) {
        if (n <= 1) return;
        recursiveInsertionSort(arr, n - 1);
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    // ---------- 4. Iterative Insertion Sort ----------
    static void iterativeInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; j--;
            }
            arr[j + 1] = key;
        }
    }

    // ---------- 5. Merge Sort ----------
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // ---------- 6. Quick Sort ----------
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    // ---------- 7. BFS ----------
    static void bfs(int start, List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            count++;
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println("\nTotal Nodes Visited: " + count);
    }

    // ---------- 8. DFS ----------
    static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, visited, adj);
        }
    }

    static void startDFS(int start, List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        dfs(start, visited, adj);
        int total = 0;
        for (boolean v : visited) if (v) total++;
        System.out.println("\nTotal Nodes Visited: " + total);
    }

    // ---------- 9. Dijkstra ----------
    static void dijkstra(int src, List<List<int[]>> adj, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            for (int[] edge : adj.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        System.out.println("Dijkstra from node " + src + ": " + Arrays.toString(dist));
    }

    // ---------- 10. Bellman-Ford ----------
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    }

    static void bellmanFord(List<Edge> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                System.out.println("Negative cycle detected!");
                return;
            }
        }
        System.out.println("Bellman-Ford from node " + src + ": " + Arrays.toString(dist));
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample array
        int[] arr = {64, 25, 12, 22, 11};

        // 1. Recursive Selection Sort
        int[] a1 = arr.clone();
        recursiveSelectionSort(a1, 0);
        System.out.println("1. Recursive Selection Sort: " + Arrays.toString(a1));

        // 2. Iterative Selection Sort
        int[] a2 = arr.clone();
        iterativeSelectionSort(a2);
        System.out.println("2. Iterative Selection Sort: " + Arrays.toString(a2));

        // 3. Recursive Insertion Sort
        int[] a3 = arr.clone();
        recursiveInsertionSort(a3, a3.length);
        System.out.println("3. Recursive Insertion Sort: " + Arrays.toString(a3));

        // 4. Iterative Insertion Sort
        int[] a4 = arr.clone();
        iterativeInsertionSort(a4);
        System.out.println("4. Iterative Insertion Sort: " + Arrays.toString(a4));

        // 5. Merge Sort
        int[] a5 = arr.clone();
        mergeSort(a5, 0, a5.length - 1);
        System.out.println("5. Merge Sort: " + Arrays.toString(a5));

        // 6. Quick Sort
        int[] a6 = arr.clone();
        quickSort(a6, 0, a6.length - 1);
        System.out.println("6. Quick Sort: " + Arrays.toString(a6));

        // 7. BFS
        System.out.println("7. BFS:");
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) graph.add(new ArrayList<>());
        graph.get(0).addAll(List.of(1, 2));
        graph.get(1).add(3);
        graph.get(2).add(4);
        bfs(0, graph);

        // 8. DFS
        System.out.print("8. DFS (from node 0):\n");
        startDFS(0, graph);

        // 9. Dijkstra
        System.out.println("9. Dijkstra:");
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < 5; i++) adjList.add(new ArrayList<>());
        adjList.get(0).add(new int[]{1, 4});
        adjList.get(0).add(new int[]{2, 1});
        adjList.get(2).add(new int[]{1, 2});
        adjList.get(1).add(new int[]{3, 1});
        adjList.get(2).add(new int[]{3, 5});
        dijkstra(0, adjList, 5);

        // 10. Bellman-Ford
        System.out.println("10. Bellman-Ford:");
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 1));
        edges.add(new Edge(2, 1, 2));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(2, 3, 5));
        bellmanFord(edges, 5, 0);
    }
}
