

package Math;

/**
 *
 * @author Aditya
 */
public class SimpleSieve {
    
    public static void main(String[] args) {
        
        primeSieve(100);
        
                
    }
    
    public static void primeSieve(int n){
        /// n is the range till which we need to check
        /*
        The sieve can be used to check all the Prime numbers in the given range
        Additionally, it also tells you if the nth number is prime or not, by checking its flag at the 
        end of the process.
        This is a simple sieve and not segmented.
        We might want to use a segmented Sieve, because not all times would the entire array fit in memory
        */
        int[] a=new int[n+1];
            for(int i=0;i<a.length;i++)
                    a[i]=0;
         a[0]=1;
         a[1]=1;
            
         for(int i=2;i*i<a.length;i++){
             ///we go only till the square root
             if(a[i]!=1){
                 for(int j=2;i*j<a.length;j++)
                     a[i*j]=1;             
             }
         }   
          //printing all the primes
           for(int p=0;p<a.length;p++)
               if(a[p]==0) System.out.print(p+" ");
         
    
    
    
    }
    
    
}
