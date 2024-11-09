package ProjectA;

import ProjectA.Commands.*;
import java.util.HashMap;
import java.util.Set;

public class ListCommands {
    private final HashMap<String, Abstract> commandHashMap = new HashMap<String, Abstract>();

    public ListCommands(){
        commandHashMap.put("/information", new Information());
        commandHashMap.put("/start", new Start());
        commandHashMap.put("/creators", new Creators());
        commandHashMap.put("/help", new Help(commandHashMap));
    }

    public String findCommand(String text){
        if (commandHashMap.containsKey(text)) {
            commandHashMap.get(text);
            return commandHashMap.get(text).getMessage();
        }
        Set obEntrySet = commandHashMap.entrySet();
        System.out.println(obEntrySet);
        return "Command not found";
    }
}
