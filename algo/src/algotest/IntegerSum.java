/**
 * @author trinapal
 */
public class IntegerSum {
    public static void main(String[] args) {
        long a [] = {5,8,3 ,10 ,22 ,45};
        long n =6;
        System.out.println( "total sum  " + getSum( a, n));
    }

    public static long getSum(long a[], long n)
    {
        // Your code goes here
        long sum =0;
        for(int i =0; i<n ;i++){
            sum+= a[i];
        }
        return sum;
    }
}
