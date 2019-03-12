import java.util.Arrays;

public class QuickSortDemo {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition1(int[] arr, int left, int right) {
        int t = arr[left];

        while (left < right) {
            while (left < right && arr[right] > t) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < t) {
                left++;
                arr[right] = arr[left];
            }
        }
        arr[left] = t;
        return left;
    }

    public static int partition2(int[] arr, int left, int right) {
        int t = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < t) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, left, j);
        return j;
    }

    public static int partition3(int[] arr, int left, int right) {
        int t = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && arr[i] < t) {
                i++;
            }
            while (j >= left && arr[j] > t) {
                j--;
            }
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j++;
        }
        swap(arr, left, j);
        return j;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partition3(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 15, 14, 13, 12};

        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
