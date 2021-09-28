/**
 * @author trinapal
 */
public class SwapElement {
    public static void main(String[] args) {
        int N = 8, K = 3;
        int Arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int test [] =swapKth(Arr,N,K);
        for(int i =0;i<test.length;i++){
            System.out.print(" " + test[i] + " ");
        }
    }
    static int [] swapKth(int arr[], int n, int k) {
        // code here
        int first_kth = arr[k-1];

        int index =(n-k);
        int last_kth = arr[index];

        /*for(int i=0 ; i<n; i++){
             if(arr[i] == first_kth){
                 arr[i] = last_kth;
                 break;
             }
             if(arr[i] == last_kth){
                 arr[i] = first_kth;
                 break;
             }
        }*/
        int temp  = arr[k-1];
        arr[k-1] = last_kth;
        arr[n-k] = temp;
        return arr;

        /*int temp = first_kth;
        first_kth = last_kth;
        last_kth = temp; */
    }
}
