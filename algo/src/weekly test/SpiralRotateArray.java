import java.util.ArrayList;
import java.util.List;

/**
 * @author trinapal
 */
public class SpiralRotateArray
{
    public static void main(String[] args) {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(bestSpiralOrder(a));
        spiralOrder(a);
    }

    private static void spiralOrder(int[][] a) {
        int row = a.length;
        int col = a[0].length;

        int startRowIndex = 0;
        int startColIndex =0;

        while(startRowIndex < row && startColIndex< col ){
            // Print the first row from the remaining rows
            for(int i = startColIndex; i< col; i++){
                System.out.print(a[startRowIndex][i] + " ");
            }
            startRowIndex++;

            // Print the last column from the remaining
            // columns

            for(int i = startRowIndex ; i< row;i++){
                System.out.print(a[i][row-1]+ " ");
            }
            col--;


            // print last row
           if(startRowIndex < row){
               for(int i = col-1; i >= startColIndex; --i){
                   System.out.print(a[row-1][i] + " ");
               }
               row --;
           }

           //print first column

            if(startColIndex < col){
                for (int i = row-1; i >= startRowIndex; --i){
                    System.out.print(a[i][startRowIndex] + " ");
                }
                startColIndex++;
            }
        }
    }

    private static List<Integer> bestSpiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if(matrix.length == 0){
            //return Collections.singletonList(0);
            return answer;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean [][] seen = new boolean[row][col];
        int dr[] = {0, 1, 0, -1};
        int dc [] = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        //// Iterate from 0 to R * C - 1

        for(int i =0; i<row*col; i++){
            answer.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x+ dr[di];
            int cc = y+ dc[di];
            if (0 <= cr && cr < row && 0 <= cc && cc < col
                    && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return answer;
    }
}
