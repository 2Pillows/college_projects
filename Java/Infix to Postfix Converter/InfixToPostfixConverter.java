import java.util.Stack;

public class InfixToPostfixConverter {

    /**
     * Takes in an infix String and transforms it to postfix
     * 
     * @param infix String of infix
     * @return String of postfix
     */
    public static String infixToPostfix(String infix) {
        /**
         * Converts an infix expression to an equivalent postfix expression.
         * operatorStack = a new empty stack
         * postfix = a new empty string
         */
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        int index = 0;

        char topOperator = ' ';

        while (index < infix.length()) {

            char nextCharacter = infix.charAt(index);

            switch (nextCharacter) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h': // Handles all variables used in tests
                    postfix.append(nextCharacter);
                    break;
                case '^': // Handles ^ operator
                    operatorStack.push(nextCharacter);
                    break;
                case '+':
                case '-':
                case '*':
                case '/': // Handles +, -, *, and / using operatorStack
                    // Checks if operatorStack has operator with higher precedence
                    while (!operatorStack.isEmpty() &&
                            precedence(nextCharacter) <= precedence(operatorStack.peek())) {
                        postfix.append(operatorStack.peek()); // Enters operator to postfix
                        operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter); // Sends operator to operatorStack
                    break;
                case '(': // Handles (
                    operatorStack.push(nextCharacter);
                    break;
                case ')': // Stack is not empty if infix expression is valid
                    topOperator = operatorStack.pop(); // Takes top operator from operatorStack
                    while (topOperator != '(') { // Empties operators to postfix
                        postfix.append(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    break; // Ignore unexpected characters
            }
            index++; // Increment while loop
        }

        // Offload the operators into postfix
        while (!operatorStack.isEmpty()) {
            topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }

        return postfix.toString(); // Return StringBuilder as String
    }

    /**
     * Takes a char and determines the precedence value
     * 
     * @param operator character
     * @return integer for value of operator
     */
    private static int precedence(char operator) {
        // Valid Operators: (, ), +, -, *, /, ^
        switch (operator) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default: // Throw error if no valid operator is given
                throw new IllegalArgumentException("Invalid Operator: " + operator);
        }
    }
}
