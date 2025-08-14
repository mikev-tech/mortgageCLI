// Simple Mortgage CLI Calculator

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {

    public static void main(String[] args){
        long principal; // amount loan
        float interest; // annual interest rate, 3.92 = 3.92% = 0.0392
        int period; // years

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        principal = scanner.nextLong();

        System.out.print("Annual Interest Rate: ");
        interest = scanner.nextFloat();

        System.out.print("Period (Years): ");
        period = scanner.nextInt();

        // r is monthly rate, divided annual interest in 12 months
        // convert annual interest rate percentage to decimal then divide 12 months
        double r = interest / 100.0 / 12.0;

        // n is number of months of loan payment
        // multiply years period by 12 months
        int n = period * 12;

        // Mortgage formula (M) = principal * ( r*(1+r)^n / (1+r)^n - 1 )
        double expression = Math.pow((1+r), n);
        double mortgage = principal * ( r*expression / (expression-1));

        // using System.out.println()
        String mortgageStr = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageStr);
    }
}
