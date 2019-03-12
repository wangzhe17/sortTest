import java.util.Arrays;

public class SortTest {
    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partition2(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (right > left) {
            while (right > left && arr[right] > tmp) {
                right--;
            }
            arr[left] = arr[right];

            while (right > left && arr[left] < tmp) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = tmp;
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[j] >= arr[i]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (int l = 0; l < tmp.length; l++) {
            arr[l + left] = tmp[l];
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i])
                    swap(arr, i, j);
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > t; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = t;
        }
    }

    private static int partition2(int[] arr, int left, int right) {
        int t = arr[left];
        int j = left;
        for (int i = j + 1; i <= right; i++) {
            if (arr[i]<t){
                swap(arr,i,j+1);
                j++;
            }
        }
        swap(arr,left,j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 15, 14, 13, 12};

        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
