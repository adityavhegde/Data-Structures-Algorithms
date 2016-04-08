/*
In this problem, you are given an Array of numbers
In addition, you have been given a number X
Find all the pair of numbers from the Array which add up to X
 */

package Hash;

import java.util.Arrays;
import java.util.Hashtable;

/**
 *
 * @author Aditya
 */
public class SumOfNumber {
    public static void main(String[] args) {
        int[] arr={1, 4, 45, 6, 10, 8,0,9};
        //sortAndFind(arr,10); hashArray(arr,10);
        hashTableImpl(arr,10);
        
    }
    
    public static void sortAndFind(int[] arr,int sum){
    /*
        In this method we first sort the input array
        We then have two pointers at the front and the rear end and move them
        And since the input is sorted and we move pointers as per the algorithm, a repeated pair won't appear
        */
        Arrays.sort(arr);
        int front=0,rear=arr.length-1;
        while(front<rear){
            if(arr[front]+arr[rear]==sum){
                System.out.println("Pair >"+arr[front]+" "+arr[rear]);
                front++;
                rear++;
            }    
            else{
                if(arr[front]+arr[rear]<sum){
                //move to the next number from front, because then that would increase the sum slowly, therefore tending to X
                    front++;
                }
                else rear--;
            }
        }
        
        /*
        Tme complexity, theoratically:-
        O(nlogn) for the sort and O(n/2)~O(n) for the while loop
        So: O(nlogn)
        */
    }
    
    public static void hashArray(int[] arr,int sum){
    /*
        In this method we use a boolean flag array to keep a track of elements
        When an element appears for the first time the flag against it is set True
        If we encounter another element, we check if it's complementary element is present in our set
        If yes we print the numbers
        */
        /*
        PROBLEMS: This array cannot deal with negative numbers
        */
        boolean[] flagArr=new boolean[100000];
        //this is a rough use. If the numbers actually exceed far much than this, we 
        //would acutally have to use a hash table
        /*
        How can we do this?
        For each new element we compute its complementary by subtracting it from the sum
        We then check the keys to find if there is any complementary. If yes, print, if no, add to hash table
        Check the hashTableImpl function for the implementation
        */
        for(int i:arr){
            int compl=sum-i;
            
            if(compl>=0 && flagArr[compl]) {//we avoid the negative values
                //if the complementary exists
                System.out.println("The pair is "+i+" "+compl);
                flagArr[i]=true;
            }
            else flagArr[i]=true;
        } ///for ends
    
    }
    
    public static void hashTableImpl(int[] arr,int sum){
        /*
        The explanation to this method has been procided in the hashArray method above
        */
    Hashtable table=new Hashtable();
        for(int i:arr){
            if(table.containsKey(sum-i)){
                System.out.println("The pair is "+i+" "+(sum-i));
                table.put(i,0);
            }
            else table.put(i, 0);       
        }///for ends
    }
}

