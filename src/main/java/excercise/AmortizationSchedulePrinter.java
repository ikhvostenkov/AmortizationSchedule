package excercise;

import java.util.List;

/**
 * Amortization schedule printer.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public interface AmortizationSchedulePrinter {

    /**
     * Prints amortization schedule.
     *
     * @param payments List of payments to be printed
     */
    public void printAmortizationSchedule(List<ScheduledAmortizationPayment> payments);
}
