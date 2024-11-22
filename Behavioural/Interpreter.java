
// 1. Define the Expression Interface

interface Expression {
    int interpret();
}

//  2. Create the TerminalExpression Classes
class NumberExpression implements Expression {
    private int number;                     

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}


//3. Create NonTerminalExpression Classes
class AdditionExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public AdditionExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override  
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

class SubtractionExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public SubtractionExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}


//  5. Client Code to Test the Interpreter Pattern
public class Interpreter {
    public static void main(String[] args) {
        // (10 + 5) - (2 + 3)
        
        Expression ten = new NumberExpression(10);
        Expression five = new NumberExpression(5);
        Expression two = new NumberExpression(2);
        Expression three = new NumberExpression(3);

        // Construct (10 + 5)
        Expression addition1 = new AdditionExpression(ten, five);

        // Construct (2 + 3)
        Expression addition2 = new AdditionExpression(two, three);

        // Construct (10 + 5) - (2 + 3)
        Expression mainExpression = new SubtractionExpression(addition1, addition2);

        // Interpret the expression and print the result
        System.out.println("Result: " + mainExpression.interpret());  // Output: 10
    }
}
