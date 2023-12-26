public class insertionSort {
    void insertionsort(int arr[]){
        int j, val;
        for(int i = 1; i<arr.length;i++){
            val = arr[i];
            j  =i-1;
            while(j>=0 && arr[j] > val){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = val;
        }
    }
    public static void main(String a[]){    
        int[] arr1 = {10, 80, 30, 90, 40, 50, 70};    
        System.out.println("Before Insertion Sort");    
        for(int i:arr1){    
            System.out.print(i+" ");    
        }    
        System.out.println(); 
        insertionSort ob = new insertionSort();      
        ob.insertionsort(arr1);   
        System.out.println("After Insertion Sort");    
        for(int i:arr1){    
            System.out.print(i+" ");
        }    
    }
}
