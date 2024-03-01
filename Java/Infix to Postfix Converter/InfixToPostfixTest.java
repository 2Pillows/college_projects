public class InfixToPostfixTest {
    /**
     * Tester class for InfixToPostfixConverter
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Test using the 4 infix provided in textbook
        testInfixToPostfix("(a+b)/(c-d)", "ab+cd-/");
        testInfixToPostfix("a/(b-c)*d", "abc-/d*");
        testInfixToPostfix("a-(b/(c-d)*e+f)^g", "abcd-/e*f+g^-");
        testInfixToPostfix("(a-b*c)/(d*e^f*g+h)", "abc*-def^*g*h+/");
    }

    /**
     * Testing function that checks given postfix with expected. Prints results of
     * test
     * 
     * @param infix           Infix to test postfix converter
     * @param expectedPostfix Expected postfix for given infix
     */
    private static void testInfixToPostfix(String infix, String expectedPostfix) {
        // Determine postfix using InfixToPostfixConverter
        String postfix = InfixToPostfixConverter.infixToPostfix(infix);

        // Print results
        if (postfix.equals(expectedPostfix)) {
            System.out.println("Correctly determined postfix (" + postfix + ") for given infix (" + infix + ")");
        } else {
            System.out.println("Incorrectly determined postfix (" + postfix + ") for given infix (" + infix
                    + "). Correct postfix is: " + expectedPostfix);
        }
    }
}
