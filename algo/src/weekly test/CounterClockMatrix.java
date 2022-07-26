/**
 * @author trinapal
 */
public class CounterClockMatrix {
    static int R = 4;
    static int C = 4;

    public static void main(String[] args) {
        int arr[][] = {{ 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 }};
        counterClockspiralPrint(R, C, arr);
    }

    private static void counterClockspiralPrint(int r, int c, int[][] arr) {
        int i, k = 0, l = 0;
        int cnt = 0;
        // total number of
        // elements in matrix
        int total = r * c;
        while (k < r && l < c)
        {
            if (cnt == total)
                break;
        //first column
        for (i =k; i< r; i++){
            System.out.print(arr[i][l] +" ");
            cnt++;
        }
        l++;
            if (cnt == total)
                break;
        //last row
        for( i = l; i <c; i++ ){
            System.out.print(arr[r-1][i] + " ");
            cnt++;
        }
        r--;

            if (cnt == total)
                break;
        //last column
        if(k < r) {
            for (i = r - 1; i >= k; i--) {
                System.out.print(arr[i][c - 1] + " ");
                cnt++;
            }
            c--;
        }
            if (cnt == total)
                break;

            // first row

            if(l < c){
                for(i = c -1; i>=l; i--){
                    System.out.print(arr[k][i] + " ");
                    cnt++;
                }
                k++;
            }
    }
    }
}
