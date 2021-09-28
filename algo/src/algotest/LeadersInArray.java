/**
 * @author trinapal
 */


import java.io.*;
import java.util.*;
public class LeadersInArray {



    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        int n = arr.length;
        System.out.println(printLeaders(arr, n));
    }
    /* Java Function to print leaders in an array */
    static ArrayList<Integer> printLeaders(int arr[], int n) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max_from_right = arr[n - 1]; //last element
        list.add(max_from_right);


        for (int i = n - 2; i >= 0; i--) {
            if (max_from_right < arr[i]) {

                max_from_right = arr[i];
                list.add(max_from_right);

            }
        }
        Collections.reverse(list);
        return list;
    }
    }
