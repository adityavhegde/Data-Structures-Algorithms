
package DpAndRecursive;

/**
 * Problem: generate all permutations of a string
 * Note: A character can be repeated
 * Extended the logic from NumbersAddToN problem
 * @author Aditya
 */
public class Permutations {
    static String input ="ab";

    public static void main(String[] args) {
        proc("",input.length());
    }
    static void proc(String res, int N){
        if(N==0){
            for(int j=0; j<res.length();j++){
                System.out.print(input.charAt((int)(res.charAt(j)-48)));
            }
            System.out.println("");
        }
        
        for(int i = 0; i<input.length(); i++){
            if(N-1 >= 0){
                proc(res.concat(Integer.toString(i)),N-1);
            }
        } 

    }
}
