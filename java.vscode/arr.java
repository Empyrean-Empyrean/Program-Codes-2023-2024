import java.util.Arrays;

public class arr {

    public static int[] addBegining(int[] arr, int element) {
        int newArr[] = new int[arr.length + 1];
        newArr[0] = element;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;

    }

    public static int[] addEnd(int n, int arr[], int x) {
        int i;
        int newarr[] = new int[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    public static int[] insertX(int n, int arr[], int x, int pos) {
        int i;
        int newarr[] = new int[n + 1];
        for (i = 0; i < n + 1; i++) {
            if (i < pos - 1)
                newarr[i] = arr[i];
            else if (i == pos - 1)
                newarr[i] = x;
            else
                newarr[i] = arr[i - 1];
        }
        return newarr;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int element = 8;

        int newArr[] = addBegining(arr, element);

        System.out.println("Original  : " + Arrays.toString(arr));
        System.out.println("New Array : " + Arrays.toString(newArr));

        int n = 10;
        System.out.println("Initial Array:\n" + Arrays.toString(arr));
        int x = 50;
        arr = addEnd(n, arr, x);
        System.out.println("\nArray with " + x + " added:\n" + Arrays.toString(arr));
        int y = 50;
        int pos = 5;
        System.out.println("Initial Array:\n" + Arrays.toString(arr));
        arr = insertX(n, arr, y, pos);
        System.out.println("\nArray with " + y + " inserted at position " + pos + ":\n" + Arrays.toString(arr));
    }

}