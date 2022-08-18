/**
 * @author trinapal
 */
public class MaxArea {

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        //left and right array

        int [] left = new int[height.length];
        int [] right = new int[height.length];

        //forward traversal
        left[0] = height[0];
        for(int i =1; i<height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
            System.out.println(" left " +left[i] );
        }

        //backward traversal
        right[height.length-1] = height[height.length-1];
        for(int i = height.length -2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
            System.out.println(" right " +right[i] );
        }

        //find max area
        int max =0;
        for(int i =0; i<height.length; i++){
            max += Math.max(right[i], left[i]) - height[i];
            System.out.println(" max " +max );
        }

        return max;
    }
}
