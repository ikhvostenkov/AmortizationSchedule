package excercise;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class ConsoleIOTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final ConsoleIO consoleIO = new ConsoleIO();

    @Test
    public void testReadLine() throws Exception {
        System.setIn(new ByteArrayInputStream("test".getBytes()));
        InputStream savedStandardInputStream = System.in;
        assertEquals(consoleIO.readLine("Test userprompt"), "test");
    }

    @Test
    public void testPrint() throws Exception {
        System.setOut(new PrintStream(outContent));
        consoleIO.print("test out");
        assertEquals("test out", outContent.toString());
    }

    @Test
    public void testPrintf() throws Exception {
        System.setOut(new PrintStream(outContent));
        consoleIO.printf("test out %d", 666);
        assertEquals("test out 666", outContent.toString());
    }
}