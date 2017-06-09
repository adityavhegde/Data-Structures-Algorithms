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
    static int end = 20; //the Sum
    static int _N =  5; //number of numbers in a set, that add to a sum
    static HashMap<Node,ArrayList<Integer>> cache;

    public static void main(String[] args) {
        
        cache = new HashMap<>();
           
        long startTime = System.nanoTime();
        generate(new ArrayList<Integer>(),start, end, _N);
        long endTime = System.nanoTime();
        
        System.out.println(endTime-startTime/100000.0);
        /*
        for(Map.Entry each: cache.entrySet()){
            System.out.println(((Node)each.getKey()).currPoint
                                +" "+((Node)each.getKey()).currPoint
                                +" "+((Node)each.getKey()).N
                                +" "+each.getValue());
        }*/
    }        
    
    static void generate(ArrayList<Integer> res, int start, int sum, int N){

        if(N == 0)
            if(sum == 0) {
                for(Integer each: res)
                    System.out.print(each+ " ");
                System.out.println();
            }
            else res = null;

        for(int i = start; i <= sum ; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            
            if(!(res == null)){
                
                if(!res.isEmpty()){
                temp = new ArrayList<>(res);
                temp.add(i);
                
                }
                else temp.add(i);
            }
                        
            generate(temp,start + 1, sum - i, N-1);

        }
    }
}

class Node{
    int prevPoint;
    int currPoint;
    int N;

    public Node(int prevPoint, int currPoint, int N) {
        this.prevPoint = prevPoint;
        this.currPoint = currPoint;
        this.N = N;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Node) {
            Node pp = (Node) obj;
            return (pp.prevPoint == this.prevPoint && pp.currPoint == this.currPoint  && pp.N == this.N);
        } else {
            return false;
        }
    }
   
}
