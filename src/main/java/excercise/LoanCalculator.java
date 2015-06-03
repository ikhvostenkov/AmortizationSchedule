package excercise;

import java.util.LinkedList;
import java.util.List;

import static excercise.AmortizationConstants.MONTHLY_INTEREST_DIVISOR;

/**
 * Loan calculator.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class LoanCalculator {

    /**
     * Loan request.
     */
    private LoanRequest loanRequest;

    /**
     * Ctor.
     *
     * @param loanRequest Loan request
     */
    public LoanCalculator(LoanRequest loanRequest) {
        this.loanRequest = loanRequest;
    }

    /**
     * Calculate amortization schedule.
     * <p/>
     * Calculate H = P x J, this is your current monthly interest.
     * Calculate C = M - H, this is your monthly payment minus your monthly
     * interest,so it is the amount of principal you pay for that month.
     * Calculate Q = P - C, this is the new balance of your principal of your loan.
     *
     * @return List of scheduled amortization payments
     */
    public List<ScheduledAmortizationPayment> calculateAmortizationSchedule() {
        final int maxNumberOfPayments = loanRequest.getTermInMonths() + 1;
        LoanMonthlyPayment loanMonthlyPayment = this.calculateMonthlyPayment();
        int paymentNumber = 0;
        double totalPayments = 0;
        double totalInterestPaid = 0;
        double balance = loanRequest.getAmountBorrowed();
        List<ScheduledAmortizationPayment> payments = new LinkedList<ScheduledAmortizationPayment>();
        payments.add(new ScheduledAmortizationPayment(paymentNumber++, 0d, 0d, balance, 0d, 0d));
        while ((balance > 0) && (paymentNumber <= maxNumberOfPayments)) {
            double curMonthlyInterest = balance * loanMonthlyPayment.getMonthlyInterest();
            double curPayoffAmount = balance + curMonthlyInterest;
            double curMonthlyPaymentAmount = Math.min(loanMonthlyPayment.getMonthlyPayment(),
                curPayoffAmount);
            if ((paymentNumber == maxNumberOfPayments)
                && ((curMonthlyPaymentAmount == 0) || (curMonthlyPaymentAmount == curMonthlyInterest))) {
                curMonthlyPaymentAmount = curPayoffAmount;
            }
            double curMonthlyPrincipalPaid = curMonthlyPaymentAmount - curMonthlyInterest;
            double curBalance = balance - curMonthlyPrincipalPaid;
            totalPayments += curMonthlyPaymentAmount;
            totalInterestPaid += curMonthlyInterest;
            payments.add(new ScheduledAmortizationPayment(
                    paymentNumber++, curMonthlyPaymentAmount, curMonthlyInterest,
                    curBalance, totalPayments, totalInterestPaid
                )
            );
            balance = curBalance;
        }
        return payments;
    }

    /**
     * Calculate loan monthly payment.
     * <p/>
     * M = P * (J / (1 - (Math.pow(1/(1 + J), N)))).
     * Where:
     * P = Principal.
     * I = Interest.
     * J = Monthly Interest in decimal form: I / (12 * 100).
     * N = Number of months of loan.
     * M = Monthly Payment Amount.
     * Calculate J.
     *
     * @return Loan monthly payment
     */
    public LoanMonthlyPayment calculateMonthlyPayment() {
        double monthlyInterest = loanRequest.getApr() / MONTHLY_INTEREST_DIVISOR;
        double tmp = Math.pow(1d + monthlyInterest, -1);
        tmp = Math.pow(tmp, loanRequest.getTermInMonths());
        tmp = Math.pow(1d - tmp, -1);
        return new LoanMonthlyPayment(
            monthlyInterest, loanRequest.getAmountBorrowed() * monthlyInterest * tmp
        );
    }
}
