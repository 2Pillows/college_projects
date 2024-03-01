/**
 * Testing Class
 */
public class TestingFuncs {
    /**
     * Main Method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Variables for testing
        int inputNum = 5;
        int expectedNum = 120;

        // Create RecursiveFuncs object
        RecursiveFuncs testFuncs = new RecursiveFuncs();

        // Test both functions
        int firstResult = testFuncs.factorialFunc1(inputNum, 1);
        int secondResult = testFuncs.factorialFunc2(inputNum, 1);

        // Check results from functions
        checkResults(inputNum, expectedNum, firstResult);
        checkResults(inputNum, expectedNum, secondResult);
    }

    /**
     * Helper class to check function results
     * 
     * @param input    Base factorial number
     * @param expected Expected factorial result
     * @param result   Actual factorial result
     */
    private static void checkResults(int input, int expected, int result) {
        if (expected == result) {
            System.out.println("Correctly determined factorial of " + result + " for " + input);
        } else {
            System.out.println("Incorrectly determined factorial of " + result + " for " + input);
        }
    }
}
