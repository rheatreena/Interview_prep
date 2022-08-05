import java.util.List;
import java.util.ArrayList;

class AnotherPascalTriangle {
    public static void main(String[] args) {
       System.out.println(getRow(5));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> elements = new ArrayList<Integer>();
        
        if (rowIndex == 0){
            elements.add(1);
            return elements;
        }
        elements.add(1);
        // get previous row
        List<Integer> prevRow = getRow(rowIndex -1);
        for(int i=1; i<=rowIndex-1; i++){
           elements.add(prevRow.get(i-1) + prevRow.get(i));
            
        }
         elements.add(1);
        return elements;
    }
}