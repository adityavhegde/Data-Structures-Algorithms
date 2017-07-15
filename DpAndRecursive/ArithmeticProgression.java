
package DpAndRecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Aditya
 * Problem from DP section of interviewbit
 */
public class ArithmeticProgression {
    static final int[] input = {9, 4, 7, 2, 10};
    static final int len = input.length;
    
    public static void main(String[] args) {
      HashMap<Integer, HashMap<Integer, Integer>> cache = new HashMap<>();
      int max = -1;
      
      //diff-count
      cache.put(input[0], new HashMap<Integer, Integer>());
      
        for(int i = 1; i < len; i++){
           cache.put(input[i], new HashMap<Integer, Integer>());
            for(int j = i-1; j>=0; j--){
               if(input[i] - input[j] > 0)
                    if(cache.get(input[j]).containsKey(input[i]-input[j])){
                        int count = cache.get(input[j]).get(input[i]-input[j]);
                        count = count + 1;
                        if(count > max ) max = count;
                        cache.get(input[i]).put(input[i]-input[j], count);
                    }
                    else {
                        cache.get(input[i]).put(input[i]-input[j], 2);
                        if(max < 0) max = 2;
                    }            
            }
        }
            
        System.out.println(max);
             
    }
      
    
}
