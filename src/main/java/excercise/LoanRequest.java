package excercise;

import lombok.EqualsAndHashCode;

/**
 * Loan request DTO.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
@EqualsAndHashCode
public final class LoanRequest {

    /**
     * Borrowed amount.
     */
    private final double amountBorrowed;

    /**
     * Annual percentage rate.
     */
    private final double apr;

    /**
     * Term in years.
     */
    private final int termInYears;

    /**
     * Term in months.
     */
    private final int termInMonths;

    /**
     * Ctor.
     *
     * @param amountBorrowed Borrowed amount
     * @param apr            Annual percentage rate
     * @param termInYears    Term in years
     */
    public LoanRequest(double amountBorrowed, double apr, int termInYears) {
        this.amountBorrowed = amountBorrowed;
        this.apr = apr;
        this.termInYears = termInYears;
        this.termInMonths = termInYears * 12;
    }

    /**
     * Get borrowed amount.
     *
     * @return Borrowed amount
     */
    public double getAmountBorrowed() {
        return this.amountBorrowed;
    }

    /**
     * Get annual percentage rate.
     *
     * @return Annual percentage rate
     */
    public double getApr() {
        return this.apr;
    }

    /**
     * Get term in years.
     *
     * @return Term in years
     */
    public int getTermInYears() {
        return this.termInYears;
    }

    /**
     * Get term in months.
     *
     * @return Term in months
     */
    public int getTermInMonths() {
        return this.termInMonths;
    }
}
