import java.util.Arrays;
import java.util.Comparator;

/**
 * @author trinapal
 *
 * Here we can't break weight
 */
public class wholeKnapSackProblem {
    public static void main(String[] args) {
        int weight[] = {10, 20, 30};
        int value [] = {60,100,120};
        int totalWeightCapacity = 50;

        int maxWeight = knapSack(totalWeightCapacity, weight,value, weight.length);
        System.out.println("Maximum value we can obtain = "
                + maxWeight);
    }

    /*private static int terstFractionalKnapsack(int[] weight, int[] value, int totalWeightCapacity, int length) {

        if (length == 0 || totalWeightCapacity == 0)
            return 0;

        if(weight[length -1] > totalWeightCapacity){
            return  terstFractionalKnapsack(weight, value, totalWeightCapacity, length-1);
        }else{
            return max(value[length - 1]
                            + terstFractionalKnapsack(weight,
                    value, totalWeightCapacity - weight[length - 1], weight.length - 1),
                    terstFractionalKnapsack(weight, value, totalWeightCapacity, weight.length - 1));
        }

    } */

    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W) {
            return knapSack(W, wt, val, n - 1);
        }

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else {
           // System.out.println(" wt[n-1] " + wt[n - 1] + " val[n - 1] " + val[n - 1]);
            System.out.println(" knapSack(W - wt[n - 1]" + knapSack(W ,wt,val,n-1));
            return max(val[n - 1]
                            + knapSack(W - wt[n - 1], wt,
                    val, n - 1),
                    knapSack(W, wt, val, n - 1));
        }
    }

    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    static class Item{
        int wt;
        int val;
        int index;
        Double cost;

        //constructor
        Item(int wt, int val, int index){
            this.wt = wt;
            this.val = val;
            this.index = index;
            cost = (double)val/(double)wt;
        }
    }
}
