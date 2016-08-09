package excercise;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Objects;

import static excercise.AmortizationConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
@RunWith(Theories.class)
public class ConsoleUserLoanRequestTest {

    @Mock
    private ConsoleIO consoleIO;

    @DataPoints
    public static String[][] validData = new String[][]{
        {"0.01", "0.000001", "1"},
        {"100000", "10", "10000"},
        {"1000000000000", "100", "1000000"},
        {"2.22", "0.999999", "555"},
        {"100000.9999", "10.99", "999999"},
        {"100000000000.9", "66.6", "000047"},
        {"33333333.3333333", "0.999999", "555"},
        {"100000.9999", "10.99", "999999"},
        {"999999999999.9", "99.9", "999999"}
    };

    @DataPoints
    public static Double [][] invalidData = new Double[][]{
        {0.0099d, 0.00000099d, 0d},
        {10000000000001d, 101d, 1000001d}
    };

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Theory
    public void testGetUserLoanRequest(String[] testData) throws Exception {
        String borrowAmount = testData[0];
        String apr = testData[1];
        String termInYears = testData[2];
        when(consoleIO.readLine(BORROW_AMOUNT_PROMPT_MSG)).thenReturn(borrowAmount);
        when(consoleIO.readLine(APR_PROMPT_MSG)).thenReturn(apr);
        when(consoleIO.readLine(TERM_PROMPT_MSG)).thenReturn(termInYears);
        LoanRequest loanRequest = new LoanRequest(Double.parseDouble(borrowAmount),
            Double.parseDouble(apr), Integer.parseInt(termInYears));
        assertEquals(new ConsoleUserLoanRequest(consoleIO).getUserLoanRequest(), loanRequest);
    }

    @Theory
    public void testGetUserLoanRequest(Double[] testData) throws Exception {
        String borrowAmount = testData[0].toString();
        String apr = testData[1].toString();
        String termInYears = String.valueOf(testData[2].intValue());
        when(consoleIO.readLine(BORROW_AMOUNT_PROMPT_MSG)).thenReturn(borrowAmount, "5");
        when(consoleIO.readLine(APR_PROMPT_MSG)).thenReturn(apr, "6");
        when(consoleIO.readLine(TERM_PROMPT_MSG)).thenReturn(termInYears, "7");
        new ConsoleUserLoanRequest(consoleIO).getUserLoanRequest();
        verify(consoleIO, times(3)).print(INVALID_VALUE_MSG);
        verify(consoleIO, times(3)).printf(anyString(), anyObject(), anyObject());
    }

    @Test
    public void testNumberFormatException() throws Exception{
        when(consoleIO.readLine(anyString())).thenReturn("", "5", "5", "5");
        new ConsoleUserLoanRequest(consoleIO).getUserLoanRequest();
        verify(consoleIO, times(1)).print(INVALID_VALUE_MSG + "\n");
        verify(consoleIO, never()).printf(anyString());
    }

    @Test
    public void testEqualsAndHashCodeLoanRequest() throws Exception {
        EqualsVerifier.forClass(LoanRequest.class)
            .verify();
    }
}