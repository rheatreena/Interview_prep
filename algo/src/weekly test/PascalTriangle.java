import java.util.ArrayList;
import java.util.List;

/**
 * @author trinapal
 */
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.print(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row, prev = null;


        if(numRows == 0){
            return ans;
        }

        for(int i =0; i<numRows; i++){
            row = new ArrayList<>();
            for(int j =0; j<=i;j++){
                if(j ==0 || j==i){
                    row.add(1);
                }else{
                    row.add(prev.get(j-1) + prev.get(j));
                    System.out.println(" row " + row);
                }
            }
            prev = row;
            ans.add(row);
        }
        return ans;

    }

}
