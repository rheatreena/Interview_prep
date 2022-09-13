package algotest;

public class sortTest {

    public static void main(String[] args) {
        int [] inputArr =     {12, 11, 13, 5, 6, 7};
        //q1
        /*heapSort(inputArr, inputArr.length);
        printArray(inputArr);
        System.out.print(" ------------------------------ "); */

         // q2
       /* insertionSort(inputArr);
        printArray(inputArr);
        System.out.print(" ------------------------------ "); */

        // q3
      /* selectionSort(inputArr);
        printArray(inputArr);
        System.out.print(" ------------------------------ ");*/

        //q4
        /*mergeSort(inputArr);
        printArray(inputArr);
        System.out.println(" ------------------------------ "); */

        //q5
        quickSort(inputArr, 0, inputArr.length-1);
        printArray(inputArr);
        System.out.println(" ------------------------------ ");

    }

    private static void quickSort(int[] inputArr, int low, int high) {
        if(low < high){
            int pivot = partition(inputArr, low, high);
            quickSort(inputArr, low, pivot-1);
            quickSort(inputArr, pivot+1, high);
        }

    }

    private static int partition(int[] inputArr, int low, int high) {
        int pivot = inputArr[high];
        int i = low -1;
        for(int j = low; j<=high-1; j++){
            if(inputArr[j] < pivot){
                i++;
                swap(inputArr, i,j);
            }
        }
        swap(inputArr, i+1, high);
        return i+1;
    }

    private static void swap(int[] inputArr, int i, int j) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = temp;
    }

    private static void mergeSort(int[] inputArr) {

        int n =  inputArr.length;

        int low =0;
        int high = n -1;
        divide(inputArr, low,high);
    }

    private static void divide(int[] inputArr, int low, int high) {
        
        if(low < high){
            int mid = low +(high-low)/2;
            divide(inputArr, 0, mid);
            divide(inputArr, mid+1, high);
            merge(inputArr, low, mid,high);
        }
    }

    private static void merge(int[] inputArr, int low, int mid, int high) {
        // two temp arr and length
        int n1 = mid-low+1;
        int n2 = high -mid;

        int [] left = new int[n1];
        int [] right = new int[n2];

        // copy data
        for(int i =0; i<n1;i++){
            left[i] = inputArr[low+i];
        }

        for(int m =0; m <n2; m++){
            right[m]= inputArr[mid+1+m];
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        int k =low;

        while(i<n1 && j <n2){
        if(left[i] <= right[j]){
            inputArr[k] = left[i];
            i++;
        }else{
            inputArr[k] = right[j];
            j++;
        }
        k++;
        }

        while(i<n1){
        inputArr[k] = left[i];
        i++;
        k++;
        }
        while(j <n2){
        inputArr[k] = right[j];
        j++;
        k++;
        }
    }

    private static void selectionSort(int[] inputArr) {
        for(int i =0; i<inputArr.length-1; i++){
            int min_idex = i;
            for(int j = i+1; j< inputArr.length; j++){
                if(inputArr[j] < inputArr[min_idex]) {
                    min_idex = j;
                }
                }
            int swap = inputArr[min_idex];
            inputArr[min_idex] = inputArr[i];
            inputArr[i] = swap;
            }
        }


    private static void insertionSort(int[] inputArr) {
       for(int i =1; i< inputArr.length; i++){
           int key = inputArr[i];
           int j = i-1;
           while(j >=0 && inputArr[j] > key){
               inputArr[j+1] = inputArr[j];
               j =j-1;
           }
           inputArr[j+1] =key;
       }
    }

    private static void printArray(int[] inputArr) {

        for(int i =0; i< inputArr.length; i++){
            System.out.print(" " +  inputArr[i] + " ");
        }
    }

    //selection sort principle
    static void heapSort(int[] arr, int length){
        // build heap in half way

        for(int i = length/2-1; i>=0; i--){
            heapify(arr, length, i);
        }

        // one by one extract from heap

        for(int i = length-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }



    }

    private static void heapify(int[] arr, int length, int i) {

        int largest = i;
        int left = 2*i +1;
        int right = 2*i +2;

        if(left< length && arr[left] > arr[largest] ){
            largest = left;
        }

        if(right < length && arr[right]> arr[largest]){
            largest = right;

        }


        //if largest is not a root

        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, length, largest);
        }

    }


}
