/**
 * @author trinapal
 */
public class LongestString
{
    public static void main(String[] args) {
        String names[] = { "Geek", "Geeks", "Geeksfor",
                "GeeksforGeek", "GeeksforGeeks" };
        System.out.print(longest(names, names.length));

    }
    static String longest(String names[], int n) {
        String longest = " ";
        for(int i =0; i< n; i++){
            if(names[i].length() > longest.length()){
                longest = names[i];
            }
        }


        return longest;
    }
}
