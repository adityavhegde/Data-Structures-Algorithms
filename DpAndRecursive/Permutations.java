
package DpAndRecursive;

/**
 * Problem: generate all permutations of a string
 * Proc 1: repeats characters for eg aab
 * Proc 2 does not repeat character and above permutations won't be generated
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
    static void proc(String res, int start, int N){
        
        if(N==0){
            for(int j=0; j<res.length();j++){
                System.out.print(input.charAt((int)(res.charAt(j)-48)));
            }
            System.out.println("");
        }

        for(int i = start; i<input.length(); i++){
            if(N-1 >= 0){
                proc(res.concat(Integer.toString(i)), start + 1, N - 1);
            }
        } 

    }
}
