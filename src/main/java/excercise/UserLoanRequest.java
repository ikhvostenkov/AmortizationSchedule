package excercise;

/**
 * User loan request.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public interface UserLoanRequest {

    /***
     * New request to get a loan.
     *
     * @return Loan request object
     */
    public LoanRequest getUserLoanRequest();
}
