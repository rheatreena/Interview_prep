class LongestPalindromeSubStringTest {
    int resultStart;
    int resultLength;
    public String longestPalindrome(String s) {
        
    if(s.length() <2){
        return s;
    }
        for(int i =0; i<s.length()-1; i++){
            possibleRange(s, i,i); //for odd
            possibleRange(s, i,i+1); //for even -two mid points
            
        
        }
        
return s.substring(resultStart, resultStart+resultLength);
       
}
    
    private void possibleRange(String s, int start, int end){
        while(start >= 0 && end <s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end ++;
        }
        
        if(resultLength < end-start-1){
            resultStart = start+1;
            resultLength = end-start-1;
        }
    }
}