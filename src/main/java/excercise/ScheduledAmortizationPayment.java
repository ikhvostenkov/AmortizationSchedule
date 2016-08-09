package excercise;

import lombok.EqualsAndHashCode;

/**
 * Scheduled amortization payment DTO.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
@EqualsAndHashCode
public final class ScheduledAmortizationPayment {

    /**
     * Payment sequence number.
     */
    private final int paymentNumber;

    /**
     * Payment amount.
     */
    private final double paymentAmount;

    /**
     * Payment interest.
     */
    private final double paymentInterest;

    /**
     * Current balance.
     */
    private final double currentBalance;

    /**
     * Total payments.
     */
    private final double totalPayments;

    /**
     * Total paid interest.
     */
    private final double totalInterestPaid;

    /**
     * Ctor.
     *
     * @param paymentNumber     Payment sequence number
     * @param paymentAmount     Payment amount
     * @param paymentInterest   Payment interest
     * @param currentBalance    Current balance
     * @param totalPayments     Total payments
     * @param totalInterestPaid Total paid interest
     */
    public ScheduledAmortizationPayment(int paymentNumber, double paymentAmount,
                                        double paymentInterest, double currentBalance, double totalPayments, double totalInterestPaid) {
        this.paymentNumber = paymentNumber;
        this.paymentAmount = paymentAmount;
        this.paymentInterest = paymentInterest;
        this.currentBalance = currentBalance;
        this.totalPayments = totalPayments;
        this.totalInterestPaid = totalInterestPaid;
    }

    /**
     * Get payment sequence number.
     *
     * @return Payment sequence number
     */
    public int getPaymentNumber() {
        return this.paymentNumber;
    }

    /**
     * Get payment amount.
     *
     * @return Payment amount
     */
    public double getPaymentAmount() {
        return this.paymentAmount;
    }

    /**
     * Get payment interest.
     *
     * @return Payment interest
     */
    public double getPaymentInterest() {
        return this.paymentInterest;
    }

    /**
     * Get current balance.
     *
     * @return Current balance
     */
    public double getCurrentBalance() {
        return this.currentBalance;
    }

    /**
     * Get total payments.
     *
     * @return Total payments
     */
    public double getTotalPayments() {
        return this.totalPayments;
    }

    /**
     * Get total paid interest.
     *
     * @return Total paid interest
     */
    public double getTotalInterestPaid() {
        return totalInterestPaid;
    }
}
