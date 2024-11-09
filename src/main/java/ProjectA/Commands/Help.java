package ProjectA.Commands;
import java.util.HashMap;
import java.util.Map;

public class Help extends Abstract{
    private final HashMap<String, Abstract> actionCommands;

    public Help(HashMap<String, Abstract> actionCommands) {
        this.actionCommands = actionCommands;
    }

    public String getDescription() {
        return "List of commands";
    }

    public String getMessage() {
        StringBuilder msg = new StringBuilder("Look my commands:\n");
        for (Map.Entry<String, Abstract> entry : actionCommands.entrySet()) {
            String commandText = entry.getKey();
            String description = entry.getValue().getDescription();
            msg.append(commandText).append(" - ").append(description).append("\n");
        }
        return msg.toString();
    }

}
