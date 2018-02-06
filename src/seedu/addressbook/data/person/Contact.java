package seedu.addressbook.data.person;


public class Contact {

    public final String value;
    private boolean isPrivate;

    public Contact (String address, boolean isPrivate) {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;

        this.value = trimmedAddress;
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == null // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}