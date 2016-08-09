package excercise;

/**
 * Start application.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class App {

    public static void main(String[] args) {
        LoanRequest loanRequest = new ConsoleUserLoanRequest(new ConsoleIO()).getUserLoanRequest();
        AmortizationScheduleConsolePrinter as = new AmortizationScheduleConsolePrinter();
        as.printAmortizationSchedule(new LoanCalculator(loanRequest).calculateAmortizationSchedule());
    }
}
