package exercise06;

/**
 *
 * @author vraj nagarsheth(20cs039)
 *(Revise Listing 5.15, PrimeNumber.java)
 * Listing 5.15 determines whether a number n is prime by checking whether 2, 3, 4, 5, 6, ..., n/2 is a divisor.
 * If a divisor is found, n is not prime. A more efficient approach is to check whether any of the
 * prime numbers less than or equal to 2n can divide n evenly. If not, n is prime.
 * Rewrite Listing 5.15 to display the first 50 prime numbers using this approach.
 * You need to use an array to store the prime numbers and later use them to check
 * whether they are possible divisors for n.
 */
public class Exercise06_06 {
    public static void main(String[] args) {
        // number_of_primes = 50                         //first 50 prime numbers
        int[] primeNumbers = new int[50];                 // array to store the prime numbers
        int index = 0;

        for (int i = 2; index < 50; i++) {

            if (isPrime(i)) {
                primeNumbers[index++] = i;
            }
        }

       printArray(primeNumbers, 10);

    }

    public static boolean isPrime(int number) {

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;

        }

        return true;
    }
    
    //method for printing array
    public static void printArray(int[] array, int numberPerLine) {

        for (int i = 0; i < array.length; i++) {

            System.out.println(" " +array[i]);
           
            if ((i + 1) % numberPerLine == 0) System.out.println("");
             
        }
    }

    }
    