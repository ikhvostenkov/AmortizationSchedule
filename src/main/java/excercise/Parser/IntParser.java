package excercise.Parser;

/**
 * Parse input value as integer value.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class IntParser implements Parser<Integer> {

    /**
     * Parse input value.
     *
     * @param value Value to parse
     * @return Parsed integer value
     */
    public Integer parse(String value) {
        return Integer.parseInt(value);
    }
}
