public class RecursiveSelectionSort {
    static void selectionSort(int[] arr, int start) {
        if (start >= arr.length - 1) return;
        int minIdx = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) minIdx = i;
        }
        int temp = arr[start];
        arr[start] = arr[minIdx];
        arr[minIdx] = temp;
        selectionSort(arr, start + 1);
    }
}
