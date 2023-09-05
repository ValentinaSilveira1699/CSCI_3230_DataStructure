/*
(Evaluate expression) Modify Listing 20.9 EvaluateExpression.java to add       
operators ^ for exponent and % for modulus. For example, 3 ^ 2 is 9 and 3 % 2  
is 1. The ^ operator has the highest precedence and the % operator has the     
same precedence as the * and / operators. Your program should prompt the user  
to enter an expression. Here is a sample run of the program:                   
*/

import java.util.*;

public class Exercise20_23 {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an expression
        System.out.print("Enter an expression: ");
        String expression = input.nextLine();

        try {
            System.out.println(expression + " = " + evaluateExpression(expression));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + expression);
        }
    }

    /** Evaluate an expression */
    public static int evaluateExpression(String expression) {
        // Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Insert blanks around (, ), +, -, /, *, ^, and % 
        expression = insertBlanks(expression);

        // Extract operands and operators
        String[] tokens = expression.split(" ");

        // Phase 1: Scan tokens
        for (String token : tokens) {
            if (token.length() == 0) // Blank space
                continue; // Skip to the next token
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // Process +, -, *, /, ^, % in the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                        operatorStack.peek() == '-' ||
                        operatorStack.peek() == '*' ||
                        operatorStack.peek() == '/' ||
                        operatorStack.peek() == '^' ||
                        operatorStack.peek() == '%')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0)); // Push + or - operator
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
                // Process *, /, %, ^ in the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                        operatorStack.peek() == '/' ||
                        operatorStack.peek() == '%' ||
                        operatorStack.peek() == '^')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0)); // Push * or / or % operator
            } else if (token.charAt(0) == '^') {
                // Process ^ operators in the operator stack
                while (!operatorStack.isEmpty() && operatorStack.peek() == '^') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0)); // Push ^ operator
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); // Push '(' to stack
            } else if (token.trim().charAt(0) == ')') {
                // Process operators until seeing '('
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop '(' symbol from stack
            } else { // An operand scanned
                operandStack.push(Integer.parseInt(token));
            }
        }

        // Phase 2: Process remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        // Return the result
        return operandStack.pop();
    }

    /** Process one operator: Apply it to operands in operandStack */
    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        switch (op) {
            case '+':
                operandStack.push(op2 + op1);
                break;
            case '-':
                operandStack.push(op2 - op1);
                break;
            case '*':
                operandStack.push(op2 * op1);
                break;
            case '/':
                operandStack.push(op2 / op1);
                break;
            case '^':
                operandStack.push((int) Math.pow(op2, op1));
                break;
            case '%':
                operandStack.push(op2 % op1);
                break;
        }
    }

    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                s.charAt(i) == '+' || s.charAt(i) == '-' ||
                s.charAt(i) == '*' || s.charAt(i) == '/' ||
                s.charAt(i) == '^' || s.charAt(i) == '%')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }

        return result;
    }
}
