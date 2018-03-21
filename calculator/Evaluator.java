
import java.util.*;

public class Evaluator {

    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;

    private StringTokenizer tokenizer;
    // Added () to the delimiters to make parentheses a valid token
    private static final String DELIMITERS = "+-*^/#!() ";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int eval(String expression) {
        String token;

        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators
        // TODO Operator is abstract - this will need to be fixed:
        // operatorStack.push( new Operator( "#" ));
        operatorStack.push(new PoundOperator());
        // When is it a good time to add the "!" operator?
        // ^ never...

        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(token)) {
                    operandStack.push(new Operand(token));
                } else {
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        System.exit(1);
                    }
                    // ****Checking to see if closed Parentheses****
                    // Don't create new Operator if closed
                    // Loop until Open paren is on top of operatorStack 
                    if (token.charAt(0) == ')') {
                        while (operatorStack.peek().priority() != 5) {
                            Operator oldOpr = operatorStack.pop();
                            Operand op2 = operandStack.pop();
                            Operand op1 = operandStack.pop();
                            operandStack.push(oldOpr.execute(op1, op2));
                        }
                        operatorStack.pop(); // pop open parentheses
                        continue; // continue so that new object does not get created.
                    }
                    // TODO Operator is abstract - these two lines will need to be fixed:
                    // The Operator class should contain an instance of a HashMap,
                    // and values will be instances of the Operators. See Operator class
                    // skeleton for an example.
                    
                    Operator newOperator = Operator.getHash(token);
                    // ****Checking to see if Open Parentheses****
                    // If so push into the operator stack 
                    if (newOperator.priority() == 5) {
                        operatorStack.push(newOperator);
                        continue; // continue because no execution needs to be performed for (
                    }
                    // Added to check that the operator is not a parentheses.
                    while (operatorStack.peek().priority() >= newOperator.priority()
                            && operatorStack.peek().priority() != 5) {
                        // note that when we eval the expression 1 - 2 we will
                        // push the 1 then the 2 and then do the subtraction operation
                        // This means that the first number to be popped is the
                        // second operand, not the first operand - see the following code
                        Operator oldOpr = operatorStack.pop();
                        Operand op2 = operandStack.pop();
                        Operand op1 = operandStack.pop();
                        operandStack.push(oldOpr.execute(op1, op2));
                    }
                    operatorStack.push(newOperator);
                }
            }
        }
        // ****Algorithm Added****
        // Check if stacks are not empty, if they are not
        // loop until final operand is calculated which is the answer.
        while (operandStack.size() > 1 && operatorStack.size() > 1) {
            Operator oldOpr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push(oldOpr.execute(op1, op2));
        }
        // clear operatorStack to prepare for other expressions.
        operatorStack.pop();
        // return the last value in the operand stack and pop it to empty the stack.
        return operandStack.pop().getValue();
    }
}
