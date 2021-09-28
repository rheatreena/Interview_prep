package algotest;

/**
 * @author trinapal
 */


/*
* Test cases
*
* We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.
* */
public class DetectCaptital {

    public static void main(String[] args) {

        String input = "LEetGoogle";
        String input1 = "Leetgoogle";
        String input2 = "KITE";
        System.out.println(checkCapital(input, input.length()));
        System.out.println(checkCapital(input1, input1.length()));
        System.out.println(checkCapital(input2, input2.length()));
    }

    private static boolean checkCapital(String input, int length) {
        //check if first letter and second letter are capital
        if(Character.isUpperCase(input.charAt(0)) && Character.isUpperCase(input.charAt(1))){
            for(int i =2; i < length; i++){
                if(Character.isLowerCase(input.charAt(i))){
                    return false;
                }
            }
        }
        else
        {
            for(int i =1; i < length; i++){
                if(!Character.isLowerCase(input.charAt(i))){
                    return false;
                }

            }

    }
    return true;
}
}
