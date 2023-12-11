import java.util.Scanner;

public class ExpressionCalculator {
    public double calculationExpression(double x, int n) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result += Math.pow(x, i);
        }
        return result;
    }
}