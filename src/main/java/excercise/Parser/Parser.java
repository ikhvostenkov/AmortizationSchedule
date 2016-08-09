package excercise.Parser;

/**
 * Input string parser.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public interface Parser<T> {

    /**
     * Parse input string.
     *
     * @param value Value to parse
     * @param <T>   Defined value type
     * @return Validated value of the defined type.
     */
    public <T> T parse(String value);
}
