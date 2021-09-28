/**
 * @author trinapal
 */
public class GetMaxMinPair {


    long first, second;
    public GetMaxMinPair(long first, long second)
    {
        this.first = first;
        this.second = second;
        System.out.println("min " + first + "  max " + second);
    }

    public static void main(String[] args) {
       long  N = 6;
        long A[] = {3, 2, 1, 56, 10000, 167};

        getMinMax(A,N);
    }

    static GetMaxMinPair getMinMax(long a[], long n)
    {
        //Write your code here
        long max = a[0];
        long min = a[0];

        for (int i =0; i< n; i++){
            if (a[i] > max){
                max = a[i];
            }
            if(a[i] < min){
                min = a[i];
            }
        }


        return new GetMaxMinPair(min, max);

    }
}
