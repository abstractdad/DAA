import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.println("Enter number of elements in the array:");
        int n = sc.nextInt();
        int[] originalArray = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            originalArray[i] = sc.nextInt();
        }

        // Sorting algorithms
        int[] arr1 = originalArray.clone();
        RecursiveSelectionSort.selectionSort(arr1, 0);
        System.out.println("1. Recursive Selection Sort: " + Arrays.toString(arr1));

        int[] arr2 = originalArray.clone();
        IterativeSelectionSort.selectionSort(arr2);
        System.out.println("2. Iterative Selection Sort: " + Arrays.toString(arr2));

        int[] arr3 = originalArray.clone();
        RecursiveInsertionSort.insertionSort(arr3, arr3.length);
        System.out.println("3. Recursive Insertion Sort: " + Arrays.toString(arr3));

        int[] arr4 = originalArray.clone();
        IterativeInsertionSort.insertionSort(arr4);
        System.out.println("4. Iterative Insertion Sort: " + Arrays.toString(arr4));

        int[] arr5 = originalArray.clone();
        MergeSort.mergeSort(arr5, 0, arr5.length - 1);
        System.out.println("5. Merge Sort: " + Arrays.toString(arr5));

        int[] arr6 = originalArray.clone();
        QuickSort.quickSort(arr6, 0, arr6.length - 1);
        System.out.println("6. Quick Sort: " + Arrays.toString(arr6));

        // Input for unweighted graph (BFS, DFS)
        System.out.println("Enter number of nodes for BFS/DFS graph:");
        int nodes = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        System.out.println("Enter adjacency list (space-separated neighbors per line):");
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
            String line = sc.nextLine();
            if (line.isEmpty()) line = sc.nextLine(); // Consume newline
            for (String s : line.split(" ")) {
                if (!s.isEmpty()) adjList.get(i).add(Integer.parseInt(s));
            }
        }

        System.out.println("7. BFS:");
        BFS.bfs(0, adjList);

        System.out.println("8. DFS:");
        DFS.startDFS(0, adjList);

        // Input for Dijkstra's algorithm
        System.out.println("Enter number of nodes for Dijkstra graph:");
        int dijkstraNodes = sc.nextInt();
        List<List<int[]>> weightedAdjList = new ArrayList<>();
        System.out.println("Enter weighted adjacency list (format: node weight for each neighbor):");
        for (int i = 0; i < dijkstraNodes; i++) {
            weightedAdjList.add(new ArrayList<>());
            String line = sc.nextLine();
            if (line.isEmpty()) line = sc.nextLine(); // Consume newline
            String[] tokens = line.split(" ");
            for (int j = 0; j < tokens.length - 1; j += 2) {
                int dest = Integer.parseInt(tokens[j]);
                int weight = Integer.parseInt(tokens[j + 1]);
                weightedAdjList.get(i).add(new int[]{dest, weight});
            }
        }

        System.out.println("9. Dijkstra:");
        Dijkstra.dijkstra(0, weightedAdjList, dijkstraNodes);

        // Input for Bellman-Ford algorithm
        System.out.println("Enter number of edges for Bellman-Ford:");
        int edgeCount = sc.nextInt();
        List<BellmanFord.Edge> edges = new ArrayList<>();
        System.out.println("Enter edges in format: source destination weight");
        for (int i = 0; i < edgeCount; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new BellmanFord.Edge(u, v, w));
        }

        System.out.println("10. Bellman-Ford:");
        BellmanFord.bellmanFord(edges, dijkstraNodes, 0);
    }
}
