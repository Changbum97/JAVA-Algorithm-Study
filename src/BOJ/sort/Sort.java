package BOJ.sort;

public class Sort {

    static int[] brr;

    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 1, 5, 3, 4, 9, 8, 6};
        int[] answer = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(test(bubbleSort(arr, arr.length), answer));

        arr = new int[]{7, 2, 1, 5, 3, 4, 9, 8, 6};
        System.out.println(test(insertionSort(arr, arr.length), answer));

        arr = new int[]{7, 2, 1, 5, 3, 4, 9, 8, 6};
        System.out.println(test(selectionSort(arr, arr.length), answer));

        brr = new int[]{7, 2, 1, 5, 3, 4, 9, 8, 6};
        quickSort(0, brr.length - 1);
        System.out.println(test(brr, answer));
    }

    static boolean test(int[] result, int answer[]) {
        if (result.length != answer.length) return false;

        for (int i = 0 ; i < result.length ; i ++) {
            if (result[i] != answer[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 근접한 두 수를 순서대로 비교하여 오른쪽 수가 왼쪽 수보다 작으면 교환
     * 한 번 수행 후 가장 끝 수 확정
     */
    private static int[] bubbleSort(int[] arr, int n) {
        for (int i = n - 1 ; i >= 1 ; i --) {
            for (int j = 0 ; j < i ; j ++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * i 번째 숫자가 들어갈 위치를 찾아 삽입
     */
    private static int[] insertionSort(int[] arr, int n) {
        for (int i = 1 ; i < n ; i ++) {
            int temp = arr[i];
            int j;
            for (j = i - 1 ; j >= 0 ; j --) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    /**
     * 가장 작은 값을 찾아 배열의 첫번째 값과 교체
     */
    private static int[] selectionSort(int[] arr, int n) {
        for (int i = 0 ; i < n - 1 ; i ++) {
            int minIdx = i;
            for (int j = i + 1 ; j < n ; j ++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     *
     */
    private static void quickSort(int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        int pivot = brr[mid];
        int left = start;
        int right = end;

        while (left <= right) {
            while(brr[left] < pivot) left ++;
            while(brr[right] > pivot) right --;

            if (left <= right) {
                int temp = brr[right];
                brr[right] = brr[left];
                brr[left] = temp;
                left ++;
                right --;
            }
        }

        if (start < right) quickSort(start, right);
        if (left < end) quickSort(left, end);
    }
}
