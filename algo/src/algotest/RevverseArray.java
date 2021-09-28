import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author trinapal
 */
public class RevverseArray {

    public static void main(String[] args) {
        int N = 5, K = 3;
        int arr[] = {1,2,3,4,5};
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for(int i =0; i<arr.length; i++){
            list1.add(arr[i]);
        }
        reverseInGroups(list1,N,K);
        for(int j =0; j<list1.size(); j++){
            System.out.print(" "+ list1.get(j) + " ");
        }

    }
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        int m =0;
        ArrayList<Integer> new_list = new ArrayList<>(n);
        for(int i=(k-1); i>=0; i--){
            //arr_new[i] =arr.get(i);
            new_list.add(m,arr.get(i));
            m++;
        }
        for(int i=(n-1); i>=k; i--){
            //arr_new[i] =arr.get(i);
            new_list.add(m,arr.get(i));
            m++;
        }

        for(int j =0; j<new_list.size(); j++){
            arr.set(j, new_list.get(j));
        }

    }
}
