/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DpAndRecursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Question: find all N possible combinations that add to a given Sum
 * eg: if N = 3 and Sum =5, One possible solution is 0 + 2 +3
 * @author Aditya
 */
public class NumbersAddToN {
            
    static int start = 0; //always
    static int end = 100; //the Sum
    static int _N =  2; //number of numbers in a set, that add to a sum
    static HashMap<Node,ArrayList<Integer>> cache;
    static int functionCalls = 0;
    
    public static void main(String[] args) {
        
        cache = new HashMap<>();
           
        long startTime = System.nanoTime();
        generate(new ArrayList<Integer>(),start, end, _N);
        long endTime = System.nanoTime();
        
        System.out.println("Time taken in milliseconds " + (endTime-startTime/100000.0));
        System.out.println("Number of function calls "+ functionCalls);
        /*
        for(Map.Entry each: cache.entrySet()){
            System.out.println(((Node)each.getKey()).currPoint
                                +" "+((Node)each.getKey()).currPoint
                                +" "+((Node)each.getKey()).N
                                +" "+each.getValue());
        }*/
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
        
        for(int i = start; i <= sum ; i++){          

            ArrayList<Integer> temp = new ArrayList<>();
            
            if(!(res == null)){
                
                if(!res.isEmpty()){
                temp = new ArrayList<>(res);
                temp.add(i);
                
                }
                else temp.add(i);

            }
            
            if(N-1>=0){
                functionCalls++;
                generate(temp,start + 1, sum - i, N-1);
            }
        }
    }
}

