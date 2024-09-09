import java.util.Scanner;
import java.util.*;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        Set<Integer> primes = new HashSet<>();
        boolean prime = true;
        for (int i = 1; i < n; i++){
            prime = true;
            for (int j = 2; j < i/2+1; j++){
                if (i%j == 0){
                    prime = false;
                    break;
                }    
            }
            if (prime)
                primes.add(i);
        }
        System.out.println(primes);







    }
}
