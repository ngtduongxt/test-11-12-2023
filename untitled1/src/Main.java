import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number x: ");
        double x = scanner.nextDouble();

        System.out.println("Enter number n: ");
        int n = scanner.nextInt();

        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        double result = expressionCalculator.calculationExpression(x, n);

        System.out.println("The value of the expression S(x, n) is: " + result);
    }
}
