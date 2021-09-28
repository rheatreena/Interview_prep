import java.util.HashMap;
import java.util.Map;

/**
 * @author trinapal
 */
public class NutsBolts {
    public static void main(String[] args) {

        int N = 5;
        char nuts[] = {'@', '%', '$', '#', '^'};
        char bolts[] = {'%', '@', '#', '$','^'};
        matchPairs(nuts, bolts, N);
    }

     static  void matchPairs(char nuts[], char bolts[], int n) {
            char[] arr = {'!','#','$','%','&','*','@','^','~'};
            Map<Character, Integer> map = new HashMap<>();

            for(int i=0; i<arr.length; i++){
                map.put(arr[i],0);
            }

            for(int i = 0; i<n; i++) {
                System.out.println("print nuts[i] "+ nuts[i] + " and " + map.get(nuts[i])+1);
                map.put(nuts[i], map.get(nuts[i])+1);
            }

            int index=0;
            for(int i=0; i<arr.length; i++){
                if(map.get(arr[i])> 0){
                    nuts[index] = arr[i];
                    bolts[index++] = arr[i];
                }
            }

            for(int i =0; i<n; i++){
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for(int i =0; i<n; i++){
                System.out.print(bolts[i] + " ");
            }
             System.out.println();
        }
    }

