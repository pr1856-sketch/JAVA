import org.matheclipse.core.eval.ExprEvaluator;

public class VehicleMotion {
    public static void main(String[] args) {
        ExprEvaluator e = new ExprEvaluator();

        // Displacement
        String s = "t^3-6t^2+9t+5";

        // Velocity
        System.out.println("Velocity: " +
            e.eval("D[" + s + ",t]"));

        // Acceleration
        System.out.println("Acceleration: " +
            e.eval("D[D[" + s + ",t],t]"));

        // Vehicle momentarily at rest
        System.out.println("At Rest: " +
            e.eval("Solve[3t^2-12t+9==0,t]"));

        // Definite integration from 0 to 4
        System.out.println("Displacement: " +
            e.eval("Integrate[3t^2-12t+9,{t,0,4}]"));
    }
}