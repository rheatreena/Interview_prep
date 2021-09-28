import java.util.Arrays;
import java.util.Comparator;

/**
 * @author trinapal
 */
/*
Problem statement : Given weights and values of n items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack. - Fractional knapsack
 */
public class TestKnapsack {
    public static void main(String[] args) {
        int weight[] = {10, 20, 30};
        int value [] = {60,100,120};
        int totalWeightCapacity = 50;
        
        int maxWeight = terstFractionalKnapsack(weight,value, totalWeightCapacity);
        // Function call
        System.out.println("Maximum value we can obtain = "
                + maxWeight);
    }

    private static int terstFractionalKnapsack(int[] weight, int[] value, int totalWeightCapacity) {


        ItemValue [] itemValues = new ItemValue[weight.length];
        for(int i =0; i<weight.length; i++){
            itemValues[i] = new ItemValue(weight[i], value[i], i);

        }

        // sorting items by value;
        Arrays.sort(itemValues, (o1, o2) -> o2.cost.compareTo(o1.cost));

        double totalValue = 0d;
        for(ItemValue i : itemValues){
            int currwt = (int)i.wt;
            int currval = (int)i.val;

            if(totalWeightCapacity - currwt > 0){
                totalWeightCapacity = totalWeightCapacity - currwt;
                totalValue += currval;
            }else {
                // item cant be picked whole
                double fraction
                        = ((double)totalWeightCapacity / (double)currwt);
                totalValue += (currval * fraction);
               // totalWeightCapacity = (int)(totalWeightCapacity - (currwt * fraction));
                break;
            }

        }
        return totalWeightCapacity;
    }

static class ItemValue{
        Double cost;
        int wt,val,index;

        //constructor
    ItemValue(int wt, int val, int index){
        this.wt = wt;
        this.val = val;
        this.index = index;
        cost = (double) val / (double) wt;
    }

}
}
