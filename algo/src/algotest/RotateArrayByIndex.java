import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author trinapal
 */
public class RotateArrayByIndex {
    public static void main (String[] args) throws IOException {
       /* int [] input = 	{2,4,6,8, 10, 12, 14, 16, 18, 20};
        int n = input.length;
        int rotateIndex = 3;
        rotateArray(input,n,rotateIndex); */
        /*
        GreekForGreeks solution
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String sizes[] = br.readLine().split(" ");
            int N = Integer.parseInt(sizes[0]);
            int D = Integer.parseInt(sizes[1]);
            if(D>N) D %= N;
            String s[] = br.readLine().split(" ");
            int a[] = new int[N];
            for(int i =0;i<N;i++){
                a[((i+N)-D)%N]=Integer.parseInt(s[i]);
            }
            for(int i=0;i<N;i++) {
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
    }



    public static void rotateArray(int[] input, int n, int rotateIndex) {
        int newArray [] = new int [(n - rotateIndex)];
        int fixArray [] = new int [(rotateIndex)];
        int finalArray[]= new int[n];

        for (int i =0,j=0,k=0; i <n; i++){
            if(i< rotateIndex){
                fixArray[k++] = input[i];
            }else{
                newArray[j++] = input[i];
            }

        }
        //copy two array into one array
        System.arraycopy(newArray, 0, finalArray, 0, newArray.length);
        System.arraycopy(fixArray, 0, finalArray, newArray.length, fixArray.length);

        for(int i =0; i <n; i++){
            System.out.print(" " + finalArray[i] + " ");
        }
    }
}
