package excercise;

import java.util.List;

/**
 * Amortization schedule console printer.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class AmortizationScheduleConsolePrinter implements AmortizationSchedulePrinter {

    /**
     * Console.
     */
    private static final ConsoleIO CONSOLE = new ConsoleIO();

    /**
     * Print amortization schedule in console.
     * <p/>
     * The output includes:
     * The first column identifies the payment number.
     * The second column contains the amount of the payment.
     * The third column shows the amount paid to interest.
     * The fourth column has the current balance. The total payment amount and the
     * interest paid fields.
     *
     * @param payments List of scheduled amortization payments to be printed
     */
    public void printAmortizationSchedule(List<ScheduledAmortizationPayment> payments) {
        String formatString = "%1$-20s%2$-20s%3$-20s%4$s,%5$s,%6$s\n";
        CONSOLE.printf(formatString, "PaymentNumber", "PaymentAmount", "PaymentInterest",
            "CurrentBalance", "TotalPayments", "TotalInterestPaid");
        formatString = "%1$-20d%2$-20.2f%3$-20.2f%4$.2f,%5$.2f,%6$.2f\n";
        for (ScheduledAmortizationPayment payment : payments) {
            CONSOLE.printf(formatString, payment.getPaymentNumber(), payment.getPaymentAmount(),
                payment.getPaymentInterest(), payment.getCurrentBalance(),
                payment.getTotalPayments(), payment.getTotalInterestPaid()
            );
        }
    }
}
