package seedu.addressbook.data.person;


/**
 * Represents a Person's postal code in the address.
 *
 */
public class PostalCode {

    public static final String EXAMPLE = "#12 - 34";

    public final String value;
    private boolean isPrivate;

    /**
     * Constructor
     *
     */
    public PostalCode(String post, boolean isPrivate) {
        String trimmedValue = post.trim();
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
