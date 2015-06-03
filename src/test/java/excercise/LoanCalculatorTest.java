package excercise;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class LoanCalculatorTest {

    private static double delta = 1e-2;

    private static LoanRequest loanRequest;

    private static List<ScheduledAmortizationPayment> paymentsTestData = new LinkedList<ScheduledAmortizationPayment>();

    private static LoanMonthlyPayment loanMonthlyPaymentsTestData;

    @BeforeClass
    public static void setUp() throws Exception {
        loanRequest = new LoanRequest(1000, 10, 1);

        paymentsTestData.add(new ScheduledAmortizationPayment(0, 0d, 0d, 1000d, 0d, 0d));
        paymentsTestData.add(new ScheduledAmortizationPayment(1, 87.92d, 8.33d, 920.42d, 87.92d, 8.33d));
        paymentsTestData.add(new ScheduledAmortizationPayment(2, 87.920d, 7.67d, 840.17d, 175.83d, 16.00d));
        paymentsTestData.add(new ScheduledAmortizationPayment(3, 87.92d, 7d, 759.26d, 263.75d, 23.00d));
        paymentsTestData.add(new ScheduledAmortizationPayment(4, 87.92d, 6.33d, 677.67d, 351.66d, 29.33d));
        paymentsTestData.add(new ScheduledAmortizationPayment(5, 87.92d, 5.65d, 595.40d, 439.58d, 34.98d));
        paymentsTestData.add(new ScheduledAmortizationPayment(6, 87.92d, 4.96d, 512.45d, 527.50d, 39.94d));
        paymentsTestData.add(new ScheduledAmortizationPayment(7, 87.92d, 4.27d, 428.80d, 615.41d, 44.21d));
        paymentsTestData.add(new ScheduledAmortizationPayment(8, 87.92d, 3.57d, 344.46d, 703.33d, 47.78d));
        paymentsTestData.add(new ScheduledAmortizationPayment(9, 87.92, 2.87d, 259.41d, 791.24d, 50.66d));
        paymentsTestData.add(new ScheduledAmortizationPayment(10, 87.92d, 2.16d, 173.66d, 879.16d, 52.82d));
        paymentsTestData.add(new ScheduledAmortizationPayment(11, 87.92d, 1.45d, 87.19d, 967.07d, 54.26d));
        paymentsTestData.add(new ScheduledAmortizationPayment(12, 87.92d, 0.73d, 0.00d, 1054.99d, 54.99d));

        loanMonthlyPaymentsTestData = new LoanMonthlyPayment(0.0083d, 87.9158d);
    }

    @Test
    public void testCalculateAmortizationSchedule() throws Exception {
        List<ScheduledAmortizationPayment> payments = new LoanCalculator(loanRequest).calculateAmortizationSchedule();
        for (int i = 0; i < payments.size(); i++) {
            assertEquals(payments.get(i).getCurrentBalance(), paymentsTestData.get(i).getCurrentBalance(), delta);
            assertEquals(payments.get(i).getPaymentAmount(), paymentsTestData.get(i).getPaymentAmount(), delta);
            assertEquals(payments.get(i).getPaymentInterest(), paymentsTestData.get(i).getPaymentInterest(), delta);
            assertEquals(payments.get(i).getPaymentNumber(), paymentsTestData.get(i).getPaymentNumber(), delta);
            assertEquals(payments.get(i).getTotalInterestPaid(), paymentsTestData.get(i).getTotalInterestPaid(), delta);
            assertEquals(payments.get(i).getTotalPayments(), paymentsTestData.get(i).getTotalPayments(), delta);
        }
    }

    @Test
    public void testCalculateMonthlyPayment() throws Exception {
        delta = 1e-4;
        LoanMonthlyPayment loanMonthlyPayments = new LoanCalculator(loanRequest).calculateMonthlyPayment();
        assertEquals(loanMonthlyPayments.getMonthlyInterest(), loanMonthlyPaymentsTestData.getMonthlyInterest(), delta);
        assertEquals(loanMonthlyPayments.getMonthlyPayment(), loanMonthlyPaymentsTestData.getMonthlyPayment(), delta);
    }

    @Test
    public void testEqualsAndHashCodeScheduledAmortizationPayment() throws Exception {
        EqualsVerifier.forClass(ScheduledAmortizationPayment.class)
            .verify();
    }

    @Test
    public void testEqualsAndHashCodeLoanMonthlyPayment() throws Exception {
        EqualsVerifier.forClass(LoanMonthlyPayment.class)
            .verify();
    }
}