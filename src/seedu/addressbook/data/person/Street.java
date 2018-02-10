package seedu.addressbook.data.person;

/**
 * Represents a Person's street name in the address.
 *
 */
public class Street {

    public static final String EXAMPLE = "Somerset Rd.";

    public final String value;
    private boolean isPrivate;

    /**
     * Constructor
     *
     */
    public Street(String street, boolean isPrivate) {
        String trimmedValue = street.trim();
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
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
