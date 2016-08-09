package excercise;

import com.google.common.collect.Range;
import excercise.Parser.DoubleParser;
import excercise.Parser.IntParser;
import excercise.Parser.Parser;

import static excercise.AmortizationConstants.*;

/**
 * User loan request received from console.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class ConsoleUserLoanRequest implements UserLoanRequest {

    /**
     * Console.
     */
    private ConsoleIO consoleIO = new ConsoleIO();

    /**
     * Ctor.
     *
     * @param consoleIO Console for input/output
     */
    public ConsoleUserLoanRequest(ConsoleIO consoleIO) {
        this.consoleIO = consoleIO;
    }

    /**
     * New request to get a loan.
     *
     * @return Loan request object
     */
    public LoanRequest getUserLoanRequest() {
        double amountBorrowed = getUserInput(Range.closed(
                BORROW_AMOUNT_RANGE[0], BORROW_AMOUNT_RANGE[1]
            ), BORROW_AMOUNT_PROMPT_MSG, new DoubleParser()
        );
        double apr = getUserInput(
            Range.closed(
                APR_RANGE[0], APR_RANGE[1]
            ), APR_PROMPT_MSG, new DoubleParser()
        );
        int years = getUserInput(
            Range.closed(
                TERM_RANGE[0], TERM_RANGE[1]
            ), TERM_PROMPT_MSG, new IntParser()
        );

        return new LoanRequest(amountBorrowed, apr, years);
    }

    /**
     * Get and parse user console input.
     *
     * @param range      Input value valid range
     * @param userPrompt User prompt message
     * @param parser     Input value parser
     * @param <T>        Value type
     * @return Value of the defined type
     */
    private <T extends Comparable<T>> T getUserInput(Range range, String userPrompt, Parser<T> parser) {
        T value = null;
        String input;
        boolean isValidValue = false;
        while (!isValidValue) {
            input = this.consoleIO.readLine(userPrompt);
            try {
                value = parser.parse(input);
            } catch (NumberFormatException e) {
                this.consoleIO.print(INVALID_VALUE_MSG + "\n");
                continue;
            }
            if (!range.contains(value)) {
                this.consoleIO.print(INVALID_VALUE_MSG);
                this.consoleIO.printf(
                    NOT_IN_RANGE_MSG, range.lowerEndpoint().toString(),
                    range.upperEndpoint().toString()
                );
            } else {
                isValidValue = true;
            }
        }
        return value;
    }
}
