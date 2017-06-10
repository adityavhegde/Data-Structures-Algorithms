
package DpAndRecursive;

import java.util.ArrayList;
/**
 * Question: find all N possible combinations that add to a given Sum
 * eg: if N = 3 and Sum =5, One possible solution is 0 + 2 +3
 * @author Aditya
 */
public class NumbersAddToN {
            
    static int start = 0; //always
    static int end = 12; //the Sum
    static int _N =  2; //number of numbers in a set, that add to a sum
    static int functionCalls = 0;
    
    public static void main(String[] args) {
        
           
        long startTime = System.nanoTime();
        generate(new ArrayList<Integer>(),start, end, _N);
        long endTime = System.nanoTime();
        
        System.out.println("Time taken in milliseconds " + (endTime-startTime/100000.0));
        System.out.println("Number of function calls "+ functionCalls);
    }        
    
    static void generate(ArrayList<Integer> res, int start, int sum, int N){

        if(N == 0){
            if(sum == 0) {               
                for(Integer each: res)
                    System.out.print(each+ " ");
                System.out.println();
            }
            else res = null;
        }
        
        for(int i = 0; i <= sum ; i++){          
            /*Uncomment this if you want to see the combinations System.out.print(i+" ");*/
            ArrayList<Integer> temp = new ArrayList<>();
            
            if(!(res == null)){
                if(!res.isEmpty()){
                temp = new ArrayList<>(res);
                temp.add(i);
                }
                else temp.add(i);
            }
            
            if(N-1>0){
                functionCalls++;
                generate(temp,start + 1, sum - i, N-1);
            }
            else if(N-1 == 0 && sum-i == 0){
                functionCalls++;
                generate(temp,start + 1, sum - i, N-1);
            }    
            
        }
        /*Uncomment this if you want to see the combinations System.out.println();*/

    }
}
