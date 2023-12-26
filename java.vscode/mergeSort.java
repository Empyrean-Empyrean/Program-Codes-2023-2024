class mergeSort {    
void merge(int a[], int start, int mid, int end)    
{    
    int i, j, k;  
    int n1 = mid - start + 1;    
    int n2 = end - mid;     
        int LeftArray[] = new int[n1];  
        int RightArray[] = new int[n2];    
    for (i = 0; i < n1; i++)    
    LeftArray[i] = a[start + i];    
    for (j = 0; j < n2; j++)    
    RightArray[j] = a[mid + 1 + j];    
      
    i = 0;  
    j = 0;   
    k = start;  
      
    while (i < n1 && j < n2)    
    {    
        if(LeftArray[i] <= RightArray[j])    
        {    
            a[k] = LeftArray[i];    
            i++;    
        }    
        else    
        {    
            a[k] = RightArray[j];    
            j++;    
        }    
        k++;    
    }    
    while (i<n1)    
    {    
        a[k] = LeftArray[i];    
        i++;    
        k++;    
    }    
      
    while (j<n2)    
    {    
        a[k] = RightArray[j];    
        j++;    
        k++;    
        }    
    }    
  
    void mergesort(int a[], int start, int end)  
    {  
        if (start < end)   
        {  
            int mid = (start + end) / 2;  
            mergesort(a, start, mid);  
            mergesort(a, mid + 1, end);  
            merge(a, start, mid, end);  
        }  
    }    
    void printArray(int a[], int n)  
    {  
        int i;  
        for (i = 0; i < n; i++)  
            System.out.print(a[i] + " ");  
    }  
  
    public static void main(String args[])  
    {  
        int a[] = { 10, 80, 30, 90, 40, 50, 70 };  
        int n = a.length;  
        mergeSort m1 = new mergeSort();  
        System.out.println("\nBefore sorting array elements are - ");  
        m1.printArray(a, n);  
        m1.mergesort(a, 0, n - 1);  
        System.out.println("\nAfter sorting array elements are - ");  
        m1.printArray(a, n);  
        System.out.println("");  
}  
}