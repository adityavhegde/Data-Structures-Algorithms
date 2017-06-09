
package DP;

import java.util.Hashtable;

/**
 *
 * @author Aditya
 */
/*
FIND THE Nth FIBONACCI NUMBER
This is a simple example of dynamic programming
*/
public class FibCalc {
    public static Hashtable h;
    
    public static void main(String[] args) {
        h=new Hashtable();
        System.out.println(fib(4)+" "+fib(5));
        
    }
    
    public static int fib(int n){
        if (h.containsKey(n)) return (int)h.get(n);
        if (n<=2) return 1;
        else {
            int f=fib(n-1)+fib(n-2);
            h.put(n, f);
            return f;
        }
    }
    
}
