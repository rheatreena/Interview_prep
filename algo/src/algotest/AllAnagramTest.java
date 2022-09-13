package algotest;

import java.util.*;

public class AllAnagramTest {

    public static void main(String[] args) {
        //q1. find anagrams
        String s = "cbaebabacd";
        String p = "abc";
        System.out.print(findAnagrams( s,  p));
        System.out.print("--------------------------------------------------");

        // find string permutation
        String s2 = "eidboaoo";
        String s1 = "ab";
        //System.out.print(checkInclusion(s1, s2));
       // System.out.print("--------------------------------------------------");

        // maximum size subarray sum
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        //System.out.print(minSubArrayLen(target, nums));
        //System.out.print("--------------------------------------------------");
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left =0;
        int sum =0;

        for(int right = 0; right<nums.length; right ++){
            sum += nums[right];

            while(sum >= target){
                minLength = Math.min(minLength, right -left +1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    private static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;

        // build a window
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            // update data in the window
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c)
                    && window.get(c).equals(need.get(c))) valid++;

            // shrink
            while (right - left >= s1.length()) {
                // find s2 in s1
                if (valid == need.size()) return true;

                char d = s2.charAt(left);
                left++;

                // update data in the window
                if (need.containsKey(d)
                        && window.get(d).equals(need.get(d))) valid--;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
        }
        return false;
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if(s.length()<p.length()){
            return ans;
        }

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();


        for(int i = 0 ; i < p.length() ; i++){
            need.put(p.charAt(i) , need.getOrDefault(p.charAt(i),0) + 1);
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0)+1);
        }
        if( window.equals(need)){
            ans.add(0);
        }

        int left = 0;


        for(int right = p.length(); right < s.length(); right++){
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0)+1);
            window.put(s.charAt(left), window.get(s.charAt(left))-1);
            if(window.get(s.charAt(left)) == 0) {
                window.remove(s.charAt(left));
            }
            left++;
            if( window.equals(need)){
                ans.add(left);
            }
        }

        /* for(int i = 0 ; i < p.length() ; i++){
            window.put(s.charAt(i) , window.getOrDefault(s.charAt(i) , 0) + 1);
        }

        for(int i = 0 ; i < p.length() ; i++){
            need.put(p.charAt(i) , need.getOrDefault(p.charAt(i),0) + 1);
        }*/

       /* int i = p.length();
        while(i < s.length()){

            if(need.equals(window)){
                ans.add(i-p.length());
            }

            char rCh = s.charAt(i-p.length());
            char cCh = s.charAt(i);

            if(window.get(rCh) == 1){
                window.remove(s.charAt(i-p.length()));
            }else{
                window.put(rCh , window.get(rCh) - 1);
            }
            window.put(cCh , window.getOrDefault(cCh , 0) + 1);
            i++;
        }

        if(need.equals(window)){
            ans.add(i-p.length());
        }*/

        return ans;
    }
}
