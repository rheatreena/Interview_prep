package algotest;

import java.util.*;

public class GroupAnaGramTest {

    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        //String [] strs = {"a"};
        System.out.println(" " + groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>() ;

        if(strs.length == 0){
            return output;
        }

        for(int i =0; i<strs.length; i++){
            char [] temp = strs[i].toCharArray();
            //sort the array
            Arrays.sort(temp);
            String s = String.valueOf(temp);
            // map to store the array
            if (map.containsKey(s)) {

                map.get(s).add(strs[i]);
            }else{
                map.put(s, new ArrayList<>());
                map.get(s).add(strs[i]);
            }
        }

        for(String ans : map.keySet())
            output.add(map.get(ans));
        return output;
    }
}
