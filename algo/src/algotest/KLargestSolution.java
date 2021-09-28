import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author trinapal
 */
public class KLargestSolution {
    public static void main(String[] args) {

        int N = 6, K = 3;
        int Arr[] = {1, 23, 12, 56,8,383};
        int result[] = kLargest(Arr, N, K);
        for(int i =0; i<result.length; i++){
            System.out.print(" " + result[i] + "");
        }

    }


    static int[] kLargest(int[] arr, int n, int k) {

        int result [] = new int[k];
        // Creating Min Heap for given
        // array with only k elements
        // Create min heap with priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i =0; i<k; i++){
            minHeap.add(arr[i]);
        }
// If current element is smaller
        // than minimum ((top element of
        // the minHeap) element, do nothing
        // and continue to next element
        for(int i =k; i<n; i++){
            if(minHeap.peek() > arr[i]){
                continue;
            }
            else{
                minHeap.poll();
                minHeap.add(arr[i]);

            }
        }
// Now min heap contains k maximum
        // elements, Iterate and print
        Iterator iterator = minHeap.iterator();

        while (iterator.hasNext())
        {
            int j =0;
            System.out.print(iterator.next() + " ");
        }
        // Now min heap contains k maximum
        // elements, Iterate and print
        for(int i=k-1;i>=0;i--){
            result[i] = minHeap.poll();
        }
        return result;


    }
}