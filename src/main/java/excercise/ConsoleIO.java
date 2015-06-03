package excercise;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;

import static excercise.AmortizationConstants.IO_EXCEPTION_MSG;

/**
 * Console input/output.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class ConsoleIO {

    /**
     * Console.
     */
    private static final Console CONSOLE = System.console();

    /**
     * Read user input line.
     *
     * @param userPrompt User prompt
     * @return Line.
     */
    public String readLine(String userPrompt) {
        String line = "";
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));
        print(userPrompt);
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            print(IO_EXCEPTION_MSG);
        }
        line.trim();
        return line;
    }

    /**
     * Print message to console.
     *
     * @param message Message to be printed
     */
    public void print(String message) {
        printf("%s", message);
    }

    /**
     * Print message with parameters.
     *
     * @param formatString Message format
     * @param params       Parameters
     */
    public void printf(String formatString, Object... params) {
        try {
            if (ConsoleIO.CONSOLE != null) {
                ConsoleIO.CONSOLE.printf(formatString, params);
            } else {
                System.out.print(String.format(formatString, params));
            }
        } catch (IllegalFormatException e) {
            System.err.print("Error printing...\n");
        }
    }
}
