import java.util.Scanner;

public class FinancialForecasting {

    // Method to calculate future value using iteration
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter the growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of periods: ");
        int periods = scanner.nextInt();

        // Calculate future value
        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("Future Value after %d periods: %.2f\n", periods, futureValue);

    }
    
}


