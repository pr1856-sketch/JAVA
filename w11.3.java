import org.matheclipse.core.eval.ExprEvaluator;

public class MathExpression {
    public static void main(String[] args) {
        ExprEvaluator e = new ExprEvaluator();

        // Expand expression
        System.out.println("Expanded: " +
            e.eval("Expand[(x+2)^2]"));

        // Factorize expression
        System.out.println("Factorized: " +
            e.eval("Factor[x^2+5x+6]"));

        // Simplify expression
        System.out.println("Simplified: " +
            e.eval("Simplify[(x^2-4)/(x-2)]"));

        // Solve quadratic equation
        System.out.println("Solutions: " +
            e.eval("Solve[x^2-5x+6==0,x]"));
    }
}