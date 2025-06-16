package ForcastTool;

public class FinancialForecast {
	
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: If no periods left, return present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: Compute next period's value
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  // Initial investment
        double growthRate = 0.05;       // 5% growth per period
        int periods = 10;               // 10 years

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("Future Value after %d periods: $%.2f%n", periods, futureValue);
    }
}
