package seedu.addressbook.commands;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort the record according to name.\n"
            + "Example: " + COMMAND_WORD;
    public static final String SORT_COMPLETED_ACKNOWEDGEMENT = "Sorting Address Book as requested ...";
}
