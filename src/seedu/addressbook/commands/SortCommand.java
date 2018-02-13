package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort the record in lexicographical order by  name.\n"
            + "Example: " + COMMAND_WORD;


    public SortCommand(){

    }

    @Override
    public CommandResult execute(){
        List<? extends ReadOnlyPerson> sortedPersons = new ArrayList<>(
                addressBook.getAllPersons().immutableListView());
        sortedPersons.sort(new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                if(o1 == null){
                    if(o2 == null){
                        return 0;
                    } else {
                        return -1;
                    }
                } else if (o2 == null ) {
                    return 1;
                } else {
                    return o1.getName().fullName.compareTo(o2.getName().fullName);
                }
            }
        });
        return new CommandResult( getMessageForPersonListShownSummary(sortedPersons),
                sortedPersons);
    }
}
