import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        int principal;
        do {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if(principal >= 1_000 && principal <= 1_000_000) break;
            System.out.println("Enter a number between 1,000 and 1,000,000");
        } while (true);

        float annualInterest;
        do {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30) break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        } while (true);

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        int years;
        do {
            System.out.print("Period (Years): ");
            years = scanner.nextInt();
            if (years >= 1 && years <= 30) break;
            System.out.println("Enter a value between 1 and 30");
        } while (true);

        int period = years * MONTHS_IN_YEAR;
        float mortgage = (float) (principal * monthlyInterest * Math.pow(1+monthlyInterest, period) / (Math.pow(1+monthlyInterest, period) - 1));
        String mortgageCurrency = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Mortgage: " + mortgageCurrency);

//        Locale[] locales = Locale.getAvailableLocales();
//
//        for(Locale local : locales)
//            System.out.println(local);
//        System.out.println("Locales on my laptop: " + Locale.getAvailableLocales().length);
    }
}
