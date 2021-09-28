/**
 * @author trinapal
 */
public class Solution {

    public static void main(String[] args) {
       int  N = 3;
        int [] arr = {40, 50, 90};
        Solution solution = new Solution();
        System.out.println(solution.isPossible(N,arr));
    }

    static int isPossible(int N, int arr[]){
        // code here
        int reminder  =0;
        for(int i =0; i<N; i++){

            reminder = (reminder + arr[i])%3;

        }
        if(reminder ==0){
            return 1;
        }else{
            return 0;
        }
    }
}

