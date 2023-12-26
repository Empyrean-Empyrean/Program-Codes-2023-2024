class insertionSort {
    void insertionsort(int arr[]) {
        int j, val;
        for (int i = 1; i < arr.length; i++) {
            val = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = val;
        }
    }
}

public class binarySearch extends insertionSort {

    int binarysearch(int a[], int n, int data) {
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (data == a[mid]) {
                return mid;
            } else if (data < a[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String a[]) {
        int[] arr1 = { 4,5,3,6,2,8,1,9,0,10,11,15,13};
        insertionSort ob = new insertionSort();
        ob.insertionsort(arr1);
        binarySearch bs = new binarySearch();
        int result = bs.binarysearch(arr1, arr1.length, 5);

        if (result != -1) {
            System.out.println("chest found at location " + result);
        } else {
            System.out.println("chest not found");
        }
    }
}
