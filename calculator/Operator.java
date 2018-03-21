import java.util.*;
public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.

    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );
    private final static HashMap<String, Operator> operators;
    //Function used in GUI to actually set the hashMap keys and values
    static{
        operators = new HashMap<>();
        operators.put("+", new AdditionOperator());
        operators.put("-", new SubtractionOperator());
        operators.put("*", new MultiplicationOperator());
        operators.put("/", new DivisionOperator());
        operators.put("^", new ExponentOperator());
        operators.put("#", new PoundOperator());
        operators.put("!", new BangOperator());
        operators.put("(", new ParenthesesOperator());
    }
    
    public abstract int priority();
    public static Operator getHash(String x){
        return operators.get(x);
    }
    public abstract Operand execute(Operand op1, Operand op2);

    public static boolean check(String token) {
        //Changed tokens into char to check equivalency
        char tokenChar = token.charAt(0);
        if(tokenChar == '+' || tokenChar == '-' || tokenChar == '*' || tokenChar == '/' ||
                tokenChar == '^' || tokenChar == '#' || tokenChar == '!' || tokenChar == '(' ||
                tokenChar == ')'){
            return true;
        }
        return false;
    }
}

class AdditionOperator extends Operator {
    public int priority() {
        return 2;
    }
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue()+op2.getValue());
    }
}
class SubtractionOperator extends Operator {
    public int priority() {
        return 2;
    }
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue()-op2.getValue());
    }
}
class MultiplicationOperator extends Operator {
    public int priority() {
        return 3;
    }
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue()*op2.getValue());
    }
}
class DivisionOperator extends Operator {
    public int priority() {
        return 3;
    }
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue()/op2.getValue());
    }
}
class ExponentOperator extends Operator {
    public int priority() {
        return 4;
    }
    public Operand execute(Operand op1, Operand op2) {
        return new Operand((int)Math.pow(op1.getValue(),op2.getValue()));
    }
}
class BangOperator extends Operator {
    public int priority() {
        return 1;
    }
    public Operand execute(Operand op1, Operand op2) {
        return null;
    }
}
class PoundOperator extends Operator {
    public int priority() {
        return 0;
    }
    public Operand execute(Operand op1, Operand op2) {
        return null;
    }
}
class ParenthesesOperator extends Operator {
    public int priority() {
        return 5;
    }
    public Operand execute(Operand op1, Operand op2) {
        return null;
    }
}