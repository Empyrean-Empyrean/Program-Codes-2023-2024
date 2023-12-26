class array {
    public static void main(String[] args) {
        // declaring array1
        int arr1[] = new int[] { 1, 2, 3, 4, 5 };

        // looping array elements
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        // sum of array1
        int sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
        }
        System.out.println("sum of all elements in array 1:");
        System.out.println(sum1);

        // declaring array2
        int arr2[] = new int[] { 6, 7, 8, 9, 0 };

        // sum of array2
        int sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum2 += arr2[i];
        }
        System.out.println("sum of all elements in array 2:");
        System.out.println(sum2);

        // sum of arr1 and arr2
        int arr3[] = new int[arr1.length];
        for (int i = 0, j = 0, k = 0; i < arr1.length; i++, j++, k++) {
            arr3[k] = arr1[i] + arr2[j];
        }
        System.out.println("array sum of elements of array 1 and array 2:");
        System.out.println(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }

        // multiplication of arr1 and arr2
        int arr4[] = new int[arr1.length];
        for (int i = 0, j = 0, k = 0; i < arr1.length; i++, j++, k++) {
            arr4[k] = arr1[i] * arr2[j];
        }
        System.out.println("array multiplication of elements of array 1 and array 2");
        System.out.println(arr4);
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(arr4[i]);
        }
    }
}