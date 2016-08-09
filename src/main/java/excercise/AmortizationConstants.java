package excercise;

/**
 * App constants.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public final class AmortizationConstants {

    public static final double[] BORROW_AMOUNT_RANGE = new double[]{0.01d, 1000000000000d};
    public static final double[] APR_RANGE = new double[]{0.000001d, 100d};
    public static final int[] TERM_RANGE = new int[]{1, 1000000};
    public static final double MONTHLY_INTEREST_DIVISOR = 12d * 100d;
    public static final String BORROW_AMOUNT_PROMPT_MSG = "Please enter the amount you would like to borrow: ";
    public static final String APR_PROMPT_MSG = "Please enter the annual percentage rate used to repay the loan: ";
    public static final String TERM_PROMPT_MSG = "Please enter the term, in years, over which the loan is repaid: ";
    public static final String IO_EXCEPTION_MSG = "An IOException was encountered. Terminating program.\n";
    public static final String INVALID_VALUE_MSG = "An invalid value was entered. ";
    public static final String NOT_IN_RANGE_MSG = "Please enter a positive value between %1$s and %2$s.\n";
}
