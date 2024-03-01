/**
 * Main Class
 */
public class RecursiveFuncs {
    /**
     * First factorial function
     * 
     * @param n       Factorial number
     * @param counter Tracks number of loops
     * @return Factorial of initial n
     */
    public int factorialFunc1(int n, int counter) {
        if (n <= 1) {
            System.out.println("Looped " + counter + " times");
            return n;
        }
        return n * factorialFunc1(n - 1, counter + 1);
    }

    /**
     * Second factorial function
     * 
     * @param n       Factorial number
     * @param counter Tracks number of loops
     * @return Factorial of initial n
     */
    public int factorialFunc2(int n, int counter) {
        if (n > 1) {
            return n * factorialFunc2(n - 1, counter + 1);
        }
        System.out.println("Looped " + counter + " times");
        return n;
    }
}
