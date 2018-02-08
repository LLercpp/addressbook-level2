package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-3, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Person addresses should be in the format of block, street, unit, postal code";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode post;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        init(trimmedAddress);
    }


    private void init (String trimmedAddress){
        String[] components = trimmedAddress.split(", ");
        block = new Block (components[0].trim(), isPrivate);
        street = new Street (components[1].trim(), isPrivate);
        unit = new Unit (components[2].trim(), isPrivate);
        post = new PostalCode(components[3].trim(), isPrivate);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.toString() + ", " + street.toString() + ", " +
                unit.toString() + ", " + post.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
