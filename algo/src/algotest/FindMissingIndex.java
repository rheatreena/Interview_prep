/**
 * @author trinapal
 */
public class FindMissingIndex {

    public static void main(String[] args) {
        int N = 7;
        int A[] = {2,4,6,8,9,10,12};
       int B[] = {2,4,6,8,10,12};
        System.out.println(findExtra(A,B, N));
    }

    public static int findExtra(int a[], int b[], int n) {
        // add code here.
        int a1 =a.length; int b1 = b.length; int extra =0;

        for(int i=0;i<b.length; i++){
            // if (a1 >b1 && i<n-1){
            if(b[i]!=a[i]){
                int missing = a[i];
                extra = i;
                break;

            }
            //}
            //handling last element
            else{
                extra = n-1;
            }
        /*else if(b1> a1){
            if(b[i]!=a[i]){
                    extra = i;

                }
        }*/

        }
        return extra;
    }
}
