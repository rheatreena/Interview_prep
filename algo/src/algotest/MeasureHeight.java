/**
 * @author trinapal
 */
public class MeasureHeight {

    public static void main(String[] args) {
        Height arr1 = new Height(1 ,2);
        Height arr2 = new Height(2 ,1);
        int n = 2;
        Height new_arr [] = new Height[n];
        new_arr[0] = arr1;
        new_arr[1]= arr2;
        System.out.println(findMax(new_arr, n));

    }

    public static int findMax(Height arr[], int n)
    {
        // your code here
        int sum =0;
        for (int i =0; i<n; i++){
            Height input = arr[i];
            int current_sum = (input.feet*12 + input.inches);
            if(current_sum > sum){
                sum = current_sum;
            }
        }
        return sum;
    }

    static class Height {
        int feet;
        int inches;
        public Height(int ft, int inc)
        {
            feet = ft;
            inches = inc;
        }
    }
}
