package excercise.Parser;

/**
 * Parse input value as double value.
 * <p/>
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class DoubleParser implements Parser<Double> {

    /**
     * Parse input value.
     *
     * @param value Value to parse
     * @return Parsed double value.
     */
    public Double parse(String value) {
        return Double.parseDouble(value);
    }
}
