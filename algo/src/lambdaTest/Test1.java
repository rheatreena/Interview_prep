/**
 * @author trinapal
 */
public class Test1 {

    public static void main(String[] args) {
        String s = "java interview";
        StringBuilder sb = new StringBuilder();
        char strArray[] = s.toCharArray();
        for(int i = strArray.length-1; i>=0; i--){
            sb.append(strArray[i]);
        }

        System.out.print(sb.toString());
    }
}
