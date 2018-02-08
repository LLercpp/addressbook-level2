package seedu.addressbook.data.person;


/**
 * Represents a Person's unit number in the address.
 *
 */
public class Unit {

    public static final String EXAMPLE = "#12 - 34";

    public final String value;
    private boolean isPrivate;

    /**
     * Constructor
     *
     */
    public Unit(String unit, boolean isPrivate) {
        String trimmedValue = unit.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedValue;
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
