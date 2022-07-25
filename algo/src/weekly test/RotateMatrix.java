/**
 * @author trinapal
 */
public class RotateMatrix {
    static int R = 4;
    static int C = 4;
    
    public static void main(String[] args) {
        // Test Case 1
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // 5    1  2    3
        // 9    10  6    4
        // 13   11    7   8
       //  14     15   16   12

        // Test Case 2
    /* int a[][] = new int {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };*/
        rotatematrix(R, C, a);
    }

    private static void rotatematrix(int r, int c, int[][] a) {
        int currRow =0, currCol =0;
        int prev, curr;
        while(currRow< r && currCol<c){

            //add 1 to currRow and currCol and check

            if(currRow+1 == r || currCol+1 == c)
                break;

            // Store the first element of next
            // row, this element will replace
            // first element of current row

            prev = a[currRow+1][currCol];
            // Move elements of first row
            // from the remaining rows

            for(int i =currCol; i<c; i++){
                curr = a[currRow][i];
                a[currRow][i] = prev;
                prev = curr;
            }
            currRow++;

            // Move elements of last column
            // from the remaining columns

            for(int i=currRow; i<r;i++){
                curr = a[i][c-1];
                a[i][c-1] = prev;
                prev = curr;
            }
            c--;

            // Move elements of last row
            // from the remaining rows
            if (currRow < r)
            {
                for (int i = c-1; i >= currCol; i--)
                {
                    curr = a[r-1][i];
                    a[r-1][i] = prev;
                    prev = curr;
                }
            }
            r--;
            // Move elements of first column
            // from the remaining rows
            if (currCol < c)
            {
                for (int i = r-1; i >= currRow; i--)
                {
                    curr = a[i][currCol];
                    a[i][currCol] = prev;
                    prev = curr;
                }
            }
            currCol++;
        }
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
                System.out.print( a[i][j] + " ");
            System.out.print("\n");
        }
    }
}
