/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DP;


/**
 * Number of ways, coins of certain denomination -- can make up the total
 * Note: Methods for both coin repetition and non-repetition
 * @author Aditya
 */
/*
 Where is the overlapping sub-problem ?
 For a given sum value, the subtree below could be the same
 Each subtree starts with some value of be. So we need to cache a given
 value of (sum, be)
 Using HashMap direcly, is not possible, since there is no unique value
 to give a key. Assigning sum as key is bad, since the 'be' index would 
 constantly overwrite the value at only 1 given sum; whereas we want all
 possible combinations of (sum,be)

 Optimisation: this code can be further optimised by starting be at last 
 index and limiting it to zero. Thus only 1 variable of be and en would be 
 required.
 This has been implemented by geeksforgeeks in their top-down solution:
 http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
*/ 
public class CoinChange {
    final static int input[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static int[][] cache;

    public static void main(String[] args) {
        int start = 0;
        int end = input.length;
        int total = 12;
        
        cache = new int[end][total+1];
        
        for(int i = 0; i<end;i++)
            for(int j = 0; j <= total; j++)
                cache[i][j] = -1;
        
        long u = System.nanoTime();
        System.out.println(coinChange(start,end-1,total));
        long v = System.nanoTime();
        
        System.out.println((v-u)/100000.0 );
        
        for(int i = 0; i<end;i++){
            for(int j = 0; j <= total; j++)
                System.out.print(cache[i][j]+ " ");     
            System.out.println();
        }
    }
    
    static int coinChange(int be, int en, int sum){
        
        
        if(be == en)
            if(sum - input[be] == 0 || sum == 0 ) return 1;
            else return 0;

        //case: avoid negative values of sum produced
        //If the value was already calculated, use from cache
        if(sum > 0)
            if(cache[be][sum]!=-1)
                return cache[be][sum];
        //case: some function calls, may drive the value to negative sums. Cut off
        //those branches
        if(sum<0)
            return 0;
       
        int res;       
        if((res = coinChange(be+1,en, sum - input[be]) + coinChange(be+1,en,sum)) >= 0){
           cache[be][sum] = res;
           return res;
        }
        System.out.println("code shall never reach here");
        return -1;
    }
    
    static int coinChangeRepeat(int be, int en, int sum){
        
        
        if(be == en)
            if(sum - input[be] == 0 || sum == 0 ) return 1;
            else return 0;

        //case: avoid negative values of sum produced
        //If the value was already calculated, use from cache
        if(sum > 0)
            if(cache[be][sum]!=-1)
                return cache[be][sum];
        //case: some function calls, may drive the value to negative sums. Cut off
        //those branches
        if(sum<0)
            return 0;
       
        int res;       
        if((res = coinChangeRepeat(be,en, sum - input[be]) + coinChangeRepeat(be+1,en,sum)) >= 0){
            //notice the change: be has not been incremented despite including 
            //including it in the sum. Thus it can be included again
            //In the above non-repeat method, each number was excluded in each
            //function call -- whether is was included in the sum or it wasn't
           cache[be][sum] = res;
           return res;
        }
        System.out.println("code shall never reach here");
        return -1;
    }

}
