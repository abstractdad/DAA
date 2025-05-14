import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] originalArray = {64, 25, 12, 22, 11};

        // 1. Recursive Selection Sort
        int[] arr1 = originalArray.clone();
        RecursiveSelectionSort.selectionSort(arr1, 0);
        System.out.println("1. Recursive Selection Sort: " + Arrays.toString(arr1));

        // 2. Iterative Selection Sort
        int[] arr2 = originalArray.clone();
        IterativeSelectionSort.selectionSort(arr2);
        System.out.println("2. Iterative Selection Sort: " + Arrays.toString(arr2));

        // 3. Recursive Insertion Sort
        int[] arr3 = originalArray.clone();
        RecursiveInsertionSort.insertionSort(arr3, arr3.length);
        System.out.println("3. Recursive Insertion Sort: " + Arrays.toString(arr3));

        // 4. Iterative Insertion Sort
        int[] arr4 = originalArray.clone();
        IterativeInsertionSort.insertionSort(arr4);
        System.out.println("4. Iterative Insertion Sort: " + Arrays.toString(arr4));

        // 5. Merge Sort
        int[] arr5 = originalArray.clone();
        MergeSort.mergeSort(arr5, 0, arr5.length - 1);
        System.out.println("5. Merge Sort: " + Arrays.toString(arr5));

        // 6. Quick Sort
        int[] arr6 = originalArray.clone();
        QuickSort.quickSort(arr6, 0, arr6.length - 1);
        System.out.println("6. Quick Sort: " + Arrays.toString(arr6));

        // Graph data setup for BFS, DFS, Dijkstra, Bellman-Ford
        List<List<Integer>> adjList = Arrays.asList(
            Arrays.asList(1, 2),       // 0
            Arrays.asList(0, 3),       // 1
            Arrays.asList(0, 3),       // 2
            Arrays.asList(1, 2, 4),    // 3
            Arrays.asList(3)           // 4
        );

        System.out.println("7. BFS:");
        BFS.bfs(0, adjList);

        System.out.println("8. DFS:");
        DFS.startDFS(0, adjList);

        // Dijkstra graph (List of [node, weight])
        List<List<int[]>> weightedAdjList = Arrays.asList(
            Arrays.asList(new int[]{1, 4}, new int[]{2, 1}),   // 0
            Arrays.asList(new int[]{3, 1}),                    // 1
            Arrays.asList(new int[]{1, 2}, new int[]{3, 5}),   // 2
            Arrays.asList()                                    // 3
        );

        System.out.println("9. Dijkstra:");
        Dijkstra.dijkstra(0, weightedAdjList, weightedAdjList.size());

        // Bellman-Ford edge list
        List<BellmanFord.Edge> edges = Arrays.asList(
            new BellmanFord.Edge(0, 1, 4),
            new BellmanFord.Edge(0, 2, 1),
            new BellmanFord.Edge(2, 1, 2),
            new BellmanFord.Edge(1, 3, 1),
            new BellmanFord.Edge(2, 3, 5)
        );

        System.out.println("10. Bellman-Ford:");
        BellmanFord.bellmanFord(edges, 4, 0);
    }
}
