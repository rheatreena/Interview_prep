/**
 * @author trinapal
 */
public class zigzagMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        zigZagMatrix(matrix, 3, 3);
    }


    //o(m*n) and space0(1)
    private static void zigZagMatrix(int[][] matrix, int n, int m) {
        int row =0, col = 0;
        boolean row_inc = false;
        int mn = Math.min(m, n);

        for(int i =1; i<mn; i++){
            for(int j =0; j<i; j++){
                System.out.print(matrix[row][col] + " ");
                if (j + 1 == i)
                    break;

                // If row_increment value is true
                // increment row and decrement col
                // else decrement row and increment
                // col

                if(row_inc){
                    row++;
                    col--;
                }else{
                    row--;
                    col++;
                }
            }
            if (i == mn)
                break;

            // Update row or col value according
            // to the last increment
            if (row_inc) {
                ++row;
                row_inc = false;
            } else {
                ++col;
                row_inc = true;
            }

        }
    }

}
