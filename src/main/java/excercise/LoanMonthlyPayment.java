package excercise;

import lombok.EqualsAndHashCode;

/**
 * Loan monthly payment DTO.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
@EqualsAndHashCode
public final class LoanMonthlyPayment {

    /**
     * Monthly interest.
     */
    private final double monthlyInterest;

    /**
     * Monthly payment.
     */
    private final double monthlyPayment;

    /**
     * Ctor.
     *
     * @param monthlyInterest Monthly interest
     * @param monthlyPayment  Monthly payment
     */
    public LoanMonthlyPayment(double monthlyInterest, double monthlyPayment) {
        this.monthlyInterest = monthlyInterest;
        this.monthlyPayment = monthlyPayment;
    }

    /**
     * Get monthly interest.
     *
     * @return Monthly interest
     */
    public double getMonthlyInterest() {
        return this.monthlyInterest;
    }

    /**
     * Get monthly payment.
     *
     * @return Monthly payment
     */
    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

}
