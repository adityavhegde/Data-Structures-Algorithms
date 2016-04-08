/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author Aditya
 */
import java.util.Hashtable;

public class HashTableExampleJava {
    public static void main(String[] args) {
        Hashtable h=new Hashtable();
        //This example prints the number of occurences of each number
        
       int[] input={1,2,1,3,2,7,9,8,2,6,5,7,8,7,9,1};
      
       
       for(int i:input)
           if(h.containsKey(i)){
               int count=(int)h.get(i);
               count+=1;
               h.put(i, count);
           }    
           else {
                  h.put(i,1); 
            }
       
       //printing the hash table
        System.out.println(h);
              
            
      
    }
    
}
